import java.util.Arrays;

public class Experiment2 {

    /**
     * Sorts the marks array in descending order using Selection Sort
     * and counts how many actual swaps were made.
     * 
     * @param marks Array of student marks
     * @return The total number of swaps performed
     */
    public static int prizeTable(int[] marks) {
        int n = marks.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            // Find the index of the highest mark among the remaining unplaced elements
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap only if the highest mark is not already in the correct position (i)
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swapCount++;
            }
        }

        return swapCount;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] marks1 = {45, 90, 60, 75};
        System.out.println("Sample 1 Input: " + Arrays.toString(marks1));
        int swaps1 = prizeTable(marks1);
        System.out.println("Expected Output: [90, 75, 60, 45] swaps = 2");
        System.out.println("Actual Output:   " + Arrays.toString(marks1) + " swaps = " + swaps1);
        
        System.out.println();

        // Sample 2
        int[] marks2 = {80, 70, 60};
        System.out.println("Sample 2 Input: " + Arrays.toString(marks2));
        int swaps2 = prizeTable(marks2);
        System.out.println("Expected Output: [80, 70, 60] swaps = 0");
        System.out.println("Actual Output:   " + Arrays.toString(marks2) + " swaps = " + swaps2);

        System.out.println();

        // Custom Test Input
        int[] marksCustom = {30, 85, 50, 95, 60};
        System.out.println("Custom Input:    " + Arrays.toString(marksCustom));
        int swapsCustom = prizeTable(marksCustom);
        System.out.println("Actual Output:   " + Arrays.toString(marksCustom) + " swaps = " + swapsCustom);
    }
}