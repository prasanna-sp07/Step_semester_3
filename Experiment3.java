import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class DeliveryRequest {
    protected double weight;
    protected double distance;

    public DeliveryRequest(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract String getType();
    public abstract double calculateFee();
}

class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }

    @Override
    public double calculateFee() {
        return 5.0 + (weight * 0.50) + (distance * 0.10);
    }
}

class ExpressDelivery extends DeliveryRequest {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }

    @Override
    public double calculateFee() {
        return 15.0 + (weight * 1.00) + (distance * 0.20);
    }
}

class InternationalDelivery extends DeliveryRequest {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }

    @Override
    public double calculateFee() {
        return 25.0 + (weight * 2.00) + (distance * 0.50) + customsFee;
    }
}

public class Experiment3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = reader.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) return;

        int n = Integer.parseInt(firstLine.trim());
        List<DeliveryRequest> requests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (line == null) break;

            String[] parts = line.trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            switch (type) {
                case "STANDARD":
                    requests.add(new StandardDelivery(weight, distance));
                    break;
                case "EXPRESS":
                    requests.add(new ExpressDelivery(weight, distance));
                    break;
                case "INTERNATIONAL":
                    double customsFee = Double.parseDouble(parts[3]);
                    requests.add(new InternationalDelivery(weight, distance, customsFee));
                    break;
            }
        }

        double grandTotal = 0.0;
        for (DeliveryRequest request : requests) {
            double fee = request.calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f\n", request.getType(), fee);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}