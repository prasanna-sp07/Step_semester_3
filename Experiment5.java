class Experiment5 {
    private final String[] presentStudents;
    private int count;

    public Experiment5(int maxCapacity) {
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    public boolean markPresent(String studentName) {
        if (studentName == null || isPresent(studentName)) {
            return false;
        }

        if (this.count < this.presentStudents.length) {
            this.presentStudents[this.count] = studentName;
            this.count++;
            return true;
        }

        return false;
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < this.count; i++) {
            if (this.presentStudents[i].equalsIgnoreCase(studentName)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return this.count;
    }

    public static void main(String[] args) {
        Experiment5 sheet = new Experiment5(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}