import java.util.Arrays;

public class Experiment10 {

    /**
     * Removes consecutive duplicates from a sorted array in-place.
     * 
     * @param nums Sorted array of integers
     * @return The count of unique values
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0; // Points to the last unique element placed

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        return uniqueIndex + 1; // Length of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        System.out.println("Original: " + Arrays.toString(nums));

        int newLength = removeDuplicates(nums);
        System.out.println("Expected Length: 5, Actual Length: " + newLength);
        
        System.out.print("Modified Array (0 to length-1): [");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + (i < newLength - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}