import com.google.api.client.json.Json;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.client.MongoClient;
import spark.Request;
import spark.Response;
import spark.Spark;

public class DuetServerApplication {
//    public static final MongoClient db = new MongoClient("localhost");

    /**
     * Handles the POST signup
     * @param request The request from the user
     * @param response The response to send to the user
     * @return An API key
     */
    private Object onRecievePOSTSignup(Request request, Response response) {
        var body = request.body();
        var jsonParser = new JsonParser();
        var jsonObject = jsonParser.parse(body).getAsJsonObject();
        return null;
    }

    private Object onRecieveGETCards(Request request, Response response) {
        return null;
    }

    private Object onRecievePOSTChatMessage(Request request, Response response) {
        return null;
    }

    private Object onGETChatMessages(Request request, Response response) {
        return null;
    }

    public DuetServerApplication() {
        System.out.println("Creating signup route");
        Spark.post("/signup", this::onRecievePOSTSignup);
        System.out.println("Creating get cards route");
        Spark.get("/cards", this::onRecieveGETCards);
        System.out.println("Creating vote route");
//        Spark.post("/vote", this::onRecievePOSTVote);
    }

    public static void main(String[] args) {

    }
}
