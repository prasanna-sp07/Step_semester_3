import java.util.Arrays;

public class Experiment2 {

    
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] result = new String[n];

        if (n == 0) return result;

        k = k % n;

        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            result[newIndex] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        int k1 = 2;
        String[] result1 = rotateRoster(names1, k1);
        System.out.println("Sample 1 Output: " + Arrays.toString(result1)); 

        String[] names2 = {"A", "B", "C", "D", "E"};
        int k2 = 7;
        String[] result2 = rotateRoster(names2, k2);
        System.out.println("Sample 2 Output: " + Arrays.toString(result2)); 
    }
}
