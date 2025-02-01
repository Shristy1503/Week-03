package insertionsort;
import java.util.Scanner;
public class SortEmployeeIds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of employees: ");
        int n = input.nextInt();
        int[] employeeId = new int[n];
        System.out.println("Enter employee ids: ");
        // take input in loop from user
        for (int i =0;i<n;i++){
            employeeId[i] = input.nextInt();
        }
        // call method to sort employee id
        insertionSort(employeeId);
    }

    // method to sort the ids by insertion sort
    public static void insertionSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            //store the value that is to be inserted in correct position
            int currentId = arr[i];
            //compare with previous element5
            int j=i-1;
            //move greater element to one position
            while (j>= 0 && currentId < arr[j] ){
                //shift larger element one steo right
               arr[j+1] = arr[j];
               j--;
            }
            //insert the id in correct position
            arr[j+1] = currentId;
        }
        //display array of employeeId
        System.out.println("Sorted employee ids: ");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
