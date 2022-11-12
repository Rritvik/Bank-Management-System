import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Statement;
import java.text.SimpleDateFormat;
public class BankManagement extends Account {
    BankManagement(String name, double account_number) {
        super(name, account_number);
    }

    public static void main(String[] args) throws SQLException {

        /** DB Connection Start */
        Connection connection = DBConnection.connectDB();
        /** DB Connection End */

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to our Banking Services. Please select option from below to continue: ");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int option = sc.nextInt();
        String name;
        double account_number;
        switch(option) {
            case 1: 
                System.out.println("Enter your Name: ");
                name = sc.next();
                System.out.println("Enter account number: ");
                account_number = sc.nextDouble();
                Account ac1 = new Account(name, account_number);
                ac1.menu();
                break;

            case 2:
                String address = "";
                System.out.println("Enter First Name: ");
                String firstName = sc.next();
                System.out.println("Enter Last Name: ");
                String lastName = sc.next();
                System.out.println("Enter phone number: ");
                double phone = sc.nextDouble();
                System.out.println("Enter address: ");
                sc.nextLine();
                address = sc.nextLine();
                Random random = new Random();
                double account = random.nextInt(9999999);
                String created_at = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date().getTime());
                Statement statement = connection.createStatement();
                statement.executeUpdate("insert into customer (firstname, lastname, account_number, phone, address, created_at) VALUES ('"+firstName+"', '"+lastName+"', '"+(int)account+"', '"+phone+"', '"+address+"', '"+created_at+"');");
                Account ac2 = new Account(firstName, lastName, phone, address, (int)account);
                ac2.menu();
        }
        
        // Statement statement = connection.createStatement();
        // ResultSet resultset = statement.executeQuery("select * from student");
        
        // while(resultset.next()) {
        //     System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getInt(3));
        // }
    }
}
