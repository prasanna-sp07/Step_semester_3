import java.util.Arrays;

public class Experiment7 {

    /**
     * Finds the index of the target if present, or the index it should be 
     * inserted at to maintain sorted order using Binary Search.
     * 
     * @param nums Sorted array of distinct integers
     * @param target Target value to search or insert
     * @return Index of target or insertion position
     */
    public static int searchInsertPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // If not found, 'left' points to the correct insertion index
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        // Sample 1
        System.out.println("Array: " + Arrays.toString(nums) + ", Target: 5");
        System.out.println("Expected Output: 2");
        System.out.println("Actual Output:   " + searchInsertPosition(nums, 5));

        System.out.println();

        // Sample 2
        System.out.println("Array: " + Arrays.toString(nums) + ", Target: 2");
        System.out.println("Expected Output: 1");
        System.out.println("Actual Output:   " + searchInsertPosition(nums, 2));
    }
}