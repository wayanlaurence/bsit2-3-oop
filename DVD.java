import java.util.Set;

public class DVD extends LibraryItem implements Borrowable {
    private int duration; // minutes
    private String rating;
    private String genre;

    private static final Set<String> ALLOWED_RATINGS = Set.of("G", "PG", "PG-13", "R", "NC-17");

    public DVD(String itemId, String title, String author, int duration, String rating, String genre) {
        super(itemId, title, author);
        setDuration(duration);
        setRating(rating);
        this.genre = genre == null ? "" : genre;
    }


    public int getDuration() { return duration; }
    public String getRating() { return rating; }
    public String getGenre() { return genre; }


    public void setRating(String rating) {
        if (rating == null || !ALLOWED_RATINGS.contains(rating)) {
            throw new IllegalArgumentException("rating must be one of " + ALLOWED_RATINGS);
        }
        this.rating = rating;
    }

    public void setDuration(int duration) {
        if (duration <= 0) throw new IllegalArgumentException("duration must be positive");
        this.duration = duration;
    }

    @Override
    public String getItemType() {
        return "DVD";
    }

    @Override
    public double calculateLateFee(int daysLate) {
        if (daysLate <= 0) return 0.0;
        return daysLate * 1.00;
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
        return 5;
    }


    @Override
    public String getBorrowingStatus() {
        return "DVD: " + Borrowable.super.getBorrowingStatus();
    }
}