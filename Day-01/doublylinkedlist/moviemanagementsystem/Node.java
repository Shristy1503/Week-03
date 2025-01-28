package doublylinkedlist.moviemanagementsystem;

public class Node {
    String title;
    String director;
    int year;
    double rating;
    Node next;
    Node prev;

    public Node(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }

}
