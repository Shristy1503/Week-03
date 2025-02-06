package binarysearch.findfirstandlastoccurranceofelement;

public class FindTheFirstAndLastOccurrenceOfElement {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 5, 7, 8, 9, 9};
        int target = 5;

        //find first occurrence
        int first = findFirst(array, target);
        //find last occurrence
        int last = findLast(array, target);
        System.out.println("First occurrence index: " + first);
        System.out.println("Last occurrence index: " + last);
    }

    // method to find the first occurrence of target
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1; // Continue searching on the left side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    // method to find the last occurrence of target
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1; // Continue searching on the right side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }
}
