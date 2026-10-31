public class Experiment4 {

    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score == highest || score == second) {
                continue;
            }

            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println("Sample 1 Output: " + secondHighest(scores1)); 
        // Expected: 78

        // Sample 2
        int[] scores2 = {50, 50, 50};
        System.out.println("Sample 2 Output: " + secondHighest(scores2)); 
        // Expected: -1
    }
}