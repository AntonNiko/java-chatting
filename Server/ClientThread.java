import java.net.*;
import java.io.*;

public class ClientThread implements Runnable {
    DataInputStream inputStream;
    DataOutputStream outputStream;

    /* Creates instance of class that takes care of incoming and outgoing requests to client */
    public ClientThread(Socket s) {
        try {
            inputStream = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            outputStream = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String incomingString;
        while (true) {
            try {
                if (inputStream.available() > 0) {
                    incomingString = inputStream.readUTF();
                    System.out.println(incomingString);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
