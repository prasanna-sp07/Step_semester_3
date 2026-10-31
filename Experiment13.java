public class Experiment13 {

    /**
     * Determines the letter grade based on student marks.
     * 
     * @param marks Integer marks scored (out of 100)
     * @return Letter grade ('A', 'B', 'C', 'D', 'F')
     */
    public static char calculateGrade(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        int[] testScores = {95, 82, 74, 65, 45};

        for (int score : testScores) {
            System.out.println("Marks: " + score + " -> Grade: " + calculateGrade(score));
        }
    }
}