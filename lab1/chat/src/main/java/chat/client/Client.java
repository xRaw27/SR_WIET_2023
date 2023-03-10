package chat.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private final String serverHostName;
    private final int serverPortNumber;
    private final BufferedReader stdin;
    private String clientNick;

    public Client(String serverHostName, int serverPortNumber) {
        this.serverHostName = serverHostName;
        this.serverPortNumber = serverPortNumber;
        this.stdin = new BufferedReader(new InputStreamReader(System.in));
    }

    public void runClient() {
        System.out.println("CLIENT START");

        try (Socket socket = new Socket(serverHostName, serverPortNumber)) {

            // in & out streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // connect
            System.out.print("Client nickname: ");
            clientNick = stdin.readLine();
            out.println(clientNick);

            while (true) {
                String msg = in.readLine();
                System.out.println(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
