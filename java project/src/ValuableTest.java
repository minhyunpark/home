import java.util.ArrayList;


public class ValuableTest {
	public static void main(String args[]) {
		
		Account account1 = new CheckingAccount(100,50,0.01,0.07);
		Account account2 = new SavingAccount(100,0.05);
		
		ArrayList<Account> accountList = new ArrayList<Account>();
		
		accountList.add(account1);
		accountList.add(account2);
	}
}//