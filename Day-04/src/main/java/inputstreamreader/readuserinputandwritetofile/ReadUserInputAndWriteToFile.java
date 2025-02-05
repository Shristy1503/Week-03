package inputstreamreader.readuserinputandwritetofile;
import java.io.*;
import java.util.*;
public class ReadUserInputAndWriteToFile {
    public static void main(String[] args) {
        String file = "src/sample.txt";

       try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            //write input stream in buffer reader for efficient reading
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter(file, true);
            //for efficient writing in file
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter)) {
           System.out.println("Enter text in new line(till exit entered): ");
           String line;
           while (true){
               line = bufferReader.readLine();
               //condition to break the loop and save changes
               if ("exit".equalsIgnoreCase(line)){
                   break;
               }
               bufferWriter.write(line); // write lines in new line
               bufferWriter.newLine();
           }
           System.out.println("Text saved in " + file);
       }catch (IOException e){
           System.out.println("Error" + e.getMessage());
       }
    }
}
