public class Experiment14 {

    /**
     * Checks whether a given year is a leap year.
     * 
     * @param year Year to check
     * @return true if it is a leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static void main(String[] args) {
        int[] testYears = {2024, 2023, 1900, 2000};

        for (int year : testYears) {
            System.out.println("Year " + year + " is leap year? " + isLeapYear(year));
        }
    }
}