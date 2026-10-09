import java.util.Scanner;

// Interface for capability: Saver Mode Support
interface SaverModeCapable {
    default double getSaverDiscountFactor() {
        return 0.75; // 25% reduction
    }
}

// Abstract Base Class
abstract class Appliance {
    private String name;

    public Appliance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPowerWatts();

    public boolean supportsSaverMode() {
        return this instanceof SaverModeCapable;
    }

    public double calculateUnits(double hours, boolean isSaverRequested) {
        double rawUnits = (getPowerWatts() * hours) / 1000.0;
        if (isSaverRequested) {
            if (supportsSaverMode()) {
                return rawUnits * ((SaverModeCapable) this).getSaverDiscountFactor();
            } else {
                return -1.0; // Unsupported saver mode
            }
        }
        return rawUnits;
    }
}

// Concrete Subclasses
class Fridge extends Appliance {
    public Fridge() {
        super("FRIDGE");
    }

    @Override
    public double getPowerWatts() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverModeCapable {
    public AirConditioner() {
        super("AC");
    }

    @Override
    public double getPowerWatts() {
        return 1500.0;
    }
}

class Television extends Appliance {
    public Television() {
        super("TV");
    }

    @Override
    public double getPowerWatts() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverModeCapable {
    public WashingMachine() {
        super("WASHER");
    }

    @Override
    public double getPowerWatts() {
        return 500.0;
    }
}

// Main Class
public class Experiment10 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) return;

            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            double totalCost = 0.0;

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                String appName = parts[0];
                double hours = Double.parseDouble(parts[1]);
                boolean isSaver = (parts.length > 2 && parts[2].equalsIgnoreCase("SAVER"));

                Appliance appliance = null;
                switch (appName.toUpperCase()) {
                    case "FRIDGE":
                        appliance = new Fridge();
                        break;
                    case "AC":
                        appliance = new AirConditioner();
                        break;
                    case "TV":
                        appliance = new Television();
                        break;
                    case "WASHER":
                        appliance = new WashingMachine();
                        break;
                }

                if (appliance != null) {
                    double units = appliance.calculateUnits(hours, isSaver);
                    if (units < 0) {
                        System.out.printf("%s: saver mode not supported%n", appliance.getName());
                    } else {
                        double cost = units * 8.0;
                        System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
                        totalCost += cost;
                    }
                }
            }

            System.out.printf("Total Cost: %.2f%n", totalCost);
        }
    }
}