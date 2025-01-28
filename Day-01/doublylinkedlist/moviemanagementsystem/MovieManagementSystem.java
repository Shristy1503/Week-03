package doublylinkedlist.moviemanagementsystem;

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieLinkedList list1 = new MovieLinkedList();
        list1.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        list1.addAtLast("Dhamaal", "Rohit Shetty", 2012, 9.2);
        list1.addAtPosition(2, "Harry Potter", "J.K Rowling", 2003, 9);

        System.out.println("Movies in forward order:");
        list1.displayForward();

        System.out.println("\nMovies in reverse order:");
        list1.displayReverse();

        list1.searchByDirector("Christopher Nolan");
        list1.removeMovieByTitle("Harry Potter");
        System.out.println("Movie removed");

        System.out.println("\nMovies after removal:");
        list1.displayForward();
    }
}
