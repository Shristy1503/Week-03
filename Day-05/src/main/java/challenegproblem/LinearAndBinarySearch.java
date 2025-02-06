package challenegproblem;
import java.util.Arrays;
public class LinearAndBinarySearch {
    public static void main(String[] args) {
      int[] array = {2, 6, 4, 5, -1, 7};
        System.out.println("original array: " + Arrays.toString(array));
        // Find the first missing positive integer
        int missing = findFirstMissingPositive(array);
        System.out.println("First missing positive integer: " + missing);

        // Sort the array for binary search
        Arrays.sort(array);
        int target = 4;

        // Perform binary search
        int index = binarySearch(array, target);
        System.out.println("Index of target " + target + ": " + index);

    }

    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with arr[arr[i] - 1] to place numbers in correct index
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // Missing number found
            }
        }
        return n + 1;
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
}
