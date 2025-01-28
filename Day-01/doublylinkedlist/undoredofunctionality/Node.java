package doublylinkedlist.undoredofunctionality;

public class Node {
    String textContent;
    Node prev;
    Node next;

    Node(String textContent) {
        this.textContent = textContent;
        this.prev = null;
        this.next = null;
    }
}
