public class Book extends LibraryItem implements Borrowable {
    private String isbn;
    private int numberOfPages;
    private String genre;

    public Book(String itemId, String title, String author, String isbn, int numberOfPages, String genre) {
        super(itemId, title, author);
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("isbn required");
        setNumberOfPages(numberOfPages);
        setGenre(genre);
        this.isbn = isbn;
    }


    public String getIsbn() { return isbn; }
    public int getNumberOfPages() { return numberOfPages; }
    public String getGenre() { return genre; }


    public void setNumberOfPages(int pages) {
        if (pages <= 0) throw new IllegalArgumentException("numberOfPages must be positive");
        this.numberOfPages = pages;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.isBlank()) throw new IllegalArgumentException("genre cannot be null or empty");
        this.genre = genre;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public double calculateLateFee(int daysLate) {
        if (daysLate <= 0) return 0.0;
        return daysLate * 0.50;
    }


    @Override
    public void borrowItem(String borrowerName) {
        checkOut(borrowerName);
    }

    @Override
    public void returnItem() {
        checkIn();
    }

    @Override
    public boolean isAvailable() {
        return !isCheckedOut;
    }

    @Override
    public int getBorrowingPeriod() {
        return 14;
    }
}