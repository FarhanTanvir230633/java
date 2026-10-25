
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[1024];

        System.out.println("UDP Server waiting...");

        DatagramPacket dp = new DatagramPacket(
            receive, receive.length);

        ds.receive(dp);

        String msg = new String(
            dp.getData(), 0, dp.getLength());

        System.out.println("Client: " + msg);

        Thread.sleep(6);

        String reply = msg.toUpperCase();
        byte[] send = reply.getBytes();

        DatagramPacket sp = new DatagramPacket(
            send, send.length,
            dp.getAddress(), dp.getPort());

        ds.send(sp);

        ds.close();
    }
}
