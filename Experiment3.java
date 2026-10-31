public class Experiment3 {

    
    public static int countInBand(int[] scores, int low, int high) {
        int lowerIndex = findLowerBound(scores, low);
        int upperIndex = findUpperBound(scores, high);
        return upperIndex - lowerIndex;
    }

  
    private static int findLowerBound(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid; // Look for an earlier match on the left
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

  
    private static int findUpperBound(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid; // Look for an earlier match on the left
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        // Sample 1
        int low1 = 42, high1 = 58;
        System.out.println("Sample 1 Output: " + countInBand(scores, low1, high1)); 
        // Expected: 6

        // Sample 2
        int low2 = 90, high2 = 100;
        System.out.println("Sample 2 Output: " + countInBand(scores, low2, high2)); 
        // Expected: 0
    }
}