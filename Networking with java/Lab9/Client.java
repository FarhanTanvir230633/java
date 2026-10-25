
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
            s.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        System.out.print("Enter a message: ");
        String msg = keyboard.readLine();

        out.println(msg);

        String reply = in.readLine();
        System.out.println("Uppercase message: " + reply);

        s.close();
    }
}
