package doublylinkedlist.librarymanagementsystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryLinkedList library = new LibraryLinkedList();

        // Adding books
        library.addBookAtBeginning("Harry Potter", "J.K. Rowling", "Fiction", 1, true);
        library.addBookAtEnd("Rich Dad Poor Dad", "Robert Kiyosaki", "Self Help", 2, true);
        library.addBookAtPosition("To Kill a Mockingbird", "Harper Lee", "Fiction", 3, true, 1);

        // Displaying all books
        System.out.println("Books in Library (Forward):");
        library.displayBooksForward();

        // Searching for a book by title
        library.searchByTitle("1984");

        // Updating availability status
        library.updateAvailabilityStatus(1, false);

        // Displaying all books in reverse order
        System.out.println("Books in Library (Reverse):");
        library.displayBooksReverse();

        // Counting total books
        System.out.println("Total number of books in library: " + library.countBooks());

        // Removing a book by ID
        library.removeBookById(2);
        System.out.println("Books after removing Book ID 2:");
        library.displayBooksForward();
    }
}