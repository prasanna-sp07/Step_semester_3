import java.util.Scanner;

public class Experiment11 {

    /**
     * Checks if a given number is a prime number.
     * 
     * @param n Integer to check
     * @return true if prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testNumbers = {2, 11, 4, 1, 29, 35};

        for (int num : testNumbers) {
            System.out.println("Number " + num + " is prime? " + isPrime(num));
        }
    }
}