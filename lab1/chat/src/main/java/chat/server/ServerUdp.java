package chat.server;

import chat.server.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

class ServerUdp extends Thread {
    private final Server server;
    private final DatagramSocket socket;

    public ServerUdp(Server server, DatagramSocket socket) {
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        byte[] receiveBuffer = new byte[1024];
        try {
            while (true) {
                Arrays.fill(receiveBuffer, (byte) 0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                String msg = new String(receiveBuffer, 0, receivePacket.getLength());
                System.out.println("[port: " + receivePacket.getPort() + "; channel: UDP] " + msg);
                server.sendUdp(receivePacket.getPort(), msg);
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }
}