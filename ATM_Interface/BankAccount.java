import javax.swing.*;


public class BankAccount {
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
            JOptionPane.showMessageDialog(null, "Deposit successful! New balance: $" + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount! Enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawal successful! New balance: $" + balance);
        } else if (amount > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient balance! Your current balance is $" + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount! Enter a positive value.");
        }
    }
}
