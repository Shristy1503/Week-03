package heapsort;

import java.util.Scanner;
import java.util.Arrays;

public class SortJobApplicantsSalary {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[i];
            salaries[i] = salaries[0];
            salaries[0] = temp;

            // Call heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in salaries[]
    // n is the size of the heap
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Main method to test the heap sort implementation
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number salaries: ");
        int n = input.nextInt();
        int[] salaries = new int[n];
        System.out.println("Enter each salary: ");
        // take input in loop from user
        for (int i = 0; i < n; i++) {
            salaries[i] = input.nextInt();
        }

        heapSort(salaries);

        System.out.println("Salaries after sorting: " + Arrays.toString(salaries));
    }
}



