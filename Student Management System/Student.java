import java.util.ArrayList;

class Student extends Person {
    private int studentId;
    private ArrayList<String> enrolledCourses = new ArrayList<>();

    public Student(String name, int age, String gender, int studentId) {
        super(name, age, gender);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void enrollCourse(String courseName) {
        enrolledCourses.add(courseName);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Enrolled Courses: " + enrolledCourses;
    }
}
