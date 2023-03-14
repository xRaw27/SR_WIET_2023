package chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {
    private final String serverHostName;
    private final InetAddress serverAddress;
    private final InetAddress groupAddress;
    private final int serverPortNumber;
    private final int multicastPortNumber;
    private final BufferedReader stdin;
    private ConnectionChannel mode;
    private String clientNick;

    public Client(String serverHostName, int serverPortNumber, String groupHostName, int multicastPortNumber) throws UnknownHostException {
        this.serverHostName = serverHostName;
        this.serverAddress = InetAddress.getByName(serverHostName);
        this.groupAddress = InetAddress.getByName(groupHostName);
        this.serverPortNumber = serverPortNumber;
        this.multicastPortNumber = multicastPortNumber;
        this.stdin = new BufferedReader(new InputStreamReader(System.in));
        this.mode = ConnectionChannel.TCP;
    }

    private void send(String msgToSend, PrintWriter tcpOut, DatagramSocket udpSocket) throws IOException {
        switch (this.mode) {
            case TCP -> {
                tcpOut.println(msgToSend);
            }
            case UDP -> {
                byte[] sendBuffer = msgToSend.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPortNumber);
                udpSocket.send(sendPacket);
            }
            case MULTICAST -> {
                String msg = "[from: " + this.clientNick + "; channel: MULTICAST] " + msgToSend;
                byte[] sendBuffer = msg.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, groupAddress, multicastPortNumber);
                udpSocket.send(sendPacket);
            }
        }
    }
    public void runClient() {
        System.out.println("CLIENT START");

        try (
                Socket tcpSocket = new Socket(serverHostName, serverPortNumber);
                DatagramSocket udpSocket = new DatagramSocket(tcpSocket.getLocalPort());
                MulticastSocket multicastSocket = new MulticastSocket(multicastPortNumber);
        ) {
            PrintWriter tcpOut = new PrintWriter(tcpSocket.getOutputStream(), true);

            System.out.print("Client nickname: ");
            clientNick = stdin.readLine();
            tcpOut.println(clientNick);

            multicastSocket.joinGroup(groupAddress);

            TcpReceiver tcpReceiver = new TcpReceiver(tcpSocket);
            UdpReceiver udpReceiver = new UdpReceiver(udpSocket);
            MulticastReceiver multicastReceiver = new MulticastReceiver(multicastSocket, tcpSocket.getLocalPort());
            tcpReceiver.start();
            udpReceiver.start();
            multicastReceiver.start();

            while (true) {
                String msgToSend = stdin.readLine();
                if (msgToSend.equals("$Q") || msgToSend.equals("$QUIT")) {
                    tcpOut.println("$Q");
                } else if (msgToSend.startsWith("$")) {
                    switch (msgToSend) {
                        case "$M", "$MULTICAST" -> this.mode = ConnectionChannel.MULTICAST;
                        case "$T", "$TCP" -> this.mode = ConnectionChannel.TCP;
                        case "$U", "$UDP" -> this.mode = ConnectionChannel.UDP;
                    }
                } else {
                    send(msgToSend, tcpOut, udpSocket);
                }
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
