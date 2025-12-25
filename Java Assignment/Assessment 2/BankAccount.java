import java.util.Scanner;

class BankAccount {
int accountNumber;
String holderName;
double balance;

BankAccount(int accountNumber, String holderName, double balance) {
    this.accountNumber = accountNumber;
    this.holderName = holderName;
    this.balance = balance;
}

void deposit(double amount) {
    balance += amount;
    System.out.println("Deposited: " + amount);
}

void display() {
    System.out.println("\n--- Account Details ---");
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Holder Name: " + holderName);
    System.out.println("Balance: " + balance);
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Account Number: ");
    int accNo = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Account Holder Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Initial Balance: ");
    double bal = sc.nextDouble();

    BankAccount account = new BankAccount(accNo, name, bal);

    System.out.print("Enter amount to deposit: ");
    double amount = sc.nextDouble();

    account.deposit(amount);
    account.display();

    sc.close();
}

}
