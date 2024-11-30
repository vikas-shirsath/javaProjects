import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Main class for the GUI
public class CollegeManagementGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private Admission admission;

    public CollegeManagementGUI() {
        admission = new Admission();
        setupGUI();
    }

    private void setupGUI() {
        frame = new JFrame("College Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());
        
        setupMainMenu();
        setupAddStudentPanel();
        setupAddCoursePanel();
        setupEnrollStudentPanel();
        setupViewStudentsPanel();
        setupViewCoursesPanel();

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Main menu setup
    private void setupMainMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(6, 1));
        
        JLabel titleLabel = new JLabel("College Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        JButton addStudentButton = new JButton("Add Student");
        JButton addCourseButton = new JButton("Add Course");
        JButton enrollStudentButton = new JButton("Enroll Student in Course");
        JButton viewStudentsButton = new JButton("View All Students");
        JButton viewCoursesButton = new JButton("View All Courses");

        addStudentButton.addActionListener(e -> showPanel("AddStudent"));
        addCourseButton.addActionListener(e -> showPanel("AddCourse"));
        enrollStudentButton.addActionListener(e -> showPanel("EnrollStudent"));
        viewStudentsButton.addActionListener(e -> showPanel("ViewStudents"));
        viewCoursesButton.addActionListener(e -> showPanel("ViewCourses"));

        menuPanel.add(titleLabel);
        menuPanel.add(addStudentButton);
        menuPanel.add(addCourseButton);
        menuPanel.add(enrollStudentButton);
        menuPanel.add(viewStudentsButton);
        menuPanel.add(viewCoursesButton);

        mainPanel.add(menuPanel, "MainMenu");
    }

    private void setupAddStudentPanel() {
        JPanel addStudentPanel = new JPanel();
        addStudentPanel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel genderLabel = new JLabel("Gender:");
        JTextField genderField = new JTextField();
        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField();
        
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            int studentId = Integer.parseInt(studentIdField.getText());

            Student student = new Student(name, age, gender, studentId);
            admission.addStudent(student);

            JOptionPane.showMessageDialog(frame, "Student added successfully!");
            clearFields(nameField, ageField, genderField, studentIdField);
            showPanel("MainMenu");
        });

        addStudentPanel.add(nameLabel);
        addStudentPanel.add(nameField);
        addStudentPanel.add(ageLabel);
        addStudentPanel.add(ageField);
        addStudentPanel.add(genderLabel);
        addStudentPanel.add(genderField);
        addStudentPanel.add(studentIdLabel);
        addStudentPanel.add(studentIdField);
        addStudentPanel.add(new JLabel(""));
        addStudentPanel.add(addButton);

        mainPanel.add(addStudentPanel, "AddStudent");
    }

    private void setupAddCoursePanel() {
        JPanel addCoursePanel = new JPanel();
        addCoursePanel.setLayout(new GridLayout(3, 2));

        JLabel courseNameLabel = new JLabel("Course Name:");
        JTextField courseNameField = new JTextField();
        JLabel courseCodeLabel = new JLabel("Course Code:");
        JTextField courseCodeField = new JTextField();
        
        JButton addButton = new JButton("Add Course");
        addButton.addActionListener(e -> {
            String courseName = courseNameField.getText();
            String courseCode = courseCodeField.getText();

            Course course = new Course(courseName, courseCode);
            admission.addCourse(course);

            JOptionPane.showMessageDialog(frame, "Course added successfully!");
            clearFields(courseNameField, courseCodeField);
            showPanel("MainMenu");
        });

        addCoursePanel.add(courseNameLabel);
        addCoursePanel.add(courseNameField);
        addCoursePanel.add(courseCodeLabel);
        addCoursePanel.add(courseCodeField);
        addCoursePanel.add(new JLabel(""));
        addCoursePanel.add(addButton);

        mainPanel.add(addCoursePanel, "AddCourse");
    }

    private void setupEnrollStudentPanel() {
        JPanel enrollStudentPanel = new JPanel();
        enrollStudentPanel.setLayout(new GridLayout(3, 2));

        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField();
        JLabel courseCodeLabel = new JLabel("Course Code:");
        JTextField courseCodeField = new JTextField();
        
        JButton enrollButton = new JButton("Enroll Student");
        enrollButton.addActionListener(e -> {
            int studentId = Integer.parseInt(studentIdField.getText());
            String courseCode = courseCodeField.getText();
            
            admission.enrollStudent(studentId, courseCode);
            JOptionPane.showMessageDialog(frame, "Student enrolled in course successfully!");
            clearFields(studentIdField, courseCodeField);
            showPanel("MainMenu");
        });

        enrollStudentPanel.add(studentIdLabel);
        enrollStudentPanel.add(studentIdField);
        enrollStudentPanel.add(courseCodeLabel);
        enrollStudentPanel.add(courseCodeField);
        enrollStudentPanel.add(new JLabel(""));
        enrollStudentPanel.add(enrollButton);

        mainPanel.add(enrollStudentPanel, "EnrollStudent");
    }

    private void setupViewStudentsPanel() {
        JPanel viewStudentsPanel = new JPanel();
        viewStudentsPanel.setLayout(new BorderLayout());
        
        JTextArea studentsTextArea = new JTextArea();
        studentsTextArea.setEditable(false);
        
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> {
            studentsTextArea.setText("");
            for (Student student : admission.getStudents()) {
                studentsTextArea.append(student.toString() + "\n");
            }
        });

        viewStudentsPanel.add(new JScrollPane(studentsTextArea), BorderLayout.CENTER);
        viewStudentsPanel.add(refreshButton, BorderLayout.SOUTH);

        mainPanel.add(viewStudentsPanel, "ViewStudents");
    }

    private void setupViewCoursesPanel() {
        JPanel viewCoursesPanel = new JPanel();
        viewCoursesPanel.setLayout(new BorderLayout());

        JTextArea coursesTextArea = new JTextArea();
        coursesTextArea.setEditable(false);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> {
            coursesTextArea.setText("");
            for (Course course : admission.getCourses()) {
                coursesTextArea.append(course.toString() + "\n");
            }
        });

        viewCoursesPanel.add(new JScrollPane(coursesTextArea), BorderLayout.CENTER);
        viewCoursesPanel.add(refreshButton, BorderLayout.SOUTH);

        mainPanel.add(viewCoursesPanel, "ViewCourses");
    }

    private void showPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, panelName);
    }

    private void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CollegeManagementGUI::new);
    }
}