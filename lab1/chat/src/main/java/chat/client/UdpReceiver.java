package chat.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UdpReceiver extends Thread {
    private final DatagramSocket socket;

    public UdpReceiver(DatagramSocket socket) {
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
                System.out.println(msg);
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
