

public class Experiment7 {

    static boolean isPalindromeIterative(String text) {

        for (int i = 0; i < text.length() / 2; i++) {

            if (text.charAt(i) != text.charAt(text.length() - 1 - i))
                return false;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1)
            return true;

        if (text.charAt(0) != text.charAt(text.length() - 1))
            return false;

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {

        char[] arr = text.toCharArray();

        for (int i = 0; i < arr.length / 2; i++) {

            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return text.equals(new String(arr));
    }

    public static void main(String[] args) {

        String text = "madam";

        System.out.println("Iterative: " +
                (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));

    }
}