import java.util.Arrays;

public class Experiment1 {

    /**
     * Sorts the student heights using adjacent swaps (Bubble Sort) 
     * and prints the line after every sweep.
     * 
     * @param heights Array of student heights
     */
    public static void lineUp(int[] heights) {
        int n = heights.length;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // Sweep from left to right, comparing adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    // Swap adjacent elements
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            // Print the line after every sweep
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

            // If a sweep makes no swaps at all, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Sample 1
        int[] heights1 = {4, 2, 5, 1};
        System.out.println("Sample 1 Input: " + Arrays.toString(heights1));
        lineUp(heights1);
        
        System.out.println();

        // Sample 2
        int[] heights2 = {1, 3, 2, 4};
        System.out.println("Sample 2 Input: " + Arrays.toString(heights2));
        lineUp(heights2);

        System.out.println();

        // Custom Test Input
        int[] heightsCustom = {5, 3, 1, 4, 2};
        System.out.println("Custom Input: " + Arrays.toString(heightsCustom));
        lineUp(heightsCustom);
    }
}