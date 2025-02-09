package runtimeanalysis.largefilereading;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
public class LargeFileReading {
    public static void main(String[] args) {
        // Specify the file sizes to test
        long[] fileSizes = {1_000_000, 100_000_000};

        for (long size : fileSizes) {
            System.out.println("Reading file of size: " + (size / (1024 * 1024)) + " MB");

            // Measure time for FileReader
            long fileReaderTime = measureFileReaderTime("sample.txt");
            System.out.println("FileReader Time: " + fileReaderTime + " ms");

            // Measure time for InputStreamReader
            long inputStreamReaderTime = measureInputStreamReaderTime("sample.txt");
            System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");

            System.out.println();
        }
    }
    //measure file reader time
    public static long measureFileReaderTime(String filePath) {
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            char[] buffer = new char[8192];
            while (fileReader.read(buffer) != -1) {
                // Reading the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000;
    }
    //measure input stream time
    public static long measureInputStreamReaderTime(String filePath) {
        long startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            char[] buffer = new char[8192];
            while (inputStreamReader.read(buffer) != -1) {
                // Reading the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000; // Convert to milliseconds
    }
}
