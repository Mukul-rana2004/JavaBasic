import java.util.*;
import java.sql.*;

public class StudentReportCard {

    // ================= DB CONNECTION =================
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "1234";

    static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("DB Connection Error: " + e.getMessage());
            return null;
        }
    }

    // Create table automatically
    static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS students (
                rollNo INT PRIMARY KEY,
                name VARCHAR(100),
                marks1 INT,
                marks2 INT,
                marks3 INT,
                total INT,
                average DOUBLE,
                grade CHAR(1)
            );
        """;

        try (Connection con = getConnection();
             Statement st = con.createStatement()) {
            st.execute(sql);
        } catch (Exception e) {
            System.out.println("Table Create Error: " + e.getMessage());
        }
    }

    // Insert student data into table
    static void insertStudent(String name, int roll, int m1, int m2, int m3, int total, double avg, char grade) {
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setInt(3, m1);
            ps.setInt(4, m2);
            ps.setInt(5, m3);
            ps.setInt(6, total);
            ps.setDouble(7, avg);
            ps.setString(8, grade + "");

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    // ================= ORIGINAL STUDENT CLASSES =================

    static class Student {
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

        int totalMarks() {
            return marks1 + marks2 + marks3;
        }

        double averageMarks() {
            return totalMarks() / 3.0;
        }

        void display() {
            System.out.println("Name: " + name + ", Roll No: " + rollNo);
        }
    }

    interface Grade {
        char calculateGrade(double avg);
    }

    static class ReportCard extends Student implements Grade {
        ReportCard(String name, int rollNo, int m1, int m2, int m3) {
            super(name, rollNo, m1, m2, m3);
        }

        public char calculateGrade(double avg) {
            if (avg >= 90) return 'A';
            if (avg >= 80) return 'B';
            if (avg >= 70) return 'C';
            if (avg >= 60) return 'D';
            return 'F';
        }

        void showReport() {
            display();
            int total = totalMarks();
            double avg = averageMarks();
            char grade = calculateGrade(avg);

            System.out.println("Total Marks: " + total);
            System.out.println("Average: " + avg);
            System.out.println("Grade: " + grade);
            System.out.println("--------------------------------");

            insertStudent(name, rollNo, marks1, marks2, marks3, total, avg, grade);
        }
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        createTable(); // Create DB table once

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        ReportCard[] students = new ReportCard[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            int roll = sc.nextInt();

            System.out.print("Marks in 3 subjects: ");
            int m1 = sc.nextInt(), m2 = sc.nextInt(), m3 = sc.nextInt();
            sc.nextLine();

            students[i] = new ReportCard(name, roll, m1, m2, m3);
        }

        System.out.println("\n===== STUDENT REPORT CARDS =====");
        for (ReportCard s : students) {
            s.showReport();
        }

        sc.close();
    }
}
