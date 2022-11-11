import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankManagement extends Account implements DBConnection{
    BankManagement(String name, String account_number) {
        super(name, account_number);
    }

    public static void main(String[] args) throws SQLException {

        /** DB Connection Start */
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String password = "";
        // DBConnection db = new DBConnection();
        Connection connection = DBConnection.connectDB(url, username, password);
        /** DB Connection End */

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you name and account number to access your bank account: ");
        String name = sc.nextLine();
        String account_number = sc.nextLine();
        Account ac = new Account(name, account_number);
        ac.menu();
        // Statement statement = connection.createStatement();
        // ResultSet resultset = statement.executeQuery("select * from student");
        
        // while(resultset.next()) {
        //     System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getInt(3));
        // }
    }
}
