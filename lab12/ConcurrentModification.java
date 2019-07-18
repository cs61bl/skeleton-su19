import java.util.ArrayList;
import java.util.List;

public class ConcurrentModification {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();
        friends.add("Ervin");
        friends.add("Gigi");
        friends.add("Lucas");
        for (String friend : friends) {
            friends.remove(1);
            System.out.println("friend=" + friend);
        }
    }
}
