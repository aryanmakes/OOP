import java.util.*;

class Customer {
    private String customerName;
    private int customerAge;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public int getCustomerAge() {
        return customerAge;
    }
}

abstract class Account {
    protected double balance;
    protected int accountId;
    protected String accountType;
    protected Customer custobj;

    void setBalance(double balance) {
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    int getAccountId() {
        return accountId;
    }

    void SetAccountType(String accountType) {
        this.accountType = accountType;
    }

    String getAccountType() {
        return accountType;
    }

    void setCustomerObject(Customer custobj) {
        this.custobj = custobj;
    }

    Customer getCustomerObject() {
        return custobj;
    }

    public abstract boolean withdraw(double amount);
}

class SavingAccount extends Account {
    private double minimumBalance;

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    double getMinimumBalance() {
        return minimumBalance;
    }

    public boolean withdraw(double amount) {
        if ((balance - amount) > minimumBalance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class Bank {
    public static Scanner sc = new Scanner(System.in);
    public SavingAccount a = new SavingAccount();
    public Customer c = new Customer();

    public SavingAccount createAccount() {
        System.out.println("Enter Name: ");
        String customername = sc.nextLine();
        c.setCustomerName(customername);
        System.out.println("Enter age: ");
        int customerage = sc.nextInt();
        if (customerage < 18) {
            do {
                System.out.print("Minimum age should be 18..please provide valid age..");
                customerage = sc.nextInt();
            } while (customerage < 18);
        }
        c.setCustomerAge(customerage);
        a.setCustomerObject(c);
        System.out.println("Enter account ID:");
        int accountid = sc.nextInt();
        a.setAccountId(accountid);
        System.out.println("Enter account type: ");
        String accounttype = sc.next();
        a.SetAccountType(accounttype);
        System.out.println("Enter Balance: ");
        double balance = sc.nextDouble();
        a.setBalance(balance);
        System.out.println("Enter Minimum Balance: ");
        double minibalance = sc.nextDouble();
        a.setMinimumBalance(minibalance);
        return a;
    }

    void getWithdrawAount() {
        System.out.println("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > 20000) {
            System.out.println("Withdrawal failed.. maiximum limit is a 20,000");

        } else {
            if (a.withdraw(amount) == true) {
                System.out.println("Withdraw Successfull. Balance is:" + a.getBalance());

            } else {
                System.out.print("Sorry..Insufficent Balance..");
            }
        }

    }

    public void depositAmount(double amount) {
        double bal = a.getBalance() + amount;
        a.setBalance(bal);
        System.out.println("Amount deposited successfully. Balance is : " + a.getBalance());

    }

    public void checkBalance() {
        System.out.println("Balance is: " + a.getBalance());
    }

    public void displayAccountInformation() {
        System.out.println("Welcome " + c.getCustomerName() + " Follwing are your details..\n");
        System.out.println("Age: " + c.getCustomerAge());
        System.out.println("Account Id: " + a.getAccountId());
        System.out.println("Account Type: " + a.getAccountType());
        System.out.println("Balance : " + a.getBalance());
        System.out.println("Minimum balance: " + a.getMinimumBalance());
    }

}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingAccount a;
        Bank bm = new Bank();
        do {
            System.out.print(
                    "1.Create Account\n2.Display Account\n3.Withdraw Money\n4.Deposite Money\n5.Check Balance\n6.EXit\n");
            System.out.println("Choose: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    a = bm.createAccount();
                    break;
                case 2:
                    bm.displayAccountInformation();
                    break;
                case 3:
                    bm.getWithdrawAount();
                    break;
                case 4:
                    System.out.println("Enter The Amount you want to Deposite: ");
                    int amount = sc.nextInt();
                    bm.depositAmount(amount);
                    break;
                case 5:
                    bm.checkBalance();
                    break;
                case 6:
                    System.out.println("THANK YOU FOR SHOW INTEREST..");
                    return;
                default:
                    System.out.println("Invalid Choice..");
                    break;
            }
        } while (true);
    }
}