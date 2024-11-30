import java.util.Scanner;

public class CollegeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admission admission = new Admission();

        while (true) {
            System.out.println("\nCollege Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Display All Students");
            System.out.println("5. Display All Courses");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    scanner.nextLine(); // consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter gender: ");
                    scanner.nextLine(); // consume newline
                    String gender = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    Student student = new Student(name, age, gender, studentId);
                    admission.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter course name: ");
                    scanner.nextLine(); // consume newline
                    String courseName = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    Course course = new Course(courseName, courseCode);
                    admission.addCourse(course);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter course code: ");
                    scanner.nextLine(); // consume newline
                    String code = scanner.nextLine();
                    admission.enrollStudent(id, code);
                    break;
                case 4:
                    admission.displayAllStudents();
                    break;
                case 5:
                    admission.displayAllCourses();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}