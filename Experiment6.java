import java.util.Arrays;

public class Experiment6 {

    /**
     * Finds the maximum achievable profit by buying on one day and selling on a later day.
     * 
     * @param prices Array of daily stock prices
     * @return Maximum profit, or 0 if no profit is possible
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update the minimum price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit if we sold today, and update maxProfit if it's higher
                int currentProfit = prices[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Sample 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Sample 1 Prices: " + Arrays.toString(prices1));
        System.out.println("Expected Output: 5 (buy at 1, sell at 6)");
        System.out.println("Actual Output:   " + maxProfit(prices1));

        System.out.println();

        // Sample 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Sample 2 Prices: " + Arrays.toString(prices2));
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output:   " + maxProfit(prices2));
    }
}