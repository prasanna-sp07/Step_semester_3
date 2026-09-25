class Experiment1 {
    private final String id;
    private double savings;

    public Experiment1(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
            return true;
        }
        return false;
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        Experiment1 pb = new Experiment1("PB-1");
        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}