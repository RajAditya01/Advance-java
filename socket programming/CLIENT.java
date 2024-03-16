import java.io.*;
import java.net.*;

class CLIENT {
    public static void main(String args[]) {
        try {
            String ip = "127.0.0.1";
            final int PORT = 12345;

            Socket skt = new Socket(ip, PORT);
            System.out.println("client is invoked......");
            System.out.println("Type something that will be sent to server....");

            BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            do {
                str = keyboard.readLine();
                out.println(str);
                str = in.readLine();
                System.out.println("from server:" + str);
            } while (!str.equalsIgnoreCase("quit"));
            
            // Close resources
            skt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
