import java.io.*;
import java.net.*;

public class Client {
    private final int PORT_NUMBER = 4444;
    private final String SERVER_NAME = "localhost";
    private Socket socket;
    private ServerThread serverThread;

    public Client() {
        try {
            socket = new Socket(SERVER_NAME, PORT_NUMBER);
            System.out.println("Connected: " + socket);

            serverThread = new ServerThread(socket);
            Thread t = new Thread(serverThread);
            t.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Client(String serverName) {
        
    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
