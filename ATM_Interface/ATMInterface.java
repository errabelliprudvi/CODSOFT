
public class ATMInterface {
    public static void main(String[] args) {
      
        BankAccount userAccount = new BankAccount(500.0);

        ATMGUI atm = new ATMGUI(userAccount);
        
     
    }
}
