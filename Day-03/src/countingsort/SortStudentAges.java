package countingsort;

import java.util.Scanner;
import java.util.Arrays;

public class SortStudentAges {
    public static void countingSort(int[] ages) {
        // Define the range of ages
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        // Create a count array to store the frequency of each age
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count the occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative frequencies
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy the sorted output array back to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Main method to test the counting sort implementation
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number salaries: ");
        int n = input.nextInt();
        int[] ages  = new int[n];
        System.out.println("Enter each salary: ");
        // take input in loop from user
        for (int i = 0; i < n; i++) {
            ages[i] = input.nextInt();
        }

        countingSort(ages);

        System.out.println("Ages after sorting: " + Arrays.toString(ages));
    }
}