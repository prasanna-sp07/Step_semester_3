import java.util.ArrayList;
import java.util.List;

public class Experiment8 {

    /**
     * Traverses a 2D grid in spiral order, moving clockwise inward.
     * 
     * @param grid 2D array of integers
     * @return A flat list of elements in spiral order
     */
    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse Right along the top row
            for (int col = left; col <= right; col++) {
                result.add(grid[top][col]);
            }
            top++;

            // 2. Traverse Down along the rightmost column
            for (int row = top; row <= bottom; row++) {
                result.add(grid[row][right]);
            }
            right--;

            // 3. Traverse Left along the bottom row (if still valid)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(grid[bottom][col]);
                }
                bottom--;
            }

            // 4. Traverse Up along the leftmost column (if still valid)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(grid[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Expected Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]");
        System.out.println("Actual Output:   " + spiralOrder(grid));
    }
}