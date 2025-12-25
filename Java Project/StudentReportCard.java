import java.sql.*;
import java.util.*;


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

    int totalMarks() {
        return marks1 + marks2 + marks3;
    }

    double averageMarks() {
        return totalMarks() / 3.0;
    }

    double averageMarks(int bonus) {
        return (totalMarks() + bonus) / 3.0;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo);
    }
}

interface Grade {
    char calculateGrade(double avg);
}

class ReportCard extends Student implements Grade {
    ReportCard(String name, int rollNo, int m1, int m2, int m3) {
        super(name, rollNo, m1, m2, m3);
    }

    public char calculateGrade(double avg) {
        char grade;
        switch ((int) avg / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }
        return grade;
    }

    void showReport() {
        display();
        double avg = averageMarks();
        char grade = calculateGrade(avg);
        System.out.println("Total Marks: " + totalMarks());
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + grade);
        System.out.println("---------------------------");
    }
}

/* --- DB helper used only inside this file (no extra files needed) --- */
class DBHelper {
    // EDIT THESE to match your DB setup
    static final String URL = "jdbc:mysql://localhost:3306/student_db?useSSL=false&allowPublicKeyRetrieval=true";
    static final String USER = "root";
    static final String PASS = "Root@123";  // same password used in the test




    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("MySQL JDBC Driver not found. Add connector JAR to classpath.");
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Create table if not exists
    public static void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                     "roll_no INT PRIMARY KEY," +
                     "name VARCHAR(100) NOT NULL," +
                     "marks1 INT," +
                     "marks2 INT," +
                     "marks3 INT," +
                     "total_marks INT," +
                     "average DOUBLE," +
                     "grade CHAR(1)," +
                     "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                     ")";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    // Insert OR update a reportcard
    public static void saveReportCard(ReportCard rc) {
        String sql = "INSERT INTO students (roll_no, name, marks1, marks2, marks3, total_marks, average, grade) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE name = VALUES(name), marks1 = VALUES(marks1), marks2 = VALUES(marks2), " +
                     "marks3 = VALUES(marks3), total_marks = VALUES(total_marks), average = VALUES(average), grade = VALUES(grade)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, rc.rollNo);
            ps.setString(2, rc.name);
            ps.setInt(3, rc.marks1);
            ps.setInt(4, rc.marks2);
            ps.setInt(5, rc.marks3);
            ps.setInt(6, rc.totalMarks());
            ps.setDouble(7, rc.averageMarks());
            ps.setString(8, String.valueOf(rc.calculateGrade(rc.averageMarks())));

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving reportcard (roll " + rc.rollNo + "): " + e.getMessage());
        }
    }

    // Fetch all saved records and print them
    public static void printAllSavedReports() {
        String sql = "SELECT roll_no, name, marks1, marks2, marks3, total_marks, average, grade, created_at FROM students ORDER BY roll_no";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== SAVED REPORTS IN DATABASE =====");
            boolean any = false;
            while (rs.next()) {
                any = true;
                System.out.println("Roll: " + rs.getInt("roll_no") +
                                   ", Name: " + rs.getString("name") +
                                   ", M1:" + rs.getInt("marks1") +
                                   ", M2:" + rs.getInt("marks2") +
                                   ", M3:" + rs.getInt("marks3") +
                                   ", Total:" + rs.getInt("total_marks") +
                                   ", Avg:" + rs.getDouble("average") +
                                   ", Grade:" + rs.getString("grade") +
                                   ", savedAt:" + rs.getTimestamp("created_at"));
            }
            if (!any) System.out.println("No records found.");
            System.out.println("=====================================");
        } catch (SQLException e) {
            System.err.println("Error reading saved reports: " + e.getMessage());
        }
    }
}

public class StudentReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input students
        System.out.print("Enter number of students: ");
        int n = 0;
        try {
            n = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Invalid number. Exiting.");
            sc.close();
            return;
        }
        sc.nextLine();

        ReportCard[] students = new ReportCard[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Roll No: ");
            int roll = sc.nextInt();
            System.out.print("Marks in 3 subjects (space separated): ");
            int m1 = sc.nextInt(), m2 = sc.nextInt(), m3 = sc.nextInt();
            sc.nextLine();

            students[i] = new ReportCard(name, roll, m1, m2, m3);
        }

        System.out.println("\n===== STUDENT REPORT CARDS =====");
        for (ReportCard s : students) {
            s.showReport();
        }

        // Ask to save to DB
        System.out.print("\nDo you want to save these reports to the database? (y/n): ");
        String opt = sc.nextLine().trim().toLowerCase();
        if (opt.equals("y") || opt.equals("yes")) {
            // Create table and save rows
            DBHelper.createTableIfNotExists();
            for (ReportCard s : students) {
                DBHelper.saveReportCard(s);
            }
            System.out.println("✅ All reports saved to database.");
        } else {
            System.out.println("Reports not saved.");
        }

        // Offer to view saved records
        System.out.print("\nDo you want to view all saved reports from DB? (y/n): ");
        String view = sc.nextLine().trim().toLowerCase();
        if (view.equals("y") || view.equals("yes")) {
            DBHelper.printAllSavedReports();
        }

        sc.close();
        System.out.println("Program finished.");
    }
}