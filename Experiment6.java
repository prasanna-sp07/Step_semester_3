import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Base Class
abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract String getCustomerType();
    public abstract double calculateFinalAmount();
}

// Concrete Subclasses
class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0; // Full amount + ₹10 service charge
    }
}

// Main Class
public class Experiment6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            switch (type) {
                case "STUDENT":
                    bills.add(new StudentCustomer(amount));
                    break;
                case "STAFF":
                    bills.add(new StaffCustomer(amount));
                    break;
                case "GUEST":
                    bills.add(new GuestCustomer(amount));
                    break;
            }
        }
        scanner.close();

        double grandTotal = 0.0;
        for (Customer customer : bills) {
            double finalAmount = customer.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", customer.getCustomerType(), finalAmount);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}