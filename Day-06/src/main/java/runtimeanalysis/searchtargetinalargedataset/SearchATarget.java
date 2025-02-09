package runtimeanalysis.searchtargetinalargedataset;
import java.util.Arrays;
import java.util.Random;

public class SearchATarget {
    public static void main(String[] args) {
        //taking a random array
        int[] sizes = {1000000};
        //create random object
        Random random = new Random();

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10);
            }
            //take random target value to serch
            int target = data[random.nextInt(size)];

            // Linear Search method call
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;

            // Binary Search method call
            //sort the array
            Arrays.sort(data);
            startTime = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - startTime;

            //display result
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1000000.0 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1000000.0 + " ms");

        }
    }

    //method for binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1; // search in right side
            } else {
                right = mid - 1; //search in left side
            }
        }
        //return not found
        return -1;
    }

    //linear search method
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        //return not found
        return -1;
    }
}
