package selectionsort;
import java.util.Scanner;
public class SortExamScores {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.println("Enter number of scores: ");
       int n = input.nextInt();
       int[] score = new int[n];
        System.out.println("Enter exam scores: ");
       // take input in loop from user
        for (int i =0;i<n;i++){
            score[i] = input.nextInt();
        }

        // call sort method
        selectionSort(score);
    }

    // create selection sort method to sort exam score
    public static void selectionSort(int[] arr){
       for (int i=0;i<arr.length-1;i++){
           int smallest = i;
           for (int j=i+1;j<arr.length; j++){
               //if current element greater than smallest
              if (arr[smallest] > arr[j]){
                  smallest = j;  //change the smallest
              }
           }
           //swap if smallest
           int temp = arr[smallest];
           arr[smallest] = arr[i];
           arr[i] = temp;
       }
       // display the scores
        System.out.println("Sorted exam scores: ");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
