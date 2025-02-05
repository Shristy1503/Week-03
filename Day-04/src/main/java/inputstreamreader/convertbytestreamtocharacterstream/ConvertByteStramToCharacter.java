package inputstreamreader.convertbytestreamtocharacterstream;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertByteStramToCharacter {
    public static void main(String[] args) {
         String file = "src/sample.txt";

         //try block to throw the exception object the program might throw
        try(FileInputStream fileInputStream = new FileInputStream(file);
            //wrapping FileInputStream in an InputStreamReader
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader bufferReader = new BufferedReader(inputStreamReader)) {
            String line ;
            while ((line = bufferReader.readLine()) != null){
                System.out.println(line);
            }
            //catch block handles all the exceptions
        }catch (FileNotFoundException e){
            System.out.println("File not fount exception" + e.getMessage());
        } catch (UnsupportedEncodingException e){
            System.out.println("UnsupportedEncodingException found" + e.getMessage());
        } catch (IOException e){
            System.out.println("IOException found" + e.getMessage());
        }
    }
}
