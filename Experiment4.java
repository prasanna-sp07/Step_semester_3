class Experiment4 {
    private final int lockerNumber;
    private String code;

    public Experiment4(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }

    public static void main(String[] args) {
        Experiment4 l = new Experiment4(101, "1234");
        System.out.println("Change success: " + l.changeCode("1234", "5678"));
        System.out.println("Change success: " + l.changeCode("0000", "9999"));
    }
}