package filereader.counttheoccurrenceofawordinfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountTheOccurrenceOfAWord {
    public static void main(String[] args) {
        //set file path
        String filePath = "src/sample.txt";
        String word = "pets"; //give target word

        int count = countWordOccurrence(filePath, word);

        System.out.println("The word '" + word + "' appears " + count + " times.");
    }

    //method to count occurrence of a word
    public static int countWordOccurrence(String filePath, String word){
        int wordCounter = 0;
        //try block to make sure bufferReader is closed automatically
        try(BufferedReader bufferReader = new BufferedReader(new FileReader(filePath))){
            String line;
            //read each line of file
            while ((line = bufferReader.readLine()) != null){
                //split line into words using space
                String[] array = line.split("\\s+");
                for (String str : array){
                    if(str.equalsIgnoreCase(word)){
                        wordCounter++;
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return wordCounter;
    }
}
