import com.mongodb.client.MongoCollection;

import java.util.List;
import java.util.UUID;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

public class Chat implements DatabaseObject {

    private List<String> history;
    private User user1;
    private User user2;
    private static final MongoCollection<Chat> chatCollection = DuetServerApplication.dbConnection.getChatCollection();
    private UUID id = UUID.randomUUID();

    public List<String> getHistory() {
        update();
        return history;
    }

    public void update() {
        Chat chat = chatCollection.find(eq("id", id)).first();
    }

    @Override
    public void save() {

    }

    public static Chat getChat(User user) {
        return null;
    }
}
