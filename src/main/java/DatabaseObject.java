import com.mongodb.client.MongoCollection;

public interface DatabaseObject {
    void update();
    void save();
}
