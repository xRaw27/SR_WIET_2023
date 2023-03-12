package chat.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class MulticastReceiver extends Thread {
    private final DatagramSocket socket;
    private final int localPort;

    public MulticastReceiver(DatagramSocket socket, int localPort) {
        this.socket = socket;
        this.localPort = localPort;
    }

    @Override
    public void run() {
        byte[] receiveBuffer = new byte[1024];
        try {
            while (true) {
                Arrays.fill(receiveBuffer, (byte) 0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                if(receivePacket.getPort() != localPort) {
                    String msg = new String(receiveBuffer, 0, receivePacket.getLength());
                    System.out.println(msg);
                }
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
