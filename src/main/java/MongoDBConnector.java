import com.mongodb.ConnectionString;
import com.mongodb.MongoCredential;
import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBConnector {
    private MongoDatabase db;
    private MongoCollection<User> userCollection;
    private MongoCollection<Chat> chatCollection;

    private MongoDBConnector(MongoDatabase db, MongoCollection<User> userCollection,
                            MongoCollection<Chat> chatCollection) {
        this.db = db;
        this.userCollection = userCollection;
        this.chatCollection = chatCollection;
    }

    public static MongoDBConnector connect() {
        var connectionString = new ConnectionString("mongodb://admin:password@localhost:27017");
        var mongoClient = MongoClients.create(connectionString);
        var database = mongoClient.getDatabase("duet");
        var userCollection = database.getCollection("users", User.class);
        var chatCollection = database.getCollection("chats", Chat.class);
        return new MongoDBConnector(database, userCollection, chatCollection);
    }

    public static void main(String[] args) {
        //Creating client

        // Creating test user credentials

        // Accessing Database

        // Retrieving a collection


        // Adding document info to collection.

    }
}
