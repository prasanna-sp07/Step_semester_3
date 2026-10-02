import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class Journey {
    protected double distance;

    public Journey(double distance) {
        this.distance = distance;
    }

    public abstract String getTransportType();
    public abstract double calculateFare();
}

class BusJourney extends Journey {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (distance * 0.10);
        return Math.min(fare, 10.0); // Capped at Max $10
    }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }

    @Override
    public double calculateFare() {
        return 3.0 + (distance * 0.15);
    }
}

class MetroJourney extends Journey {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }

    @Override
    public double calculateFare() {
        return (1.50 + (distance * 0.20)) * peakHourFactor;
    }
}

public class Experiment5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) return;

        int n = Integer.parseInt(firstLine.trim());
        List<Journey> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (line == null) break;

            String[] parts = line.trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            switch (type) {
                case "BUS":
                    journeys.add(new BusJourney(distance));
                    break;
                case "TRAIN":
                    journeys.add(new TrainJourney(distance));
                    break;
                case "METRO":
                    double peakFactor = Double.parseDouble(parts[2]);
                    journeys.add(new MetroJourney(distance, peakFactor));
                    break;
            }
        }

        double grandTotal = 0.0;
        for (Journey j : journeys) {
            double fare = j.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f\n", j.getTransportType(), fare);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}