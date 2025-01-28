package singlylinkedlist.inventorymanagementsystem;

public class Inventory {
  Node head;
  //constructor
    public Inventory(){
        this.head = null;
    }
    //add item at first position
    public void addFirst(String itemName, int itemID, int quantity, double price){
        Node newNode = new Node(itemName, itemID, quantity, price);
        newNode.next = head;
        head = newNode;
    }
    // add item at last
    public void addAtLast(String itemName, int itemID, int quantity, double price){
        Node newNode = new Node(itemName, itemID, quantity, price);
        if(head == null){
            head = newNode;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
          currentNode.next = newNode;
    }
    // add at specific position
    public void addSpecificPosition(int position, String itemName, int itemID, int quantity, double price){
        Node newNode = new Node(itemName, itemID, quantity, price);
        if(position == 0){
            //add at first position
            newNode.next = head;
            head = newNode;
        }
        Node currentNode = head;
        for(int i=0;i<position - 1 && currentNode != null; i++){
            currentNode = currentNode.next;
        }
        if(currentNode != null){
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }else
            System.out.println("Position not found");
    }

    //remove item by itemId
    public void removeItem(int itemId){
        Node temp = head;
        while (temp.itemID != itemId){
            temp = temp.next;
            if(temp == null){
                System.out.println("Record not found");
                return;
            }

        }
        temp.next = temp.next.next;
    }
    //Search for an item record by itemId
    public Node searchItem(int itemId){
        Node temp = head;
        while(temp != null){
            if (temp.itemID == itemId){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    //update quantity of item by item id
    public void updateItemQuantity(int itemId, int newQuantity){
        Node record1 = searchItem(itemId);
        if (record1 != null){
            record1.quantity = newQuantity;
            System.out.println("Updated quantity: " + newQuantity
            );
        }else
            System.out.println("Record not found");
    }

    //calculate total value of inventory
    public double calculateInventoryValue(){
        double totalValue = 0;
        Node temp = head;
        while (temp != null){
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        return totalValue;
    }
    //display inventory
    public void displayInventory(){
        Node temp = head;
        while (temp != null){
            System.out.println("ID: " + temp.itemID + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}
