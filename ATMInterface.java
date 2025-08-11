import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn ₹" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
        return false;
    }
}

// Class to represent the ATM Machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000); // Initial balance ₹5000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
