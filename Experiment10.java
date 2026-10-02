import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Base Class
abstract class Subscription {
    protected String name;
    protected LocalDate startDate;

    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate calculateRenewalDate();
}

// Concrete Subclasses
class BasicPlan extends Subscription {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30); // 30 days validity
    }
}

class StandardPlan extends Subscription {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90); // 90 days validity
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365); // 365 days validity
    }
}

// Main Class
public class Experiment10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<Subscription> subscribers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            switch (planType) {
                case "BASIC":
                    subscribers.add(new BasicPlan(name, startDate));
                    break;
                case "STANDARD":
                    subscribers.add(new StandardPlan(name, startDate));
                    break;
                case "PREMIUM":
                    subscribers.add(new PremiumPlan(name, startDate));
                    break;
            }
        }
        scanner.close();

        for (Subscription sub : subscribers) {
            LocalDate renewalDate = sub.calculateRenewalDate();
            System.out.printf("%s: %s\n", sub.getName(), renewalDate.toString());
        }
    }
}