package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerClient extends Thread{
    private final Server server;
    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;
    private String nick;

    public ServerClient(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.nick = in.readLine();

        System.out.println("New server client: {\n  socket: " + this.socket + "\n  nick: " + this.nick + "\n}");
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = in.readLine();

                if (msg == null || msg.equals("Q")) {
                    server.disconnect(this);
                    System.out.println("Client disconnected: {\n  socket: " + this.socket + "\n  nick: " + this.nick + "\n}");
                    break;
                }

                System.out.println(msg);
            }

            socket.close();

        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void send(String msg, String nick) {
        out.println("[" + nick + "] " + msg);
    }
}
