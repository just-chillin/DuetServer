import com.google.api.client.json.Json;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Survey {
    public static final String surveryMessage = "Fuck you!";

    public JsonObject serializeToJson(){
        var obj = new JsonObject();
        obj.add("message", new JsonPrimitive(surveryMessage));
        return obj;
    }

    public static Survey fromJsonObject(JsonObject json) {

        return null;
    }
}
