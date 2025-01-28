package circularlinkedlist.roundrobinschedulingalgorithm;

public class Node {
    int processId;
    int burstTime;
    int remainingTime;
    int waitingTime;
    int turnaroundTime;
    Node next;

    public Node(int processId, int burstTime) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // Initially, remaining time is equal to burst time
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}
