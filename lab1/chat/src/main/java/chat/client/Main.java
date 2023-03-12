package chat.client;

import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
        try {
            Client client = new Client("localhost", 12345, "225.1.2.3", 23456);
            client.runClient();
        } catch (UnknownHostException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }
}