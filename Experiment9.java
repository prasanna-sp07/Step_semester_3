class Experiment9 {
    private final String id;
    private String color;

    public Experiment9(String id) {
        this.id = id;
        this.color = "RED"; // Default starting color
    }

    public String next() {
        switch (this.color) {
            case "RED":
                this.color = "GREEN";
                break;
            case "GREEN":
                this.color = "YELLOW";
                break;
            case "YELLOW":
                this.color = "RED";
                break;
        }
        return this.color;
    }

    public String getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        Experiment9 t = new Experiment9("TL-9");
        System.out.println("Initial color: " + t.getColor()); // RED
        System.out.println("Next: " + t.next()); // GREEN
        System.out.println("Next: " + t.next()); // YELLOW
        System.out.println("Next: " + t.next()); // RED
    }
}