class Student {
    // Instance fields
    String name;
    double attendance;

    // Static fields shared across all instances
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; // Increments the static count on each object creation
    }

    // Static method referencing only static fields
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        // Instantiate without assigning unused local variables
        new Student("Ravi", 85.5);
        new Student("Anitha", 92.0);

        // Call static method via Class Name
        Student.printCollegeInfo();
    }
}