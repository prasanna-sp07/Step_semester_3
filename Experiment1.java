import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract String getTypeName();
    public abstract double calculateFinalAmount();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public String getTypeName() {
        return "CARD";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02; // 2% fee
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public String getTypeName() {
        return "WALLET";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01; // 1% fee
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public String getTypeName() {
        return "BANKTRANSFER";
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }
}

public class Experiment1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = reader.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) return;
        
        int n = Integer.parseInt(firstLine.trim());
        List<PaymentMethod> transactions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (line == null) break;
            String[] parts = line.trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "CARD":
                    transactions.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    transactions.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    transactions.add(new BankTransferPayment(amount));
                    break;
            }
        }

        double grandTotal = 0.0;
        for (PaymentMethod pm : transactions) {
            double finalAmount = pm.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", pm.getTypeName(), finalAmount);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}