import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

public class Agency {
    private final String name;
    private static final String[] ORDER_TYPES = {"people", "cargo", "satellite"};

    public Agency(String name) throws IOException, TimeoutException {
        this.name = name;

        // info
        System.out.println("Starting Agency: " + name);

        Channel channel = initializeChannel();
        handleConfirmations(channel);
        handleAdmin(channel);
        makeOrders(channel);
    }

    private Channel initializeChannel() throws IOException, TimeoutException {
        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);

        // exchanges
        channel.exchangeDeclare("orders", BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare("confirmations", BuiltinExchangeType.TOPIC);
        channel.exchangeDeclare("admin", BuiltinExchangeType.TOPIC);
        return channel;
    }

    private void makeOrders(Channel channel) throws IOException {
        while (true) {
            // read order
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter order type: ");
            String orderType = br.readLine();

            // break condition
            if ("exit".equals(orderType)) {
                System.exit(0);
            }

            if (!Arrays.asList(ORDER_TYPES).contains(orderType)) {
                System.out.println("Unsupported order type!");
                continue;
            }

            System.out.println("Enter order id: ");
            String orderId = br.readLine();

            String message = "Order " + orderId + " for service " + orderType + " from " + name;

            // publish
            channel.basicPublish("orders", orderType, new AMQP.BasicProperties.Builder().replyTo(name).build(), message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent: " + message);
        }
    }

    private void handleConfirmations(Channel channel) throws IOException {
        // queue & bind
        String queueName = channel.queueDeclare("confirm." + name, true, false, false, null).getQueue();
        channel.queueBind(queueName, "confirmations", name);
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

    private void handleAdmin(Channel channel) throws IOException {
        // queue & bind
        String queueName = channel.queueDeclare("admin." + name, true, false, false, null).getQueue();
        channel.queueBind(queueName, "admin", "agencies");
        channel.queueBind(queueName, "admin", "all");
        System.out.println("created queue: " + queueName);

        // consumer (message handling)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Admin: " + message);

                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        // start listening
        channel.basicConsume(queueName, false, consumer);
    }

    public static void main(String[] argv) throws IOException, TimeoutException {
        if (argv.length == 0) {
            System.out.println("Missing argv[0] with agency name!");
        } else {
            new Agency(argv[0]);
        }
    }
}
