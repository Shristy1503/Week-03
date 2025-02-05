package stringbuffer.comparestringbufferwithstringbuilder;

public class CompareStringBufferWithStringBuilder {
    public static void main(String[] args) {
        long startTime, endTime;
        //perform for string buffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer("Class");
        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append("Hello");
        }
        endTime = System.nanoTime();
        // print time taken by string buffer
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");

        //perform for string builder
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder("Class");
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("Hello");
        }
        endTime = System.nanoTime();

       // print time taken by string builder
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");
    }
}
