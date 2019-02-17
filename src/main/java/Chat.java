import java.util.List;

public class Chat implements DatabaseObject {

    private List<String> history;
    private User user1;
    private User user2;

    public List<String> getHistory() {
        update();
        return history;
    }

    @Override
    public void update() {

    }

    @Override
    public void save() {

    }

    public static Chat getChat(User user) {
        return null;
    }
}
