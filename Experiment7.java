import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Base Class
abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract String getVehicleType();
    public abstract double calculateCharge();
}

// Concrete Subclasses
class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0; // ₹10 per hour
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }

    @Override
    public double calculateCharge() {
        // ₹30 for first hour, ₹20 per additional hour
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }

    @Override
    public double calculateCharge() {
        double total = hours * 50.0;
        return Math.max(total, 100.0); // Minimum charge of ₹100
    }
}

// Main Class
public class Experiment7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();

            switch (type) {
                case "BIKE":
                    vehicles.add(new Bike(hours));
                    break;
                case "CAR":
                    vehicles.add(new Car(hours));
                    break;
                case "TRUCK":
                    vehicles.add(new Truck(hours));
                    break;
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f\n", v.getVehicleType(), charge);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}