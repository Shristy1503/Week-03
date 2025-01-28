package doublylinkedlist.librarymanagementsystem;

public class LibraryLinkedList {
    private Node head;
    private Node tail;
    private int count;

    public LibraryLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // Add a new book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
    }

    // Add a new book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }

    // Add a new book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 0) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Node newNode = new Node(title, author, genre, bookId, isAvailable);
        Node current = head;
        int index = 0;

        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addBookAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newNode.prev = current.prev;
            newNode.next = current;
            if (current.prev != null) {
                current.prev.next = newNode;
            } else {
                head = newNode; // New head
            }
            current.prev = newNode;
            count++;
        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        Node current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Update head if needed
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Update tail if needed
                }
                count--;
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    // Search for a book by Book Title
    public void searchByTitle(String title) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Found Book: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found with title: " + title);
        }
    }

    // Search for a book by Author
    public void searchByAuthor(String author) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Found Book: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    // Update a book’s Availability Status
    public void updateAvailabilityStatus(int bookId, boolean isAvailable) {
        Node current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Updated availability for Book ID: " + bookId + " to " + (isAvailable ? "Available" : "Not Available"));
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        Node current = head;
        if (current == null) {
            System.out.println("No books available.");
            return;
        }
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        Node current = tail;
        if (current == null) {
            System.out.println("No books available.");
            return;
        }
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        return count;
    }
}
