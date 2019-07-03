import java.io.*;
import java.net.*;

public class ServerThread implements Runnable {
    DataInputStream inputStream;
    DataOutputStream outputStream;
    String inputLine;

    public ServerThread(Socket s) {
        try {
            inputStream = new DataInputStream(System.in);
            outputStream = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override 
    public void run() {
        inputLine = "";
        while (true) {
            try {
                inputLine = inputStream.readUTF();
                outputStream.writeUTF(inputLine);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
