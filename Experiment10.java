class Experiment10 {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Experiment10(String cartId, int maxCapacity) {
        this.cartId = cartId;
        this.prices = new double[maxCapacity];
        this.itemCount = 0;
    }

    public boolean addItem(double price) {
        if (price >= 0 && this.itemCount < this.prices.length) {
            this.prices[this.itemCount] = price;
            this.itemCount++;
            return true;
        }
        return false;
    }

    public double getTotal() {
        double sum = 0;
        for (int i = 0; i < this.itemCount; i++) {
            sum += this.prices[i];
        }
        return sum;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public String getCartId() {
        return this.cartId;
    }

    public static void main(String[] args) {
        Experiment10 cart = new Experiment10("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + (int) cart.getTotal()); // 500
        System.out.println("Item Count: " + cart.getItemCount()); // 3
    }
}