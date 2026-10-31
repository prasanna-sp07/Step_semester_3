public class Experiment6 {

    /**
     * Counts and prints the total number of vowels and consonants in a given word.
     * 
     * @param word The input word containing only alphabetic characters
     */
    public static void countVowelsAndConsonants(String word) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            // Convert character to lowercase for case-insensitive checking
            char ch = Character.toLowerCase(word.charAt(i));

            // Check if the character is an alphabet letter
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        // Sample Input
        String word = "Programming";
        
        System.out.println("Sample Input: " + word);
        countVowelsAndConsonants(word);
        // Expected Output: 
        // Vowels: 3
        // Consonants: 8
    }
}