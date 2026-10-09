import java.util.Scanner;

// Abstract Base Class
abstract class Plot {
    private String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract String getShapeName();
    public abstract double calculateArea();

    public void printReport() {
        System.out.printf("%s (%s): %.2f%n", owner, getShapeName(), calculateArea());
    }
}

// Subclasses
class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "CIRCLE";
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return "RECTANGLE";
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "TRIANGLE";
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main Runner
public class Experiment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();

            switch (shape.toUpperCase()) {
                case "CIRCLE":
                    double radius = scanner.nextDouble();
                    plots[i] = new CirclePlot(owner, radius);
                    break;
                case "RECTANGLE":
                    double length = scanner.nextDouble();
                    double width = scanner.nextDouble();
                    plots[i] = new RectanglePlot(owner, length, width);
                    break;
                case "TRIANGLE":
                    double base = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    plots[i] = new TrianglePlot(owner, base, height);
                    break;
            }
        }

        double totalArea = 0.0;
        for (Plot plot : plots) {
            plot.printReport();
            totalArea += plot.calculateArea();
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        scanner.close();
    }

}