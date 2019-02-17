import java.util.List;

public class Chat implements DatabaseObject {

    private List<String> history;
    private User user1;
    private User user2;
    private static final MongoDBConnector dbConnection = MongoDBConnector.connect();

    public List<String> getHistory() {
        update();
        return history;
    }

    @Override
    public void update(String senderInput) {
        Chat.dbConnection.getChatCollection().insertOne();
    }

    @Override
    public void save() {

    }

    public static Chat getChat(User user) {
        return null;
    }
}
