final class Experiment8 {
    private final String password;

    public Experiment8(String password) {
        this.password = password != null ? password : "";
    }

    public String getStrength() {
        int len = this.password.length();
        if (len < 6) {
            return "Weak";
        } else if (len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        Experiment8 pc1 = new Experiment8("abcd");
        System.out.println("pc1 strength: " + pc1.getStrength()); // Weak

        Experiment8 pc2 = new Experiment8("abcdefghij");
        System.out.println("pc2 strength: " + pc2.getStrength()); // Strong
    }
}