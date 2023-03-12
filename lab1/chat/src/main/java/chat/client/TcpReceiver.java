package chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpReceiver extends Thread {

    private final Socket socket;
    private final BufferedReader in;

    public TcpReceiver(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = in.readLine();
                if (msg == null) break;
                System.out.println(msg);
            }
            System.out.println("TCP lost connection");
            socket.close();
            System.exit(1);
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
