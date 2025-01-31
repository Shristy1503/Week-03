package hashmapandhashfunctions.subarrayszerosum;
import java.util.HashSet;
public class SubArraysWithZeroSum {
    public static void main(String[] args) {
        int[] nums = {10, 15, 3, 7};
        int target = 17;

        boolean result = hasPairWithSum(nums, target);
        if (result) {
            System.out.println("There exists a pair with the given sum.");
        } else {
            System.out.println("No pair exists with the given sum.");
        }
    }

    //method to check a pair with given sum
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();
      //calculate the complement
        for (int num : nums) {
            int complement = target - num;
            if (seenNumbers.contains(complement)) {
                return true;
            }
            // Add the current number to the set
            seenNumbers.add(num);
        }
        return false;
    }
}
