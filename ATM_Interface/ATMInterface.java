
public class ATMInterface {
    public static void main(String[] args) {
      
        BankAccount userAccount = new BankAccount(500.0);
        
        
        ATM atm = new ATM(userAccount);
        
      
        atm.displayMenu();
    }
}
