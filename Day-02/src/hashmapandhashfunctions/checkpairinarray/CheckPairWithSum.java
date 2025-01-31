package hashmapandhashfunctions.checkpairinarray;
import java.util.HashSet;
public class CheckPairWithSum {
    public static void main(String[] args) {
        int[] nums = {10, 15, 3, 7};
        int target = 17;
         // call method an store in boolean
        boolean result = hasPairWithSum(nums, target);
        if (result) {
            System.out.println("There exists a pair with the given sum.");
        } else {
            System.out.println("No pair exists with the given sum.");
        }
    }
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;

            // Check if the complement exists in the set
            if (seenNumbers.contains(complement)) {
                return true; // Pair found
            }

            // Add the current number to the set
            seenNumbers.add(num);
        }

        return false; // No pair found
    }
}