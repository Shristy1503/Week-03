package circularlinkedlist.roundrobinschedulingalgorithm;

public class RoundRobinLinkedList {
    private Node head;
    private Node tail;

    public RoundRobinLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime) {
        Node newNode = new Node(processId, burstTime);
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

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        Node current = head;
        Node previous = tail;

        do {
            if (current.processId == processId) {
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

        System.out.println("Process not found.");
    }
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Node current = head;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completedProcesses = 0;
        int totalProcesses = countProcesses();

        while (completedProcesses < totalProcesses) {
            if (current.remainingTime > 0) {
                if (current.remainingTime > timeQuantum) {
                    // Process executes for the time quantum
                    current.remainingTime -= timeQuantum;
                    totalWaitingTime += current.waitingTime;
                } else {
                    // Process finishes execution
                    totalWaitingTime += current.waitingTime;
                    current.waitingTime += (timeQuantum - current.remainingTime);
                    current.turnaroundTime = current.burstTime + current.waitingTime;
                    totalTurnaroundTime += current.turnaroundTime;
                    current.remainingTime = 0;
                    completedProcesses++;
                    System.out.println("Process " + current.processId + " completed.");
                }
            }
            current = current.next;
        }

        // Display average waiting time and turnaround time
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / totalProcesses);
    }

    // Count the total number of processes
    private int countProcesses() {
        if (head == null) return 0;

        Node current = head;
        int count = 0;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }

        Node current = head;
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Remaining Time: " + current.remainingTime);
            current = current.next;
        } while (current != head);
    }
}
