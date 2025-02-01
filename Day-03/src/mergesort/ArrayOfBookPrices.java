package mergesort;
import java.util.Scanner;
import java.util.Arrays;
public class ArrayOfBookPrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of books: ");
        int n = input.nextInt();
        double[] bookPrice = new double[n];
        System.out.println("Enter book prices: ");
        // take input in loop from user
        for (int i =0;i<n;i++){
            bookPrice[i] = input.nextDouble();
        }

        //call method to sort the array
        mergeSort(bookPrice, 0, bookPrice.length-1);

        //display array
        System.out.println("sorted book price array: ");
        System.out.println(Arrays.toString(bookPrice));
    }
    // create method to sort the book prices in array
    public static void mergeSort(double[] arr, int left, int right){
        if(left<right){
           // find the mid element
            int mid = left + (right - left) / 2;

            //divide the left side of array
            mergeSort(arr, left, mid);

            // divide the right side array
            mergeSort(arr, mid+1, right);

             // merge the array and sort them
            merge(arr, left, mid, right);
        }
    }

    // create method to merge the array
    public static void merge(double[] arr, int left, int mid, int right){
        //new array to store the merged array
        double[] mergedPrice = new double[right - left + 1];

        int indx1 = left;
        int indx2 = mid + 1;
        int x = 0;

        while(indx1 <= mid && indx2 <= right){
            if(arr[indx1] <= arr[indx2]){
                mergedPrice[x] = arr[indx1];
                x++; indx1++;
            }else {
                mergedPrice[x] = arr[indx2];
                x++; indx2++;
            }
        }
        // store and store elements in first part
        while (indx1 <= mid){
            mergedPrice[x] = arr[indx1];
            x++; indx1++;
        }
        // store and store elements in second part
        while (indx2 <= right){
            mergedPrice[x] = arr[indx2];
            x++; indx2++;
        }

        // copy the array in merged array
        for(int i=0, j=left;i<mergedPrice.length;i++, j++){
            arr[j] = mergedPrice[i];
        }
    }
}
