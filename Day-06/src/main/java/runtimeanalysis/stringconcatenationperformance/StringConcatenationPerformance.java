package runtimeanalysis.stringconcatenationperformance;

public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] stringCounts = {1000, 10000};

        for (int count : stringCounts) {
            System.out.println("Concatenating " + count + " strings:");

            // Using String
            long stringTime = stringConcatenation(count);
            System.out.println("String: " + stringTime + " ms");

            // Using StringBuilder
            long stringBuilderTime = stringBuilderConcatenation(count);
            System.out.println("StringBuilder: " + stringBuilderTime + " ms");

            // Using StringBuffer
            long stringBufferTime = stringBufferConcatenation(count);
            System.out.println("StringBuffer: " + stringBufferTime + " ms");

            System.out.println();
        }
    }
    //method to calculate string concatenation
    public static long stringConcatenation(int count) {
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < count; i++) {
            str += "String" + i;
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
    //method to calculate string builder concatenation
    public static long stringBuilderConcatenation(int count) {
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append("String").append(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
    //method to calculate string buffer concatenation
    public static long stringBufferConcatenation(int count) {
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            stringBuffer.append("String").append(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000; // Convert to milliseconds
    }
}
