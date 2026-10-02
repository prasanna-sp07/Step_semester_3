import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate calculateDueDate(LocalDate currentDate);
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

// Main Driver Class
public class Experiment2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = reader.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) return;

        int n = Integer.parseInt(firstLine.trim());
        List<LibraryItem> items = new ArrayList<>();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        // Regex to match: ITEM_TYPE "Item Title"
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"(.*)\"$");

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (line == null) break;

            Matcher matcher = pattern.matcher(line.trim());
            if (matcher.matches()) {
                String type = matcher.group(1);
                String title = matcher.group(2);

                switch (type) {
                    case "BOOK":
                        items.add(new BookItem(title));
                        break;
                    case "DVD":
                        items.add(new DVDItem(title));
                        break;
                    case "MAGAZINE":
                        items.add(new MagazineItem(title));
                        break;
                }
            }
        }

        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.printf("%s: %s\n", item.getTitle(), dueDate.toString());
        }
    }
}