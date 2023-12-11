import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
    int StudentId;
    String name;
    int rollno;
    String classname;
    double marks;
    String address;

    public Student(int StudentId, int rollno, String name, String classname, double marks, String address) {
        this.StudentId = StudentId;
        this.rollno = rollno;
        this.name = name;
        this.classname = classname;
        this.marks = marks;
        this.address = address;
    }
}

class StudentRecordDatabase {
    public static void main(String[] args) {
        String filename = "Student.txt";
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Student record management");
            System.out.print(
                    "1.Create Database\n2.Display Database\n3.Delete Record\n4.Update Database\n5.Search DataBase\n6.Exit\n");
            System.out.print("choose: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    createDatabase(filename, sc);
                    break;
                case 2:
                    displayRecord(filename);
                    break;
                case 3:
                    System.out.println("Enter student ID to be Delete: ");
                    int IDtodelete = sc.nextInt();
                    deleteRecord(filename, IDtodelete);
                    break;
                case 4:
                    System.out.print("Enter Student ID to Update: ");
                    int IDtoupdate = sc.nextInt();
                    updateRecord(filename, IDtoupdate, sc);
                    break;
                case 5:
                    System.out.println("Enter Student ID to be search: ");
                    int IDtosearch = sc.nextInt();
                    searchRecord(filename, IDtosearch);
                    break;
                case 6:
                    System.out.println("Exiting the program..");
                    break;
                default:
                    System.out.print("Invalid choice..entered again!!");
            }
        } while (choice != 6);
        sc.close();
    }

    private static void createDatabase(String filename, Scanner sc) {
        List<Student> students = new ArrayList<>();
        int StudentId, rollno;
        double marks;
        String name, classname, address;
        do {
            System.out.print("Enter the STUDENT ID(-1 to stop): ");
            StudentId = sc.nextInt();
            sc.nextLine();
            if (StudentId != -1) {
                System.out.print("Enter Student Name: ");
                name = sc.nextLine();
                System.out.print("Enter Student roll number: ");
                rollno = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter the Class: ");
                classname = sc.nextLine();
                System.out.print("Enter Marks: ");
                marks = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter Address: ");
                address = sc.nextLine();
                Student student = new Student(StudentId, rollno, name, classname, marks, address);
                students.add(student);
                System.out.print("Student record is added to data base..");
            }
        } while (StudentId != -1);
        saveDatabase(filename, students);
    }

    private static void saveDatabase(String filename, List<Student> students) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename, false))) {
            for (Student student : students) {
                out.writeUnshared(student);
            }
        } catch (IOException e) {
            System.err.println("Unable to open file for writing..");
        }
    }

    private static void displayRecord(String filename) {
        List<Student> students = loadDatabase(filename);
        if (students == null) {
            System.err.println("Unable to open file for reading..");
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
                    break;
                }
            }
            return students;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }

    private static void deleteRecord(String filename, int IDtodelete) {
        List<Student> students = loadDatabase(filename);
        if (students == null) {
            System.err.println("Unable to open file for deletion");
            return;
        }
        boolean found = false;
        students.removeIf(student -> student.StudentId == IDtodelete);
        if (students.size() > 0) {
            saveDatabase(filename, students);
            System.out.println("Student record is deleted..");
        } else {
            System.out.print("Student record not found>>");
        }
    }

    private static void updateRecord(String filename, int IDtoupdate, Scanner sc) {
        List<Student> students = loadDatabase(filename);
        if (students == null) {
            System.err.println("Unable to open file for updation..");
            return;
        }
        boolean found = false;
        for (Student student : students) {
            if (student.StudentId == IDtoupdate) {
                found = true;
                System.out.print("Enter Student Name: ");
                student.name = sc.next();
                System.out.print("Enter Student roll number: ");
                student.rollno = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter the Class: ");
                student.classname = sc.nextLine();
                System.out.print("Enter Marks: ");
                student.marks = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter Address: ");
                student.address = sc.nextLine();
            }
        }
        if (found) {
            saveDatabase(filename, students);
            System.out.print("Student Record is updated..");
        } else {
            System.out.println("Student not found");
        }
    }

    private static void searchRecord(String filename, int IDtosearch) {
        List<Student> students = loadDatabase(filename);
        if (students == null) {
            System.out.println("Unable to open file for searching");
            return;
        }
        boolean found = false;
        for (Student student : students) {
            if (student.StudentId == IDtosearch) {
                found = true;
                printStudentInfo(student);
                break;
            }
        }
        if (!found) {
            System.err.println("Student record not found");
        }
    }

    private static void printStudentInfo(Student student) {
        System.out.println("Student ID:" + student.StudentId);
        System.out.println("Student Name:" + student.name);
        System.out.println("Student Roll number:" + student.rollno);
        System.out.println("Student Class:" + student.classname);
        System.out.println("Student Marks:" + student.marks);
        System.out.println("Student Address:" + student.address);
    }
}
