import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class Admin {

    public Admin() throws IOException, TimeoutException {
        // info
        System.out.println("Starting Admin");

        Channel channel = initializeChannel();
        handleAll(channel);
        send(channel);
    }

    private Channel initializeChannel() throws IOException, TimeoutException {
        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);

        // exchange
        channel.exchangeDeclare("orders", BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare("confirmations", BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare("admin", BuiltinExchangeType.TOPIC);
        return channel;
    }

    private void handleAll(Channel channel) throws IOException {
        // queue & bind
        String queueName = channel.queueDeclare("admin", true, false, false, null).getQueue();
        channel.queueBind(queueName, "orders", "#");
        channel.queueBind(queueName, "confirmations", "#");
        System.out.println("created queue: " + queueName);

        // consumer (message handling)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Received: " + message);

                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        // start listening
        channel.basicConsume(queueName, false, consumer);
    }

    private void send(Channel channel) throws IOException {
        while (true) {
            // read order
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Choose instruction: ");
            System.out.println("1. Send to all");
            System.out.println("2. Send to Agencies");
            System.out.println("3. Send to Carriers");
            System.out.println("4. Exit");
            String instruction = br.readLine();

            if (Objects.equals(instruction, "4")) {
                System.exit(0);
            }

            if (!Objects.equals(instruction, "1") && !Objects.equals(instruction, "2") && !Objects.equals(instruction, "3")) {
                continue;
            }

            System.out.println("Message: ");
            String message = br.readLine();

            switch (instruction) {
                case "1" -> channel.basicPublish("admin", "all", null, message.getBytes(StandardCharsets.UTF_8));
                case "2" -> channel.basicPublish("admin", "agencies", null, message.getBytes(StandardCharsets.UTF_8));
                case "3" -> channel.basicPublish("admin", "carriers", null, message.getBytes(StandardCharsets.UTF_8));
            }

            System.out.println("Sent: " + message);
        }
    }


    public static void main(String[] argv) throws IOException, TimeoutException {
        new Admin();
    }
}
