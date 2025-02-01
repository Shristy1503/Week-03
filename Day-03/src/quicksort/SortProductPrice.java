package quicksort;

import java.util.Scanner;
import java.util.Arrays;
public class SortProductPrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of products: ");
        int n = input.nextInt();
        double[] productPrice = new double[n];
        System.out.println("Enter product prices: ");
        // take input in loop from user
        for (int i =0;i<n;i++){
            productPrice[i] = input.nextDouble();
        }

        //call quick sort method to sort the product prices
        quickSort(productPrice, 0, n-1);

        //display array
        System.out.println("Sorted price array: ");
        System.out.println(Arrays.toString(productPrice));
    }

    public static void quickSort(double[] arr, int low, int high){
       if (low<high){
           // to store index of pivot
          int pi = partition(arr, low, high);

          //to sort elements before pivot (left part)
          quickSort(arr, low, pi-1); // update high

          //to sort elements after pivot (right part)
          quickSort(arr, pi+1, high); // update low
       }

    }

    //method to do partition by pivot
    public static int partition(double[] arr, int low, int high){
        // set pivot as last element
        double pivot = arr[high];
        //set the i to negative -1 index (i is pointer for swapping)
        int i = low-1;
        for (int j = low ; j<high;j++){
            if (arr[j] < pivot){
                i++;
                // keeping in same position
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //place pivot element at correct position
        double temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
