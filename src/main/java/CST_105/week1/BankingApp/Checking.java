package CST_105.week1.BankingApp;

public class  Checking extends Account  {
	
	//delcaring variable
	private double overDraft = 45.00;

	//creating getter and setter methods
	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}
	//Checking Method???
	public Checking(double balance, String account) {
		this.setAccountBalance(balance);
		this.setAccountNumber(account);
	}
	//doWithdraw method
		public void doWithdraw(double amount) {	
		
		}
}
