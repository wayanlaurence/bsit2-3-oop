public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();


        Book b1 = new Book("B00K1", "Code Java", "Ar Pags ", "12345", 500, "Programming");
        Book b2 = new Book("B00K2", "When Pigs Fly", "Raz Gwapo ", "67890", 400, "Fiction");

        Magazine m1 = new Magazine("MAG1", "National Geographic", "Various", 001, "October", false);
        Magazine m2 = new Magazine("MAG2", "TIME", "Various", 002, "September", true);

        DVD d1 = new DVD("DVD1", "Inception", "George Bugwak ", 148, "PG-13", "Sci-Fi");
        DVD d2 = new DVD("DVD2", "Toy Story", "John Lala ", 81, "G", "Animation");


        manager.addItem(b1);
        manager.addItem(b2);
        manager.addItem(m1);
        manager.addItem(m2);
        manager.addItem(d1);
        manager.addItem(d2);


        Student s1 = new Student("U01", "Ryan", "ryan@liceo.edu.ph", "28301", "IT");
        Faculty f1 = new Faculty("U02", "Prof. Raz", "raz@liceo.edu.ph", "BSIT", "Professor");


        manager.displayAllItems();
        System.out.println();


        manager.borrowItem("B00K1", s1.getName(), s1);
        manager.borrowItem("DVD1", f1.getName(), f1);
        manager.borrowItem("MAG2", s1.getName(), s1);

        System.out.println();


        manager.displayAvailableItems();
        System.out.println();


        s1.displayBorrowedItems();
        f1.displayBorrowedItems();
        System.out.println();


        try {

            b2.setNumberOfPages(0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation caught: " + ex.getMessage());
        }


        int daysLate = 3;
        System.out.printf("Total late fees for %d days late (all items): %.2f%n", daysLate, manager.calculateTotalLateFees(daysLate));
        System.out.println();


        System.out.println(d1.getBorrowingStatus());
        System.out.println(b2.getBorrowingStatus());

        System.out.println();


        manager.returnItem("B001", s1);
        manager.returnItem("D001", f1);

        System.out.println();

        manager.displayAllItems();
        System.out.println();
        s1.displayBorrowedItems();
        f1.displayBorrowedItems();
    }
}