package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
    private final int portNumber;
    private final List<ServerClient> serverClients = Collections.synchronizedList(new ArrayList<>());

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public void runServer() {
        System.out.println("SERVER START");

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {

                // accept client
                Socket clientSocket = serverSocket.accept();
//                System.out.println("New client connected: {\n  socket:" + clientSocket + "\n  nick: " + );

                ServerClient serverClient = new ServerClient(this, clientSocket);
                serverClients.add(serverClient);
                serverClient.start();
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void disconnect(ServerClient serverClient) {
        serverClients.remove(serverClient);
        System.out.println(serverClients);
    }

    public void send(ServerClient sender, String msg, String nick) {
        synchronized (serverClients) {
            serverClients.forEach(serverClient -> {
                if (serverClient == sender) return;
                serverClient.send(msg, nick);
            });
        }
    }

}
