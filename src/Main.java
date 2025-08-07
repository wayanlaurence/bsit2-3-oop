
public class Main {
    public static void main(String[] args) {
        
        Student s1 = new Student("Ar pags", 20, "Computer Science", 85, 90, 88);
        Student s2 = new Student("Bob agus", 22, "Information Technology", 70, 65, 72);
        Student s3 = new Student("Charlie Blue", 21, "Engineering", 55, 60, 58);

        Student[] students = {s1, s2, s3};
        int passingCount = 0;

        
        for (Student s : students) {
            System.out.println("------------");
            s.displayInfo();
            double average = s.calculateAverage();
            System.out.printf("Average Grade: %.2f\n", average);
            System.out.println("Letter Grade: " + s.getLetterGrade());
            System.out.println("Status: " + (s.isPassing() ? "PASSING" : "FAILING"));
            if (s.isPassing()) passingCount++;
        }

        
        System.out.println("------------");
        System.out.println("Total number of PASSING students: " + passingCount);
    }
}
