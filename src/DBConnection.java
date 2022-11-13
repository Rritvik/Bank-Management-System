import java.sql.*;
public class DBConnection {
    public static Connection connectDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/bank_management";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
