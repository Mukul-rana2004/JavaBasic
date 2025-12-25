import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "12345"
            );

            if(con != null) {
                System.out.println("✅ Database Connected Successfully!");
            } else {
                System.out.println("❌ Connection Failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
