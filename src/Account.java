import java.util.Scanner;

public class Account {
    double bal;
    double prevTrans;
    int prevTransType;
    String customerName;
    String customer_acc;
    Account(String name, String account_number) {
        this.customerName = name;
        this.customer_acc = account_number;
    }

    void menuOptions() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Previous Transaction");
        System.out.println("5. Exit");
    }

    void menu() {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("*********************************************");
        System.out.println("Welcome "+customerName);
        System.out.println("Your account number: "+customer_acc);
        System.out.println("");
        menuOptions();

        do {
            System.out.println("******************************************");
            System.out.println("Choose an Option");
            option = sc.nextInt();
            System.out.println("");
            switch(option) {
                case 1:
                    System.out.println(".............");
                    System.out.println("Balance: "+bal);
                    System.out.println(".............");
                    System.out.println("");
                    menuOptions();
                    break;
                case 2:
                    System.out.println(".............");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println(".............");
                    double amount = sc.nextDouble();
                    deposit(amount);
                    System.out.println("");
                    menuOptions();
                    break;
                case 3:
                    System.out.println(".............");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println(".............");
                    double withdraw_amount = sc.nextDouble();
                    withdraw(withdraw_amount);
                    System.out.println("");
                    menuOptions();
                    break;
                case 4:
                    System.out.println(".............");
                    System.out.println("Previous Transaction: ");
                    System.out.println(".............");
                    getPreviousTrans();
                    System.out.println("");
                    menuOptions();
                    break;
                case 5:
                    System.out.println("GoodBye! Have a great Day");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }
        } while(option != 5);
        System.out.println("Thank you for using our banking services");
    }

    void deposit(double amount) {
        if(amount != 0) {
            bal += amount;
            prevTrans = amount;
            prevTransType = 1;
            System.out.println("New baalance: "+ bal);
        }
    }


    void withdraw(double amount) {
        if(amount!=0 && bal>amount) {
            bal-=amount;
            prevTrans = amount;
            prevTransType = 2;
            System.out.println("New Balance: "+bal);
        } else if(bal < amount) {
            System.out.println("Bank balance insufficient");
        }
    }

    void getPreviousTrans() {
        if(prevTransType == 1) {
            System.out.println("Deposited: "+prevTrans);
            System.out.println("Balance: "+bal);
        } else if(prevTransType == 2) {
            System.out.println("Withdrawn: "+prevTrans);
            System.out.println("Balance: "+bal);
        } else {
            System.out.println("No transaction occured");
        }
    }
}
