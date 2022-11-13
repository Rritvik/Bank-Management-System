import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.sql.Statement;
import java.text.SimpleDateFormat;
public class BankManagement {

    public static void main(String[] args) throws SQLException {

        /** DB Connection Start */
        Connection connection = DBConnection.connectDB();
        /** DB Connection End */

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to our Banking Services. Please select option from below to continue: ");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int option = sc.nextInt();
        String name = "";
        long accountNumber = 0;

        if(option == 1) {
            login(name, accountNumber);
        } else {
            register(connection);
        }
    }

    /** Login Customer */
    public static void login(String name, long accountNumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        name = sc.next();
        System.out.println("Enter account number: ");
        accountNumber = sc.nextLong();
        Account ac1 = new Account(name, accountNumber);
        ac1.menu();
    }

    /** Register new customer */
    public static void register(Connection connection) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String address = "";
        System.out.println("Enter First Name: ");
        String firstName = sc.next();
        System.out.println("Enter Last Name: ");
        String lastName = sc.next();
        System.out.println("Enter phone number: ");
        long phone = sc.nextLong();
        System.out.println("Enter address: ");
        sc.nextLine();
        address = sc.nextLine();
        Random random = new Random();
        long account = random.nextLong(9999999);
        String created_at = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date().getTime());
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into customer (firstname, lastname, account_number, phone, address, created_at) VALUES ('"+firstName+"', '"+lastName+"', '"+account+"', '"+phone+"', '"+address+"', '"+created_at+"');");
        Account ac2 = new Account(firstName, lastName, phone, address, account);
        ac2.menu();
    }
}
