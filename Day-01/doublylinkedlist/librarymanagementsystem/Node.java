package doublylinkedlist.librarymanagementsystem;

public class Node {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Node next;
    Node prev;

    public Node(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
