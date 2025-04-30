import java.util.HashMap;
import java.util.Scanner;

class Account {
    private int pin;
    private double balance;

    public Account(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void changePin(int newPin) {
        this.pin = newPin;
        System.out.println("PIN changed successfully.");
    }
}

public class ATM {
    private static HashMap<Integer, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample user data: Card number -> Account
        accounts.put(123456, new Account(1234, 5000.0));
        accounts.put(654321, new Account(4321, 10000.0));

        System.out.println("Welcome to the ATM!");

        System.out.print("Enter your card number: ");
        int cardNumber = scanner.nextInt();

        if (!accounts.containsKey(cardNumber)) {
            System.out.println("Invalid card number.");
            return;
        }

        Account userAccount = accounts.get(cardNumber);

        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        if (!userAccount.validatePin(pin)) {
            System.out.println("Incorrect PIN.");
            return;
        }

        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    userAccount.changePin(newPin);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);
    }
}

