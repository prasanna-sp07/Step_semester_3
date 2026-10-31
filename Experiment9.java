import java.util.Arrays;

public class Experiment9 {

    /**
     * Finds a pair of values in a sorted array that sum exactly to the target.
     * 
     * @param nums Sorted array of integers
     * @param target Target sum
     * @return String representation of the pair or 'Not Found'
     */
    public static String pairSumSorted(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return "Not Found";
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int currentSum = nums[left] + nums[right];

            if (currentSum == target) {
                return "(" + nums[left] + ", " + nums[right] + ")";
            } else if (currentSum < target) {
                left++;  // Need a larger sum, move left pointer up
            } else {
                right--; // Need a smaller sum, move right pointer down
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 5, 9};
        System.out.println("Sample 1: " + pairSumSorted(nums1, 4)); // Expected: (-1, 5)

        int[] nums2 = {1, 2, 3};
        System.out.println("Sample 2: " + pairSumSorted(nums2, 100)); // Expected: Not Found
    }
}