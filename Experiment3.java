import java.util.Arrays;

public class Experiment3 {

    /**
     * Sorts the books array in ascending order using Insertion Sort 
     * and prints the shelf state after each book is inserted/placed.
     * 
     * @param books Array of book numbers
     */
    public static void shelf(int[] books) {
        int n = books.length;

        // Start from the second element (index 1) onwards
        for (int i = 1; i < n; i++) {
            int key = books[i];
            int j = i - 1;

            // Shift elements of the sorted segment to the right 
            // until the correct position for 'key' is found
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }

            // Insert the key into its correct sorted position
            books[j + 1] = key;

            // Print the shelf state after placing the current book
            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        // Sample 1
        int[] books1 = {30, 10, 40, 20};
        System.out.println("Sample 1 Input: " + Arrays.toString(books1));
        shelf(books1);

        System.out.println();

        // Custom Test Input
        int[] booksCustom = {15, 5, 25, 10, 20};
        System.out.println("Custom Input:   " + Arrays.toString(booksCustom));
        shelf(booksCustom);
    }
}