import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

public class Carrier {
    private final String name;
    private static final String[] ORDER_TYPES = {"people", "cargo", "satellite"};

    public Carrier(String name, String service1, String service2) throws IOException, TimeoutException {
        this.name = name;

        // info
        System.out.println("Starting Carrier: " + name);
        System.out.println("Available services: " + service1 + ", " + service2);

        Channel channel = initializeChannel();
        handleOrders(channel, service1, service2);
        handleAdmin(channel);
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

    private void handleOrders(Channel channel, String service1, String service2) throws IOException {
        // queues & bind
        String queueName1 = channel.queueDeclare(service1, true, false, false, null).getQueue();
        channel.queueBind(queueName1, "orders", service1);
        System.out.println("created queue: " + queueName1);

        String queueName2 = channel.queueDeclare(service2, true, false, false, null).getQueue();
        channel.queueBind(queueName2, "orders", service2);
        System.out.println("created queue: " + queueName2);

        // consumer (message handling)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Received: " + message);

                channel.basicAck(envelope.getDeliveryTag(), false);

                System.out.println("Order done");

                // confirm
                String confirmMessage = "Carrier " + name + " confirms order {" + message + "}";
                String replyTo = properties.getReplyTo();
                channel.basicPublish("confirmations", replyTo, null, confirmMessage.getBytes(StandardCharsets.UTF_8));

                System.out.println("Sent confirm: " + message);
            }
        };

        // start listening
        channel.basicConsume(queueName1, false, consumer);
        channel.basicConsume(queueName2, false, consumer);
    }

    private void handleAdmin(Channel channel) throws IOException {
        // queue & bind
        String queueName = channel.queueDeclare("admin." + name, true, false, false, null).getQueue();
        channel.queueBind(queueName, "admin", "carriers");
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

    public static void main(String[] argv) throws Exception {
        if (argv.length == 0) {
            System.out.println("Missing argv[0] with agency name!");
        }
        if (argv.length == 1) {
            System.out.println("Missing argv[1] with service1!");
        }
        if (argv.length == 2) {
            System.out.println("Missing argv[2] with service2!");
        } else {
            if (!Arrays.asList(ORDER_TYPES).contains(argv[1])) {
                System.out.println("Unsupported service (service1)!");
            } else if (!Arrays.asList(ORDER_TYPES).contains(argv[2])) {
                System.out.println("Unsupported service (service2)!");
            } else {
                new Carrier(argv[0], argv[1], argv[2]);
            }
        }
    }
}
