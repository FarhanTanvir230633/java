
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting for client...");

        Socket s = ss.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
            s.getOutputStream(), true);

        String msg = in.readLine();
        System.out.println("Client: " + msg);

        out.println(msg.toUpperCase());

        s.close();
        ss.close();
    }
}

