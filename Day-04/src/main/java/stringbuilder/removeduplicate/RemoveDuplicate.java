package stringbuilder.removeduplicate;
import java.util.HashSet;
public class RemoveDuplicate {
    public static void main(String[] args) {
        String string = "Success";
        System.out.println("original string: " + string);
        //call method
        String uniqueString = removeDuplicate(string);
        System.out.println("string with unique characters: " + uniqueString);
    }


    //method to remove duplicate from string
    public static String removeDuplicate(String string){
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (char character : string.toCharArray()){
            //check if character already in hashset
            if(!set.contains(character)) {
                //append to string builder
                stringBuilder.append(character);
                //add to hashset
                set.add(character);
            }
        }
        //convert string builder to string and return
        return stringBuilder.toString();
    }

}
