import spark.Request;
import spark.Response;
import spark.Spark;

public class DuetServerApplication {
    private Object onRecievePOSTSignup(Request request, Response response) {
        return null;
    }

    private Object onRecieveGETCards(Request request, Response response) {
        return null;
    }

    private Object onRecievePOSTVote(Request request, Response response) {
        return null;
    }

    public DuetServerApplication() {
        System.out.println("Creating signup route");
        Spark.post("/signup", this::onRecievePOSTSignup);
        System.out.println("Creating get cards route");
        Spark.get("/cards", this::onRecieveGETCards);
        System.out.println("Creating vote route");
        Spark.post("/vote", this::onRecievePOSTVote);
    }

    public static void main(String[] args) {

    }
}
