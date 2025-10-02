import java.util.ArrayList;

public abstract class User {
    private String userId;
    private String name;
    private String email;
    private ArrayList<LibraryItem> borrowedItems;

    public User(String userId, String name, String email) {
        if (userId == null || userId.isBlank()) throw new IllegalArgumentException("userId required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("email required");

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
    }


    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public int getBorrowedItemsCount() { return borrowedItems.size(); }


    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public void displayBorrowedItems() {
        System.out.printf("User %s (%s) borrowed items (%d):%n", name, userId, borrowedItems.size());
        if (borrowedItems.isEmpty()) {
            System.out.println("  None");
            return;
        }
        for (LibraryItem li : borrowedItems) {
            System.out.println("  - " + li.getItemInfo());
        }
    }

    public abstract int getMaxBorrowLimit();
}