import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private List<Double> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }
}

public class StudentManagementSystem {
    private List<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the Student Management System!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student Information");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudentInfo();
                    break;
                case 3:
                    exitSystem();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        scanner.nextLine(); // Consume the remaining newline character from the previous input
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        Student student = new Student(name, id);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    private void displayStudentInfo() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        Student student = findStudentById(id);
        if (student != null) {
            System.out.println("Student Information:");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Average Grade: " + student.getAverageGrade());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private void exitSystem() {
        System.out.println("Thank you for using the Student Management System. Goodbye!");
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}