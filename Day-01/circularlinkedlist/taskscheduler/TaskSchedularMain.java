package circularlinkedlist.taskscheduler;

public class TaskSchedularMain {
    public static void main(String[] args) {
       TaskSchedularLinkedList list = new TaskSchedularLinkedList();
        // Adding tasks
        list.addTaskAtBeginning(1, "Task 1", 2, "2023-10-01");
        list.addTaskAtEnd(2, "Task 2", 1, "2023-10-02");
        list.addTaskAtPosition(3, "Task 3", 3, "2023-10-03", 1);

        // Displaying all tasks
        System.out.println("All Tasks:");
        list.displayTasks();

        // Viewing current task
        list.viewCurrentTask();

        // Searching for a task by priority
        System.out.println("Searching for tasks with priority 1:");
        list.searchByPriority(1);

        // Removing a task by ID
        list.removeTaskById(2);
        System.out.println("Tasks after removing Task ID 2:");
        list.displayTasks();
    }
}
