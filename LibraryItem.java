public abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected String author;
    protected boolean isCheckedOut;
    protected String borrowerName;

    public LibraryItem(String itemId, String title, String author) {
        if (itemId == null || itemId.isBlank()) throw new IllegalArgumentException("itemId required");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title required");
        if (author == null || author.isBlank()) throw new IllegalArgumentException("author required");

        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
        this.borrowerName = null;
    }

    public String getItemInfo() {
        return String.format("[%s] %s by %s | Type: %s | Status: %s",
                itemId, title, author, getItemType(), (isCheckedOut ? "Checked out to " + borrowerName : "Available"));
    }

    public void checkOut(String borrowerName) {
        if (this.isCheckedOut) {
            System.out.printf("Item %s is already checked out to %s.%n", itemId, this.borrowerName);
            return;
        }
        this.isCheckedOut = true;
        this.borrowerName = borrowerName;
        System.out.printf("Item %s checked out to %s.%n", itemId, borrowerName);
    }

    public void checkIn() {
        if (!this.isCheckedOut) {
            System.out.printf("Item %s is already available.%n", itemId);
            return;
        }
        System.out.printf("Item %s returned by %s.%n", itemId, this.borrowerName);
        this.isCheckedOut = false;
        this.borrowerName = null;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean getIsCheckedOut() { return isCheckedOut; }
    public String getBorrowerName() { return borrowerName; }

    public abstract String getItemType();
    public abstract double calculateLateFee(int daysLate);
}
