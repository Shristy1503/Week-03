package singlylinkedlist.socialmediaconnections;
import java.util.ArrayList;
import java.util.List;
public class SocialMediaLinkedList {
    private Node head;

    // Add a new user to the list
    public void addUser(int userID, String name, int age) {
        Node newUser = new Node(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }
    // Find a user by User ID
    private Node findUserByID(int userID) {
        Node temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // User not found
    }
    // Add a friend connection between two users
    public void addFriendConnection(int userID1, int userID2) {
        Node user1 = findUserByID(userID1);
        Node user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIDs.contains(userID2)) {
            user1.friendIDs.add(userID2);
        }
        if (!user2.friendIDs.contains(userID1)) {
            user2.friendIDs.add(userID1);
        }
        System.out.println("Friend connection added between User " + userID1 + " and User " + userID2);
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userID1, int userID2) {
        Node user1 = findUserByID(userID1);
        Node user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIDs.remove(Integer.valueOf(userID2));
        user2.friendIDs.remove(Integer.valueOf(userID1));
        System.out.println("Friend connection removed between User " + userID1 + " and User " + userID2);
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        Node user1 = findUserByID(userID1);
        Node user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>();
        for (int friendID : user1.friendIDs) {
            if (user2.friendIDs.contains(friendID)) {
                mutualFriends.add(friendID);
            }
        }

        System.out.println("Mutual friends between User " + userID1 + " and User " + userID2 + ": " + mutualFriends);
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        Node user = findUserByID(userID);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of User " + userID + ": " + user.friendIDs);
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, int userID) {
        Node temp = head;
        while (temp != null) {
            if (temp.userID == userID || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User found: ID=" + temp.userID + ", Name=" + temp.name + ", Age=" + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    public void countFriends() {
        Node temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userID + ", Number of Friends: " + temp.friendIDs.size());
            temp = temp.next;
        }
    }
}
