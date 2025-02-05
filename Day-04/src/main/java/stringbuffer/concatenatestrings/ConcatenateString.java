package stringbuffer.concatenatestrings;

public class ConcatenateString {
    public static void main(String[] args) {
        String[] string = {"Welcome", " ", "to"," ", "java", ", ", "everyone", "!"};
        //method call
        String result = concatenate(string);
        System.out.println(result);
    }
    // method to concatenate array elements in string
    public static String concatenate(String[] string){
        //create an object for string buffer
        StringBuffer text = new StringBuffer();
        for (String input : string){
            text.append(input);
        }
        //convert string buffer to string
        return text.toString();
    }
}
