package binarysearch.findrotationpointinarotatedsortedarray;

public class FindTheRotationPoint {
    public static void main(String[] args) {
        int[] array = {11, 12, 4, 5, 7, 9, 10};

        //call method to find rotation point
        int rotationPoint = binarySearch(array);
        System.out.println("The rotation point is at index: " + rotationPoint);
    }

    //method to find rotation point
    public static int binarySearch(int[] array){
       if(array.length == 0){
           //if array is empty
           return -1;
       }
       int left = 0;
       int right = array.length - 1;

       while (left < right){
           int mid = (left + right)/2;
           //check if mid element is greater than right most element
           if(array[mid] > array[right]){
               //smallest is in right part
               left = mid+1;
           }else{
               //smallest element is in left part
               right = mid;
           }
       }
       return left;
    }
}
