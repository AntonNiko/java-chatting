import java.net.*;
import java.io.*;
import java.util.LinkedList;

public class Server {
    private final int PORT_NUMBER = 4444;
    private Socket newSocket;
    private ServerSocket server;
    private DataInputStream streamIn;
    private LinkedList<ClientThread>  connections;
    private Database db;
    private ClientThread initialThread;
    
    public Server() {
        connections = new LinkedList<ClientThread>();

        // Set up sockets to listen
        try {
            server = new ServerSocket(PORT_NUMBER);
            System.out.println("Started server at port " + PORT_NUMBER);

            while (true) {
                // Accept incoming requests
                newSocket = server.accept();

                initialThread = new ClientThread(newSocket);
                Thread t = new Thread(initialThread);
                connections.add(initialThread);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /* java -classpath ".:sqlite-jdbc-3.27.2.1.jar" Server */
        Server s = new Server();
    }
}
