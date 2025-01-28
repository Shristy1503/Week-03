package doublylinkedlist.undoredofunctionality;

public class UndoRedoLinkedList {
    private Node head;
    private Node tail;
    private Node currentState;
    private int size;
    private int maxSize;

    // Constructor to initialize the text editor with a maximum history size
    public UndoRedoLinkedList(int maxSize) {
        this.head = null;
        this.tail = null;
        this.currentState = null;
        this.size = 0;
        this.maxSize = maxSize;
    }

    // Add a new state to the text editor
    public void addState(String newText) {
        Node newNode = new Node(newText);

        // If the list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            currentState = newNode;
        } else {
            // Remove all redo states (states after the current state)
            if (currentState.next != null) {
                currentState.next.prev = null;
                currentState.next = null;
                tail = currentState;
            }

            // Add the new state
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            currentState = newNode;

            // If size exceeds the max limit, remove the oldest state
            if (size == maxSize) {
                head = head.next;
                head.prev = null;
            } else {
                size++;
            }
        }
        System.out.println("Added new state: \"" + newText + "\"");
    }

    // Undo functionality (revert to the previous state)
    public void undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("No undo available.");
            return;
        }
        currentState = currentState.prev;
        System.out.println("Undo: Current state is \"" + currentState.textContent + "\"");
    }

    // Redo functionality (revert to the next state after undo)
    public void redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("No redo available.");
            return;
        }
        currentState = currentState.next;
        System.out.println("Redo: Current state is \"" + currentState.textContent + "\"");
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState == null) {
            System.out.println("No current state.");
        } else {
            System.out.println("Current state: \"" + currentState.textContent + "\"");
        }
    }

    // Display all states
    public void displayAllStates() {
        Node temp = head;
        System.out.println("All states:");
        while (temp != null) {
            System.out.print("\"" + temp.textContent + "\"");
            if (temp == currentState) {
                System.out.print(" <- Current");
            }
            System.out.println();
            temp = temp.next;
        }
    }
}
