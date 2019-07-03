
public interface DatabaseInterface {
    /* Interface that defines essential CRUD operations employed by the server */

    public Message retrieveLastMessage();

    public void storeMessage(Message m);
}
