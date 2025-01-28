package singlylinkedlist.socialmediaconnections;
import java.util.ArrayList;
import java.util.List;
public class SocialMediaConnections {
    public static void main(String[] args) {
        SocialMediaLinkedList list = new SocialMediaLinkedList();

        // Adding users
        list.addUser(1, "Arjun", 25);
        list.addUser(2, "Shristy", 30);
        list.addUser(3, "Nancy", 22);

        // Adding friend connections
        list.addFriendConnection(1, 2);
        list.addFriendConnection(1, 3);

        // Displaying friends
        list.displayFriends(1);
        list.displayFriends(2);

        // Finding mutual friends
        list.findMutualFriends(1, 2);

        // Removing a friend connection
        list.removeFriendConnection(1, 2);
        list.displayFriends(1);

        // Searching for a user
        list.searchUser("Shristy", -1);
        list.searchUser("", 3);

        // Counting friends for each user
        list.countFriends();
    }
}
