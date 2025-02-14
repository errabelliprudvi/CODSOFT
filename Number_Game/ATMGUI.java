import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Bank Account class to manage balance
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

// ATM GUI Class
public class ATMGUI {
    private BankAccount account;
    private JFrame frame;
    private JLabel balanceLabel;
    private JTextField amountField;

    public ATMGUI(BankAccount account) {
        this.account = account;
        createUI();
    }

    private void createUI() {
        // Create frame
        frame = new JFrame("ATM Interface");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        // Display balance
        balanceLabel = new JLabel("Balance: $" + account.getBalance(), SwingConstants.CENTER);
        frame.add(balanceLabel);

        // Input field for amount
        amountField = new JTextField();
        frame.add(amountField);

        // Withdraw button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.withdraw(amount);
                    updateBalance();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
                }
            }
        });
        frame.add(withdrawButton);

        // Deposit button
        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.deposit(amount);
                    updateBalance();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
                }
            }
        });
        frame.add(depositButton);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        frame.add(exitButton);

        // Set frame visible
        frame.setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        // Start ATM with initial balance
        new ATMGUI(new BankAccount(500.0));
    }
}
