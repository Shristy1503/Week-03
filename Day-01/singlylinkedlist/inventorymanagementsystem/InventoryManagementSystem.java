package singlylinkedlist.inventorymanagementsystem;

public class InventoryManagementSystem {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        inventory.addFirst("Toy", 101, 2, 200);
        inventory.addFirst("Washing powder", 103, 4, 400);

        inventory.displayInventory();
        inventory.addAtLast("Top", 203, 4, 230);
        inventory.displayInventory();
        inventory.addSpecificPosition(2,"Food", 105, 5, 400);
        inventory.displayInventory();

        Node item1 = inventory.searchItem(203);
        if(item1 != null){
            System.out.println("\nFound item: item id: " + item1.itemID + " |  Name: " + item1.itemName);
        }

        // Calculate total inventory value
        double totalValue = inventory.calculateInventoryValue();
        System.out.println("\nTotal Inventory Value: " + totalValue);

        // Remove an item by ID
        inventory.removeItem(3);
        // Print inventory after removal
        System.out.println("\nInventory after removal:");
        inventory.displayInventory();
    }
}
