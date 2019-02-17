import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Request;
import spark.Response;
import spark.Spark;

public class DuetServerApplication {
    public static final MongoDBConnector dbConnection = MongoDBConnector.connect();

    private static JsonObject getJsonObjectFromRequest(Request request) {
        var body = request.body();
        var jsonParser = new JsonParser();
        return jsonParser.parse(body).getAsJsonObject();
    }

    /**
     * Handles the POST signup
     *
     * @param request  The request from the user
     * @param response The response to send to the user
     * @return An API key
     */
    private Object onRecievePOSTSignup(Request request, Response response) {
        var jsonObject = getJsonObjectFromRequest(request);
        var username = jsonObject.get("username").getAsString();
        var password = jsonObject.get("password").getAsString();
        var fname = jsonObject.get("fname").getAsString();
        var lname = jsonObject.get("lname").getAsString();
        var survey = Survey.fromJsonObject(jsonObject.getAsJsonObject("survey"));
        var user = User.createUser(username, password, survey, fname, lname);
        return user.getApiKey();
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
//        Spark.post("/vote", this::onReceivePOSTVote);
    }

    public static void main(String[] args) {
        new DuetServerApplication();
    }
}
