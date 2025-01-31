package stackandqueue.slidingwindowmaximum;
import java.util.ArrayDeque;
import java.util.Deque;
public class SlidingWindowMaximun {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxValues = slidingWindow(nums, k);

        System.out.print("Sliding Window Maximum: ");
        for (int max : maxValues) {
            System.out.print(max + " ");
        }
    }
        // Function to find the maximum in each sliding window of size k
        public static int[] slidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k <= 0) {
                //return the empty array
                return new int[0];
            }

            int n = nums.length;
            int[] result = new int[n - k + 1];
            //create a deque to store elements index
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // Remove indices for loop
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                // Add the current index to the deque
                deque.offerLast(i);
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }
            return result;
        }
}
