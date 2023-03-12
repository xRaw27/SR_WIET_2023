package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class ServerClient extends Thread {
    private final Server server;
    private final Socket tcpSocket;
    private final DatagramSocket udpSocket;
    private final InetAddress address;
    private final int port;
    private final PrintWriter tcpOut;
    private final BufferedReader tcpIn;
    private final String nick;

    public ServerClient(Server server, Socket tcpSocket, DatagramSocket udpSocket) throws IOException {
        this.server = server;
        this.tcpSocket = tcpSocket;
        this.udpSocket = udpSocket;
        this.address = tcpSocket.getInetAddress();
        this.port = tcpSocket.getPort();
        this.tcpOut = new PrintWriter(tcpSocket.getOutputStream(), true);
        this.tcpIn = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
        this.nick = tcpIn.readLine();

        System.out.println("New server client: {\n  socket: " + this.tcpSocket + "\n  nick: " + this.nick + "\n}");
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = tcpIn.readLine();
                if (msg == null || msg.equals("$Q")) break;
                System.out.println("[from: " + nick + "; channel: TCP] " + msg);
                server.sendTcp(this, msg, nick);
            }
            System.out.println("Client disconnected: {\n  socket: " + this.tcpSocket + "\n  nick: " + this.nick + "\n}");
            server.disconnect(this);
            tcpSocket.close();

        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendTcp(String msg, String nick) {
        tcpOut.println("[from: " + nick + "; channel: TCP] " + msg);
    }

    public void sendUdp(String msg, String nick) {
        try {
            String sendMsg = "[from: " + nick + "; channel: UDP] " + msg;
            byte[] sendBuffer = sendMsg.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, this.address, this.port);
            udpSocket.send(sendPacket);
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getClientPort() {
        if (tcpSocket.isConnected()) {
            return this.tcpSocket.getPort();
        }
        return -1;
    }

    public String getNick() {
        return nick;
    }
}

