package bubblesort;
import java.util.Scanner;
public class SortStudentMarks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of subjects: ");
        int n = input.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter marks of student in each subject: ");
         //taking input inside loop in array
        for (int i =0;i< n;i++){
            marks[i] = input.nextInt();
        }
        //call sorting method
        bubbleSort(marks);
    }

    // bubble sort method to sort the student marks in ascending order
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            // loop to compare adjacent elements
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    //swap the marks to make ascending
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        //display the sorted marks array
        System.out.println("sorted marks: ");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
