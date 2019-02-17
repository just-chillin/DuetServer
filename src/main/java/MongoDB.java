import com.mongodb.MongoCredential;
import com.mongodb.client.*;
import org.bson.Document;

public class MongoDB {

    public static void main(String[] args) {
        //Creating client
        MongoClient mongoClient = MongoClients.create("localhost");

        // Creating test user credentials
        MongoCredential credential = MongoCredential.createCredential("Test", "duet",
                "password".toCharArray());

        // Accessing Database
        MongoDatabase database = mongoClient.getDatabase("duet");

        // Retrieving a collection
        MongoCollection<Document> mongoColl = database.getCollection("sample connection?");

        // creating Document of info on User.
        Document document = new Document("Title", "Duet").
                append("First Name", "test").
                append("Last Name", "user").
                append("School", "RIT").
                append("Email", "tuser@rit.edu");

        // Adding document info to collection.
        mongoColl.insertOne(document);

    }
}
