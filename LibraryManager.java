import java.util.ArrayList;

public class LibraryManager {
    private ArrayList<Borrowable> items;

    public LibraryManager() {
        items = new ArrayList<>();
    }

    public void addItem(Borrowable item) {
        items.add(item);
    }

    public void displayAllItems() {
        System.out.println("All items in library:");
        for (Borrowable b : items) {
            LibraryItem li = (LibraryItem) b;
            System.out.println("  - " + li.getItemInfo());
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available items:");
        for (Borrowable b : items) {
            if (b.isAvailable()) {
                LibraryItem li = (LibraryItem) b;
                System.out.println("  - " + li.getItemInfo());
            }
        }
    }

    private LibraryItem findById(String itemId) {
        for (Borrowable b : items) {
            LibraryItem li = (LibraryItem) b;
            if (li.getItemId().equals(itemId)) return li;
        }
        return null;
    }

    public void borrowItem(String itemId, String borrowerName, User user) {
        LibraryItem li = findById(itemId);
        if (li == null) {
            System.out.println("Item with id " + itemId + " not found.");
            return;
        }
        if (!(li instanceof Borrowable)) {
            System.out.println("Item is not borrowable.");
            return;
        }
        Borrowable b = (Borrowable) li;


        if (user.getBorrowedItemsCount() >= user.getMaxBorrowLimit()) {
            System.out.printf("%s has reached max borrow limit (%d).%n", user.getName(), user.getMaxBorrowLimit());
            return;
        }

        if (!b.isAvailable()) {
            System.out.println("Item is not available to borrow.");
            return;
        }

        b.borrowItem(borrowerName);
        user.addBorrowedItem(li);
    }

    public void returnItem(String itemId, User user) {
        LibraryItem li = findById(itemId);
        if (li == null) {
            System.out.println("Item with id " + itemId + " not found.");
            return;
        }
        if (!(li instanceof Borrowable)) {
            System.out.println("Item is not borrowable.");
            return;
        }
        Borrowable b = (Borrowable) li;
        if (b.isAvailable()) {
            System.out.println("Item is already available in library.");
            return;
        }
        b.returnItem();
        user.removeBorrowedItem(li);
    }

    public double calculateTotalLateFees(int daysLate) {
        double total = 0.0;
        for (Borrowable b : items) {
            LibraryItem li = (LibraryItem) b;
            total += li.calculateLateFee(daysLate);
        }
        return total;
    }
}