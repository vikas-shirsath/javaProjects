import java.util.ArrayList;


class Admission {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudent(int studentId, String courseCode) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                for (Course course : courses) {
                    if (course.getCourseCode().equals(courseCode)) {
                        student.enrollCourse(course.getCourseName());
                    }
                }
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    
    // New method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // New method to display all courses
    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            System.out.println("List of Courses:");
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }
}
