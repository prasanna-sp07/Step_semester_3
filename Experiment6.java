class Experiment6 {
    private final int maxHealth;
    private int currentHealth;

    public Experiment6(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.currentHealth -= amount;
            if (this.currentHealth < 0) {
                this.currentHealth = 0; // Floored at 0
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.currentHealth += amount;
            if (this.currentHealth > this.maxHealth) {
                this.currentHealth = this.maxHealth; // Capped at max health
            }
        }
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public static void main(String[] args) {
        Experiment6 c = new Experiment6(100);
        c.takeDamage(30);
        System.out.println("Health after 30 damage: " + c.getHealth()); // 70

        c.heal(50);
        System.out.println("Health after 50 heal: " + c.getHealth()); // 100 (capped)

        c.takeDamage(150);
        System.out.println("Health after 150 damage: " + c.getHealth()); // 0 (floored)
    }
}