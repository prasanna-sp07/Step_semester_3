import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Base Class
abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract String getRoomType();
    public abstract double calculateBill();
}

// Concrete Subclasses
class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }

    @Override
    public double calculateBill() {
        return units * 8.0; // ₹8 per unit
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }

    @Override
    public double calculateBill() {
        // ₹6 per unit, divided equally by number of occupants
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "AC";
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0; // ₹10 per unit + fixed charge of ₹200
    }
}

// Main Class
public class Experiment8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    int occupants = scanner.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                case "AC":
                    rooms.add(new ACRoom(units));
                    break;
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", r.getRoomType(), bill);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}