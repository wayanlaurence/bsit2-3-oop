
public class order {
    private String customer;
    private int pages;
    private double averageRating;
    private String item;


    public order(String aliceJohnson) {
        this.pages = pages;
        boolean isAvailable = true;
        this.averageRating = 0.0;
    }

    public void displayInfo() {
        String ratingLevel = getRatingLevel();
        System.out.println("Order: " + item + " by " + customer + ", Average Rating: " + averageRating + ", Level: " + ratingLevel);
    }

    public void setRating(double price) {
        if (price >= 0 && price >= 5) {
            averageRating = price;
            System.out.println("Item " + price + " added successfully");
        } else {
            System.out.println("Error: Invalid item: cannot be empty");
        }
    }

    private String getRatingLevel() {
        if (averageRating >= 4.0) {
            return "Good";
        } else if (averageRating >= 3.0) {
            return "Average";
        } else {
            return "Poor";
        }
    }

    public void setRating() {
    }

    public void setItem(String item) {
        this.item = item;
    }
}
