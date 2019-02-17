import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;
import com.mongodb.client.MongoCollection;
import org.bson.BsonDocument;


import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Base64.getEncoder;

public class User implements DatabaseObject {

    private static final MongoCollection<User> userCollection = DuetServerApplication.dbConnection.getUserCollection();
    private ArrayList<Chat> chats = new ArrayList<>();
    private UUID id = UUID.randomUUID();
    private Survey survey;
    private String apiKey;

    public JsonObject getPubliclyAvailableSerializedUser() {
        //JsonSerializer
        return null;
    }

    public String getApiKey() {
        return apiKey;
    }

    private User(String apiKey, Survey survey) {
        this.survey = survey;
        this.apiKey = apiKey;
    }

    public void sendMessageTo(User user) {

    }

    public static User queryFromAPIToken(String token) {
        return userCollection.find(eq("apiKey", token)).first();
    }

    public List<Chat> getChats() {
        update();
        return chats;
    }

    private static String createAPIKey(String username, String password) {
        var encoder = getEncoder();
        var stringToEncode = String.format("%s:%s", username, password);
        return encoder.encodeToString(stringToEncode.getBytes());

    }

    public static User createUser(String username, String password, Survey userSurvey) {
        var apiKey = createAPIKey(username, password);
        // TODO: Create user in database here
        return new User(apiKey, userSurvey);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                getApiKey().equals(user.getApiKey());
    }

    @Override
    public void save() {
        userCollection.insertOne(this);
    }

    @Override
    public void update() {
        User user = userCollection.find(eq("id", id)).first();
        if (!this.equals(user)) {
            System.err.printf("Someone done spoofed up the ids and shit for these users:\n" +
                    "User1: %s\n" +
                    "User2: %s\n", this, user);
            return;
        }
        chats = user.chats;
        survey = user.survey;
    }
}
