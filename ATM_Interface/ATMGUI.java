import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        
        frame = new JFrame("ATM Interface");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

       
        balanceLabel = new JLabel("Balance: $" + account.getBalance(), SwingConstants.CENTER);
        frame.add(balanceLabel);

       
        amountField = new JTextField();
        frame.add(amountField);

     
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

       
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        frame.add(exitButton);

       
        frame.setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: $" + account.getBalance());
    }

   
}
