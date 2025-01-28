package singlylinkedlist.socialmediaconnections;
import java.util.ArrayList;
import java.util.List;
public class Node {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs; // List of friend IDs
    Node next;

    Node(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}
