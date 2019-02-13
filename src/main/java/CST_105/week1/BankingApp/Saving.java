package CST_105.week1.BankingApp;

public class Saving extends Account {
	
	//declaring variables
	private double serviceFee = 25.00;
	private double annualInterestRate = .06;
	private double minBalance = 200.00;
	
	
	//Getter and Setter Methods
	public double getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	//Saving Method??
	public Saving(double balance, String account) {	
		this.setAccountBalance(balance);
		this.setAccountNumber(account);
	}

}
