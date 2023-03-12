package chat.server;

import java.io.IOException;
import java.net.DatagramSocket;
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
        try (
                ServerSocket tcpServerSocket = new ServerSocket(portNumber);
                DatagramSocket udpServerSocket = new DatagramSocket(portNumber)
        ) {
            System.out.println("UDP channel [port: " + portNumber + "] is starting...");
            ServerUdp serverUdp = new ServerUdp(this, udpServerSocket);
            serverUdp.start();

            while (true) {
                Socket clientSocket = tcpServerSocket.accept();
                ServerClient serverClient = new ServerClient(this, clientSocket, udpServerSocket);
                connect(serverClient);
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void connect(ServerClient serverClient) {
        serverClients.add(serverClient);
        System.out.println(serverClients);
        serverClient.start();
    }
    public void disconnect(ServerClient serverClient) {
        serverClients.remove(serverClient);
        System.out.println(serverClients);
    }

    public ServerClient getServerClientByPort(int port) {
        synchronized (serverClients) {
            return serverClients.stream()
                    .filter(serverClient -> serverClient.getClientPort() == port)
                    .findFirst()
                    .orElse(null);
        }
    }

    public void sendTcp(ServerClient sender, String msg, String nick) {
        synchronized (serverClients) {
            serverClients.stream()
                    .filter(serverClient -> !serverClient.equals(sender))
                    .forEach(serverClient -> serverClient.sendTcp(msg, nick));
        }
    }

    public void sendUdp(int senderPort, String msg) {
        ServerClient sender = getServerClientByPort(senderPort);
        if (sender == null) return;
        String nick = sender.getNick();

        synchronized (serverClients) {
            serverClients.stream()
                    .filter(serverClient -> !serverClient.equals(sender))
                    .forEach(serverClient -> serverClient.sendUdp(msg, nick));
        }
    }

}
