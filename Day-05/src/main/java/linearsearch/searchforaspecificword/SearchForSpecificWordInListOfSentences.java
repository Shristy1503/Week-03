package linearsearch.searchforaspecificword;

public class SearchForSpecificWordInListOfSentences {
    public static void main(String[] args) {
        String[] array = {"Today is a good day", " though it was raining yesterday, but still", " the weather is quite good today", " You should go for a walk"};
        String word = "You";
        //method call to get the target word
        String targetSentense = linearSearch(array, word);
        System.out.println("Target sentence: " + targetSentense);
    }
    //method to perform linear search on the list of sentences
    public static String linearSearch(String[] array, String word){

       for (int i=0;i<array.length;i++){
           if(array[i].contains(word)){
               // return the sentence
               return array[i];
           }
       }
       return "Not Found";
    }
}
