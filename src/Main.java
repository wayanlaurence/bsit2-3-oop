public class Main {


    static class Student {

        private final String name;
        private final int age;
        private final String course;
        private final double grade1;
        private final double grade2;
        private final double grade3;


        public Student(String name, int age, String course, double grade1, double grade2, double grade3) {
            this.name = name;
            this.age = age;
            this.course = course;
            this.grade1 = grade1;
            this.grade2 = grade2;
            this.grade3 = grade3;
        }


        public void displayInfo() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Course: " + course);
        }


        public double calculateAverage() {
            return (grade1 + grade2 + grade3) / 3;
        }


        public String getLetterGrade() {
            double avg = calculateAverage();
            if (avg >= 90) return "A";
            else if (avg >= 80) return "B";
            else if (avg >= 70) return "C";
            else if (avg >= 60) return "D";
            else return "F";
        }


        public boolean isPassing() {
            return calculateAverage() >= 70;
        }
    }


    public static void main(String[] args) {


        Student s1 = new Student("Ar pagums", 20, "Computer Science", 85, 90, 88);
        Student s2 = new Student("lala", 22, "Information Technology", 0, 70, 72);
        Student s3 = new Student("zaza", 21, "Engineering", 85, 80, 78);

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

