import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

class SQLWriter {
    private static final String FILE = "student_report.sql";

    // Append SQL to file
    public static void write(String sql) {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(sql + ";\n");
        } catch (IOException e) {
            System.out.println("Error writing SQL file: " + e.getMessage());
        }
    }

    // CREATE TABLE (written once at program start)
    public static void writeCreateTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Students (\n"
                + "  rollNo INT PRIMARY KEY,\n"
                + "  name VARCHAR(100),\n"
                + "  marks1 INT,\n"
                + "  marks2 INT,\n"
                + "  marks3 INT\n"
                + ")";
        write(sql);
    }

    // INSERT
    public static void writeInsert(Student s) {
        String sql = String.format(
                "INSERT INTO Students (rollNo, name, marks1, marks2, marks3) VALUES (%d, '%s', %d, %d, %d)",
                s.rollNo, s.name, s.marks1, s.marks2, s.marks3
        );
        write(sql);
    }

    // SELECT
    public static void writeSelectAll() {
        write("SELECT * FROM Students");
    }

    // UPDATE example
    public static void writeUpdate(Student s) {
        String sql = String.format(
                "UPDATE Students SET marks1=%d, marks2=%d, marks3=%d WHERE rollNo=%d",
                s.marks1, s.marks2, s.marks3, s.rollNo
        );
        write(sql);
    }

    // DELETE example
    public static void writeDelete(int rollNo) {
        write("DELETE FROM Students WHERE rollNo=" + rollNo);
    }
}


class Student {
    String name;
    int rollNo;
    int marks1, marks2, marks3;

    Student(String name, int rollNo, int m1, int m2, int m3) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
    }
}


class ReportCard extends Student {

    ReportCard(String name, int rollNo, int m1, int m2, int m3) {
        super(name, rollNo, m1, m2, m3);
    }

    void showReport() {
        System.out.println("\n----- Report Card -----");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks 1: " + marks1);
        System.out.println("Marks 2: " + marks2);
        System.out.println("Marks 3: " + marks3);
        System.out.println("Total: " + (marks1 + marks2 + marks3));
        System.out.println("Percentage: " + ((marks1 + marks2 + marks3) / 3.0));

        // Log SELECT statement
        SQLWriter.writeSelectAll();
    }
}


public class StudentReportCard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // CREATE TABLE at start
        SQLWriter.writeCreateTable();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        ReportCard[] students = new ReportCard[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name: ");
            String name = sc.nextLine();

            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();

            System.out.print("Enter three subject marks: ");
            int m1 = sc.nextInt(), m2 = sc.nextInt(), m3 = sc.nextInt();
            sc.nextLine();

            students[i] = new ReportCard(name, roll, m1, m2, m3);

            // INSERT SQL
            SQLWriter.writeInsert(students[i]);
        }

        System.out.println("\n===== STUDENT REPORT CARDS =====");
        for (ReportCard s : students) {
            s.showReport();
        }

        sc.close();
    }
}
