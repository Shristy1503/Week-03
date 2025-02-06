package linearsearch.searchforfirstnegativenumber;

public class SearchForTheFirstNegativeNumber {
    public static void main(String[] args) {
        //integer array
         int[] array = {34, 5, 76, -1, 7, 9};
         //method call to get index
         int resultIndex = linearSearch(array);
        System.out.println("Index of first negative number index is: " + resultIndex);
    }

    //method to perform linear search
    public static int linearSearch(int[] array){
        for (int i=0;i<array.length-1;i++){
            //check if negative index occurs
          if(array[i] < 0){
              return i; // return index of negative number
          }
        }
        //return if no negative number found
        return -1;
    }
}
