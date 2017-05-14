import java.util.InputMismatchException;

public class CheckingAccount extends Account{
	private double creditLimit;
	private double interest;
	private double loanInterest;
	
	
	public CheckingAccount(double balance,double creditLimit,double interest,double loanInterest ) {
		super(balance);
		this.creditLimit = creditLimit;
		this.interest = interest;
		this.loanInterest = loanInterest;
		
	}
	
	@Override
	public void debit(double sub) throws Exception ,InputMismatchException {
		if (sub < 0) {
			throw new Exception("음수입력");
		} else {
			if (balance + creditLimit > sub) {

				super.debit(sub);

			}else{
			
				throw new InputMismatchException("");
			}
		}
	}
	@Override
	public double getWithdrawableAccount(){
		return (balance+creditLimit>0)? balance+creditLimit : 0;
	}
	@Override
	public void passTime(int time){
		if(balance>0){
			balance*=Math.pow(1+interest, time);
		}else{
			balance*=Math.pow(1+ loanInterest, time);
		}
	}
	
	@Override
	public void passTime(){
		if(balance>0){
			balance*=Math.pow(1+interest, 1);
		}else{
			balance*=Math.pow(1+ loanInterest, 1);
		}
	}
	
	public boolean isBankrupted(){
		return balance+creditLimit<0;
	}

	@Override
	public double estimateValue(int month) {
		if(balance>0){
			balance*=Math.pow(1+interest, month);
			
		}else{
			balance*=Math.pow(1+ loanInterest, month);
		}return balance;
	}
	@Override
	public double estimateValue(){
		if(balance>0){
			balance*=Math.pow(1+interest, 1);
			
		}else{
			balance*=Math.pow(1+ loanInterest, 1);
		}return balance;
	}
	
	public String toString(){
		return String.format("CheckingAccount_Balance : %.2f", balance);
	}

}
//