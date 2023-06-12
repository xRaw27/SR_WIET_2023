package rabbitmqlab;

import com.rabbitmq.client.*;

import java.io.IOException;

public class ZAD1A_Consumer {
    public static void main(String[] argv) throws Exception {

        // info
        System.out.println("ZAD1A CONSUMER");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // queue
        String QUEUE_NAME = "queue1";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // consumer (message handling)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Time to sleep: " + message);
                int timeToSleep = Integer.parseInt(message);
                try {
                    Thread.sleep(timeToSleep * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("done");

                // Po przetworzeniu wiadomości
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        // start listening
        System.out.println("Waiting for messages...");

        // Po otrzymaniu wiadomości
        // channel.basicConsume(QUEUE_NAME, true, consumer);
        // Po przetworzeniu wiadomości
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // close
        // channel.close();
        // connection.close();
    }
}
