import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements DatabaseInterface {
    private Connection conn;
    private final String DB_FILENAME = "messages.db";

    public Database() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /* Upon constructing an instance, create a new connection */
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DB_FILENAME);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Message retrieveLastMessage() {
        return null;
    }

    public void storeMessage(Message m) {

    }

    private void createNewDatabase() {

    }
}
