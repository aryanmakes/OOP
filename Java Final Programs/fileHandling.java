import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
    int studentId;
    String name;
    int rollNo;
    String className;
    double marks;
    String address;

    public Student(int studentId, String name, int rollNo, String className, double marks, String address) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
        this.marks = marks;
        this.address = address;
    }
}

class StudentRecordDatabase {
    public static void main(String[] args) {
        String filename = "student_database.dat";
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Student Record Database Management");
            System.out.println("1. Create Database");
            System.out.println("2. Display Database");
            System.out.println("3. Delete Record");
            System.out.println("4. Update Record");
            System.out.println("5. Search Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createDatabase(filename, scanner);
                    break;
                case 2:
                    displayDatabase(filename);
                    break;
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    int studentIdToDelete = scanner.nextInt();
                    deleteRecord(filename, studentIdToDelete);
                    break;
                case 4:
                    System.out.print("Enter Student ID to update: ");
                    int studentIdToUpdate = scanner.nextInt();
                    updateRecord(filename, studentIdToUpdate, scanner);
                    break;
                case 5:
                    System.out.print("Enter Student ID to search: ");
                    int studentIdToSearch = scanner.nextInt();
                    searchRecord(filename, studentIdToSearch);
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void createDatabase(String filename, Scanner scanner) {
        List<Student> students = new ArrayList<>();
        int studentId, rollNo;
        double marks;
        String name, className, address;

        do {
            System.out.print("Enter Student ID (or -1 to stop): ");
            studentId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (studentId != -1) {
                System.out.print("Enter Name: ");
                name = scanner.nextLine();
                System.out.print("Enter Roll No: ");
                rollNo = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter Class: ");
                className = scanner.nextLine();
                System.out.print("Enter Marks: ");
                marks = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter Address: ");
                address = scanner.nextLine();

                Student student = new Student(studentId, name, rollNo, className, marks, address);
                students.add(student);
                System.out.println("Student record added to the database.");
            }
        } while (studentId != -1);

        saveDatabase(filename, students);
    }

    private static void saveDatabase(String filename, List<Student> students) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename, false))) {
            for (Student student : students) {
                out.writeObject(student);
            }
        } catch (IOException e) {
            System.err.println("Unable to open the file for writing.");
        }
    }

    private static void displayDatabase(String filename) {
        List<Student> students = loadDatabase(filename);
        if (students == null) {
            System.err.println("Unable to open the file for reading.");
        } else {
            for (Student student : students) {
                printStudentInfo(student);
            }
        }
    }

    private static List<Student> loadDatabase(String filename) {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Student student = (Student) in.readObject();
                    students.add(student);
                } catch (EOFException e) {
                    break; // Reached the end of the file
                }
            }
            return students;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }

    private static void deleteRecord(String filename, int studentIdToDelete) {
        List<Student> students = loadDatabase(filename);
        if (students == null) {
            System.err.println("Unable to open the file for deletion.");
            return;
        }

        boolean found = false;
        students.removeIf(student -> student.studentId == studentIdToDelete);

        if (students.size() > 0) {
            saveDatabase(filename, students);
            System.out.println("Student record deleted.");
        } else {
            System.err.println("Student record not found.");
        }
    }

    private static void updateRecord(String filename, int studentIdToUpdate, Scanner scanner) {
        List<Student> students = loadDatabase(filename);
        if (students == null) {
            System.err.println("Unable to open the file for updating.");
            return;
        }

        boolean found = false;
        for (Student student : students) {
            if (student.studentId == studentIdToUpdate) {
                found = true;
                System.out.print("Enter updated Name: ");
                student.name = scanner.nextLine();
                System.out.print("Enter updated Roll No: ");
                student.rollNo = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter updated Class: ");
                student.className = scanner.nextLine();
                System.out.print("Enter updated Marks: ");
                student.marks = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter updated Address: ");
                student.address = scanner.nextLine();
            }
        }

        if (found) {
            saveDatabase(filename, students);
            System.out.println("Student record updated.");
        } else {
            System.err.println("Student record not found.");
        }
    }

    private static void searchRecord(String filename, int studentIdToSearch) {
        List<Student> students = loadDatabase(filename);
        if (students == null) {
            System.err.println("Unable to open the file for searching.");
            return;
        }

        boolean found = false;
        for (Student student : students) {
            if (student.studentId == studentIdToSearch) {
                found = true;
                printStudentInfo(student);
                break;
            }
        }

        if (!found) {
            System.err.println("Student record not found.");
        }
    }

    private static void printStudentInfo(Student student) {
        System.out.println("Student ID: " + student.studentId);
        System.out.println("Name: " + student.name);
        System.out.println("Roll No: " + student.rollNo);
        System.out.println("Class: " + student.className);
        System.out.println("Marks: " + student.marks);
        System.out.println("Address: " + student.address);
    }
}
