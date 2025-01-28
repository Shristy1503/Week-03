package circularlinkedlist.roundrobinschedulingalgorithm;

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {
       RoundRobinLinkedList list = new RoundRobinLinkedList();
        // Adding processes
        list.addProcess(1, 10);
        list.addProcess(2, 5);
        list.addProcess(3, 8);

        // Displaying processes before scheduling
        System.out.println("Processes in the circular queue:");
        list.displayProcesses();

        // Simulating round-robin scheduling with a time quantum of 3
        int timeQuantum = 3;
        list.roundRobinScheduling(timeQuantum);

        // Displaying processes after scheduling
        System.out.println("Processes in the circular queue after scheduling:");
        list.displayProcesses();
    }
}