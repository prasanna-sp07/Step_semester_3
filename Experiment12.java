public class Experiment12 {

    /**
     * Calculates the factorial of a non-negative integer.
     * 
     * @param n Number to calculate factorial for
     * @return Factorial result
     */
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Reverses the digits of an integer.
     * 
     * @param n Integer to reverse
     * @return Reversed integer
     */
    public static int reverseDigits(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " = " + calculateFactorial(num));

        int original = 12345;
        System.out.println("Original: " + original + ", Reversed: " + reverseDigits(original));
    }
}