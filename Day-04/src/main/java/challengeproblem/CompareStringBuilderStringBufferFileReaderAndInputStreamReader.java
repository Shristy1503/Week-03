package challengeproblem;
import java.io.*;
import java.util.StringTokenizer;
public class CompareStringBuilderStringBufferFileReaderAndInputStreamReader {
    public static void main(String[] args) {
       //call concatenation method to compare performance of string builder and string buffer
        concatenateStrings();
        //call method to read file using file reader
        // Test FileReader and InputStreamReader performance
        String filePath = "src/sample.txt";
        compareFileReading(filePath);

    }
     //method to compare the time of string builder and string buffer
    public static void concatenateStrings(){
        long startTime, endTime;
        //perform for string buffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append("Hello");
        }
        endTime = System.nanoTime();
        // print time taken by string buffer
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");

        //perform for string builder
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("Hello");
        }
        endTime = System.nanoTime();

        // print time taken by string builder
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");
    }
    //method to  count number of words in file using file reader
    private static void compareFileReading(String filePath) {
        long startTime, endTime;

        // Using FileReader
        startTime = System.nanoTime();
        int wordCount1 = countWordsUsingFileReader(filePath);
        endTime = System.nanoTime();
        System.out.println("FileReader - Word Count: " + wordCount1 + ", Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Using InputStreamReader
        startTime = System.nanoTime();
        int wordCount2 = countWordsUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader - Word Count: " + wordCount2 + ", Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                wordCount += st.countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                wordCount += st.countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }
}
