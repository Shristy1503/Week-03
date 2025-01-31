package hashmapandhashfunctions.longestconsecutivesequence;
import java.util.*;
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(nums);
        System.out.println("Length of the longest consecutive sequence: " + result); // Output: 4

    }
    //method to print find longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> numMap = new HashMap<>();

        // Store each number in the HashMap
        for (int num : nums) {
            numMap.put(num, true);
        }

        int longestStreak = 0;

        for (int num : numMap.keySet()) {
            // Check if it's the start of a sequence
            if (!numMap.containsKey(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numMap.containsKey(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}