import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;
    int registeredStudents;

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = 0;
    }

    boolean registerStudent() {
        if (registeredStudents < capacity) {
            registeredStudents++;
            return true;
        } else {
            return false;
        }
    }

    void dropStudent() {
        if (registeredStudents > 0) {
            registeredStudents--;
        }
    }
}

class Student {
    String id;
    String name;
    ArrayList<String> registeredCourses;

    Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

public class Course_Management_System {
    private static HashMap<String, Course> courseDatabase = new HashMap<>();
    private static HashMap<String, Student> studentDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample courses
        courseDatabase.put("CS101", new Course("CS101", "Computer Science", "Basic CS concepts", 2, "MWF 9-10am"));
        courseDatabase.put("MA101", new Course("MA101", "Mathemetics", "Introduction to Calculus", 2, "TTh 10-11:30am"));

        // Sample students
        studentDatabase.put("101", new Student("101", "Ashish"));
        studentDatabase.put("102", new Student("102", "Rahul"));

        while (true) {
            System.out.println("1. List Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Drop Course");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    registerForCourse(scanner);
                    break;
                case 3:
                    dropCourse(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void listCourses() {
        for (Course course : courseDatabase.values()) {
            System.out.println(course.code + ": " + course.title + " (" + course.description + ") - " +
                    course.schedule + "\n [Capacity: " + course.capacity + ", Registered: " + course.registeredStudents + "]");
        }
    }

    private static void registerForCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.next();

        Student student = studentDatabase.get(studentId);
        Course course = courseDatabase.get(courseCode);

        if (student != null && course != null) {
            if (course.registerStudent()) {
                student.registerCourse(courseCode);
                System.out.println("Registered successfully.");
            } else {
                System.out.println("Course is full.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    private static void dropCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.next();

        Student student = studentDatabase.get(studentId);
        Course course = courseDatabase.get(courseCode);

        if (student != null && course != null) {
            student.dropCourse(courseCode);
            course.dropStudent();
            System.out.println("Dropped successfully.");
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }
}
