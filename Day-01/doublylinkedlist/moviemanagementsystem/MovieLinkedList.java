package doublylinkedlist.moviemanagementsystem;

public class MovieLinkedList {
    private Node head;
    private Node tail;
    //constructor
    public MovieLinkedList(){
        this.head = head;
        this.tail = tail;
    }

    //add at beginning
    public void addAtBeginning(String title, String director, int year, double rating){
        Node newNode = new Node(title, director, year, rating);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    //add at end
     public void addAtLast(String title, String director, int year, double rating){
         Node newNode = new Node(title, director, year, rating);
         if(tail == null){
             head = newNode;
             tail = newNode;
         }else{
             tail.next = newNode;
             newNode.prev = tail;
             tail = newNode;
         }
     }
     // ad at specific position
    public void addAtPosition(int position, String title, String director, int year, double rating){
        if(position <= 0){
            addAtBeginning(title, director, year, rating);
            return;
        }
        Node newNode = new Node(title, director, year, rating);
        Node current = head;
        int index = 0;

        while (current != null && index < position){
            current = current.next;
            index++;
        }
        if(current == null){
            addAtBeginning(title, director, year, rating);
        }else {
            newNode.prev = current.prev;
            newNode.next = current;
            if (current.prev != null) {
                current.prev.next = newNode;
            } else {
                head = newNode;
            }
            current.prev = newNode;
        }
    }
    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        Node current = head;

        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Search for a movie by director
    public void searchByDirector(String director) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println("Found Movie: " + current.title + ", Year: " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }

    // Search for a movie by rating
    public void searchByRating(double rating) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Found Movie: " + current.title + ", Director: " + current.director + ", Year: " + current.year);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Display all movies in forward order
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }
    // Display all movies in reverse order
    public void displayReverse() {
        Node current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
}
