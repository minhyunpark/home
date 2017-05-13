
import java.util.ArrayList;

public abstract class Account implements Valuable {
	
	protected double balance;
	
	
	public Account(double balance){
	this.balance= balance;	
	}
	
	public double getBalance(){
		return balance;
	}
	
	
	public void debit(double sub) throws Exception{
		balance -= sub;
			}
	public void credit(double add){
		balance += add;
	}

	
	public abstract double getWithdrawableAccount();
	public abstract void passTime(int month);
	public abstract void passTime();
	
	public static double sumForAccount(ArrayList<? extends Account> list){
		double sum = 0;
		for(Account account : list){
			sum += account.getBalance();
		}
		return sum;
		}
	
	public static void passTimeForList(ArrayList<? extends Account> list,int month ){
		for(Account account : list){
			account.passTime(month);
		}
	}
}