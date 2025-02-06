package binarysearch.findthepeakelementinanarray;

public class FindThePeakElement {
    public static void main(String[] args) {
        int[] array = {3, 2, 6, 4, 7, 10, 9};

        //call method to find the peak element
        int peekIndex = binarySearch(array);
        System.out.println("Peak element of array is: " + array[peekIndex] + " at index : " + peekIndex);
    }

    //method to find peak element of an array
    public static int binarySearch(int[] array){
        if(array.length == 0){
            //if array is empty
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left < right){
            //find mid element
            int mid = left + (right - left) /2;

            if(array[mid] > array[mid + 1]){
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return right;
    }
}
