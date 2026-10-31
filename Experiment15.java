public class Experiment15 {

   
    public static void generateResultCard(String name, int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        
        double percentage = (double) total / marks.length;
        char grade;

        if (percentage >= 90) grade = 'A';
        else if (percentage >= 80) grade = 'B';
        else if (percentage >= 70) grade = 'C';
        else if (percentage >= 60) grade = 'D';
        else grade = 'F';

        System.out.println("================================");
        System.out.println("       STUDENT RESULT CARD      ");
        System.out.println("================================");
        System.out.println("Student Name : " + name);
        System.out.println("Total Marks  : " + total + " / " + (marks.length * 100));
        System.out.println("Percentage   : " + String.format("%.2f", percentage) + "%");
        System.out.println("Final Grade  : " + grade);
        System.out.println("================================");
    }

    public static void main(String[] args) {
        String studentName = "Alice Smith";
        int[] subjectMarks = {85, 90, 78, 92, 88};

        generateResultCard(studentName, subjectMarks);
    }
}