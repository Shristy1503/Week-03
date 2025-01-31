package hashmapandhashfunctions.customhashmap;

public class CustomHash {
    int input;
    private CustomLinkedList[] arr;

    public void getLength(int input) {
        this.input = input;
        arr = new CustomLinkedList[input];

    }

    public int hashKey(int key) {
        return key % input;
    }

    public void insert(int data, int key) {
        int mapKey = hashKey(key);
        CustomLinkedList newNode = new CustomLinkedList(data, key);

        if (arr[mapKey] == null) {
            arr[mapKey] = newNode;
        } else {
            CustomLinkedList current = arr[mapKey];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;

        }
    }

    public void delete(int key) {
        int map = hashKey(key);
        CustomLinkedList current = arr[map];
        CustomLinkedList previous = null;

        while (current != null) {
            if (current.key == key) {
                // Node found, remove it
                if (previous == null) {
                    // If it's the first node in the list
                    arr[map] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;

        }
        System.out.println("key not found " + key);
    }

    public void traversal(int key) {
        int mapKey = hashKey(key);
        CustomLinkedList current = arr[mapKey];
        while (current != null) {
            if (current.key == mapKey) {
                System.out.println("The value at that key is " + current.data);
            }
            current = current.next;
        }
        System.out.println("Key not found");

    }

    public void display() {
        // Traverse through each index in the hash map array
        for (int i = 0; i < arr.length; i++) {
            CustomLinkedList current = arr[i];

            // If there is a linked list at this index, print its data
            if (current != null) {
                System.out.print("Index " + i + ": ");
                while (current != null) {
                    System.out.println("Data: " + current.data + " (Key: " + current.key + ")");
                    current = current.next;
                }

            }

        }
    }
}
