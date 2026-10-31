public class Experiment5 {


    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int maxRowIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int currentRowTotal = 0;
            
            for (int j = 0; j < grid[i].length; j++) {
                currentRowTotal += grid[i][j];
            }

        
            if (currentRowTotal > maxTotal) {
                maxTotal = currentRowTotal;
                maxRowIndex = i;
            }
        }

        return new int[]{maxRowIndex, maxTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Expected Output: Row 1, Total 7");
        System.out.println("Actual Output:   Row " + result[0] + ", Total " + result[1]);
    }
}