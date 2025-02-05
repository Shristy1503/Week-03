package stringbuilder.reverseastring;
public class ReverseAString {
    public static void main(String[] args) {
        String text = "Shristy";
        System.out.println("original string: " + text);
        //call method
        String result = reverseString(text);
        System.out.println("reversed string: " + result);
    }

    public static String reverseString(String text){
        // create string builder
        StringBuilder string = new StringBuilder(text);
        //using reverse function
        string.reverse();
        //convert string builder to string
        return string.toString();
    }

}
