import java.io.*;
import java.net.*;

class SERVER {
    public static void main(String args[]) {
        try {
            final int PORT = 12345;
            ServerSocket sskt = new ServerSocket(PORT);
            System.out.println("server is started successfully...");
            System.out.println("port number:" + sskt.getLocalPort());
            System.out.println("waiting for client connection....");
            // sskt.setSoTimeout(5000);
            Socket skt = sskt.accept();
            System.out.println("client is connected:" + skt);
            BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // Adding this line
            String str = null;
            do {
                str = in.readLine();
                System.out.println("from client:" + str);
                str = keyboard.readLine(); // Corrected line
                out.println(str);
            } while (!str.equalsIgnoreCase("quit"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
