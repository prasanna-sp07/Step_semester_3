import java.util.Arrays;

public class Experiment5 {

    /**
     * Counts the occurrences of each die roll (1 to 6) and sorts them 
     * in increasing order using Counting Sort without element comparisons.
     * 
     * @param rolls Array of dice rolls
     * @return Sorted array of dice rolls
     */
    public static int[] diceSort(int[] rolls) {
        // Count array of size 7 to accommodate values 1 through 6
        int[] count = new int[7];

        // Step 1: Count the frequency of each roll
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                count[roll]++;
            }
        }

        // Step 2: Print the counts in the specified format
        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i] + (i < 6 ? " " : ""));
        }
        System.out.println();

        // Step 3: Reconstruct and return the sorted array using the counts
        int[] sortedRolls = new int[rolls.length];
        int index = 0;
        for (int i = 1; i <= 6; i++) {
            while (count[i] > 0) {
                sortedRolls[index++] = i;
                count[i]--;
            }
        }

        return sortedRolls;
    }

    public static void main(String[] args) {
        // Sample Input
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        System.out.println("Sample 1 Input: " + Arrays.toString(rolls1));
        int[] sorted1 = diceSort(rolls1);
        System.out.println("Sorted: " + Arrays.toString(sorted1));

        System.out.println();

        // Custom Test Input
        int[] rollsCustom = {6, 3, 3, 1, 5, 2, 6, 3};
        System.out.println("Custom Input:   " + Arrays.toString(rollsCustom));
        int[] sortedCustom = diceSort(rollsCustom);
        System.out.println("Sorted: " + Arrays.toString(sortedCustom));
    }
}