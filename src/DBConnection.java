import java.sql.*;
public interface DBConnection {
    public static Connection connectDB(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
