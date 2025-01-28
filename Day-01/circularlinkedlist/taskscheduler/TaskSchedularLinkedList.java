package circularlinkedlist.taskscheduler;

public class TaskSchedularLinkedList {
    private Node head;
    private Node tail;

    public TaskSchedularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (position <= 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }

        Node current = head;
        int index = 0;

        while (current.next != head && index < position - 1) {
            current = current.next;
            index++;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) {
            tail = newNode;
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Node current = head;
        Node previous = tail;

        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    if (head == tail) {
                        head = null;
                        tail = null;
                    } else {
                        head = current.next;
                        tail.next = head;
                    }
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + head.taskName + " (ID: " + head.taskId + ")");
        head = head.next;
    }

    // Display all tasks in the list starting from the head node
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
     public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Found Task - ID: " + current.taskId + ", Name: " + current.taskName + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}
