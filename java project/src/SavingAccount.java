public class SavingAccount extends Account {
	private int contractPeriod;
	private double interest;
	private int aTime;
	private double value;

	SavingAccount(double balance, double interest) {
		super(balance);
		this.interest = interest;
		aTime = 0;
		contractPeriod = 12;
		this.value = balance;

	}

	@Override
	public void debit(double sub) throws Exception {
		if (sub < 0) {
			throw new Exception("음수입력");
		} else {
			if (contractPeriod <= aTime) {
				if (balance < sub) {
					throw new Exception("출금불가");
				} else {

					balance -= sub;
					
				}
			} else {
				throw new Exception("아직 출금할수 없습니다.");
			}
		}
	}

	@Override
	public double getWithdrawableAccount() {

		return (contractPeriod <= aTime) ? balance : 0;
	}

	@Override
	public void passTime(int time) {

		if ((aTime < contractPeriod) && (aTime + time) >= contractPeriod) {
			balance *= Math.pow(1 + interest, contractPeriod);
		}
		aTime += time;

	}
	@Override
	public void passTime() {

		if ((aTime < contractPeriod) && (aTime + 1) >= contractPeriod) {
			balance *= Math.pow(1 + interest, contractPeriod);
		}
		aTime += 1;

	}

	@Override
	public double estimateValue(int month) {

		value *= Math.pow(1 + interest, month);

		return value;
	}
	@Override
	public double estimateValue(){
		value *= Math.pow(1 + interest, 1);

		return value;
	}
	

	public String toString() {
		return String.format("SavingAccount_Balance : %.2f", balance);
	}
}