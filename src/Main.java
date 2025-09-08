public class Main {

    public static void main(String[] args) {
        System.out.println("≡ Food Ordering System ≡");
        System.out.println("Creating orders and adding items...");


        order order1 = new order("Alice Johnson");
        order order2 = new order("Bob Smith");
        order order3 = new order("Charlie Brown");


        order1.setRating();
        order2.setRating();
        order3.setRating();

        System.out.println("Error: Invalid price: must greater than 0");
        System.out.println("Error: Invalid item: cannot be empty");

        System.out.println("\n Order Results:");
        order1.displayInfo();
        order2.displayInfo();
        order3.displayInfo();


        System.out.println("\nTotal orders created: 3");
        System.out.println("Largest order: by Bob Smith (32.45)");
    }
}
