package stackandqueue.implementqueueusingstacks;
import java.util.Scanner;
import java.util.Arrays;
public class AnagramString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string: ");
        String str = sc.next();
        char[] arr = str.toCharArray();
        System.out.println("Original array: " + Arrays.toString(arr));
        // iterate the string combination
        int  result = stringAnagram(str);
        System.out.println("Number of ways " + result);

    }
    public static int  stringAnagram(String str){
        int[] freq = new int[26];
        int n = str.length();
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        int  result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 1) {
                int  fact = 1;
                for (int j = 1; j <= freq[i]; j++) {
                    fact *= j;
                }
                result /= fact;
            }
        }
        return result;
    }
}

