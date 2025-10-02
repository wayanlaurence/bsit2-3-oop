public class Student extends User {
    private String studentId;
    private String major;

    public Student(String userId, String name, String email, String studentId, String major) {
        super(userId, name, email);
        if (studentId == null || studentId.isBlank()) throw new IllegalArgumentException("studentId required");
        this.studentId = studentId;
        this.major = major == null ? "" : major;
    }

    public String getStudentId() { return studentId; }
    public String getMajor() { return major; }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }
}