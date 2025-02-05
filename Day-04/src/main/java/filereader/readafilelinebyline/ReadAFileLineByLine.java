package filereader.readafilelinebyline;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAFileLineByLine {
    public static void main(String[] args) {
        String filePath = "src/sample.txt"; // Specify the path

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            // Use a loop to read each line
            while ((line = bufferedReader.readLine()) != null) {
                // Print the current line
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any IO exceptions
        }
    }

}
