package singlylinkedlist.inventorymanagementsystem;

public class Node {
    String itemName;
    int itemID;
    int quantity;
    double price;
    Node next;
    //constructor
    public Node(String itemName, int itemID, int quantity, double price){
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
