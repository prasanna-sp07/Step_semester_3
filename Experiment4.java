import java.util.Arrays;

public class Experiment4 {

    /**
     * Finds the index of the first student whose token number is smaller 
     * than the token of the student just before them.
     * 
     * @param tokens Array of student token numbers
     * @return Index of the first break, or -1 if the queue is in order
     */
    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length < 2) {
            return -1;
        }

        // Traverse from the second element to the end
        for (int i = 1; i < tokens.length; i++) {
            // Check if the current token breaks the non-decreasing order
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        // Return -1 if the whole queue is in order
        return -1;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println("Sample 1 Input: " + Arrays.toString(tokens1));
        int index1 = firstBreak(tokens1);
        System.out.println("Expected Output: 4 (6 comes after 8)");
        System.out.println("Actual Output:   " + index1);

        System.out.println();

        // Sample 2
        int[] tokens2 = {1, 2, 2, 7};
        System.out.println("Sample 2 Input: " + Arrays.toString(tokens2));
        int index2 = firstBreak(tokens2);
        System.out.println("Expected Output: -1");
        System.out.println("Actual Output:   " + index2);

        System.out.println();

        // Custom Test Input
        int[] tokensCustom = {10, 20, 20, 30, 25, 40};
        System.out.println("Custom Input:    " + Arrays.toString(tokensCustom));
        int indexCustom = firstBreak(tokensCustom);
        System.out.println("Actual Output:   " + indexCustom);
    }
}