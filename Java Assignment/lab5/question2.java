import java.util.Scanner;

abstract class Account {
    int accountNumber;
    double balance;

    Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract void calculateInterest();
}

class SavingsAccount extends Account {
    double interestRate = 0.04;

    SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Savings Account " + accountNumber + " Interest: " + interest);
    }
}

class CurrentAccount extends Account {
    double interestRate = 0.02;

    CurrentAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Current Account " + accountNumber + " Interest: " + interest);
    }
}

public class question2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account[] accounts = new Account[2];

        System.out.print("Enter Savings Account Number: ");
        int sAccNo = sc.nextInt();
        System.out.print("Enter Savings Account Balance: ");
        double sBal = sc.nextDouble();
        accounts[0] = new SavingsAccount(sAccNo, sBal);

        System.out.print("Enter Current Account Number: ");
        int cAccNo = sc.nextInt();
        System.out.print("Enter Current Account Balance: ");
        double cBal = sc.nextDouble();
        accounts[1] = new CurrentAccount(cAccNo, cBal);

        System.out.println("\n--- Interest Calculation ---");
        for (Account acc : accounts) {
            acc.calculateInterest();
        }

        sc.close();
    }
}
