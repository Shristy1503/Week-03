package circularlinkedlist.taskscheduler;

public class Node {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Node next;

    public Node(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
