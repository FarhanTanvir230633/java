
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        InetAddress ip = InetAddress.getByName("localhost");

        System.out.print("Enter a message: ");
        String msg = sc.nextLine();

        byte[] send = msg.getBytes();

        DatagramPacket sp = new DatagramPacket(
            send, send.length, ip, 5000);

        ds.send(sp);

        byte[] receive = new byte[1024];
        DatagramPacket rp = new DatagramPacket(
            receive, receive.length);

        ds.receive(rp);

        String reply = new String(
            rp.getData(), 0, rp.getLength());

        System.out.println("Uppercase: " + reply);

        ds.close();
        sc.close();
    }
}
