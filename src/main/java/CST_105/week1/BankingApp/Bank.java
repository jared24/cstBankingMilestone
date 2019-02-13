package CST_105.week1.BankingApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bank  {
	
	private  String name;
	Scanner sc = new Scanner(System.in);
	static Bank bank = new Bank ("GCU Credit Union");
	Customer fullName = new Customer ();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();  


	public static void main(String[] args) {
		//creating objects
		//syntax object class name.variable ();
		Saving saving = new Saving (5000.00, "191923");
		Checking checking = new Checking (5000.00, "991773");
		bank.displayMenu (checking, saving);
	}
	//constructor
	Bank(String name){
		this.name = name;	
	}
	
	private void displayMenu(Checking checking, Saving saving) {
		int option;
		do {
			System.out.println("====================================");
			System.out.println("              MAIN MENU");
			System.out.println("              "+ this.name.toUpperCase());
			 System.out.println("              "+  fullName.getFullName());
			System.out.println("====================================");
			System.out.println("Pick an option: ");
			System.out.println("---------------------");
			System.out.println(" 1:  :Deposit to Checking");
			System.out.println(" 2:  :Deposit to Savings");
			System.out.println(" 3:  :Withdrawl from Checking");
			System.out.println(" 4:  :Withdrawl from Savings");
			System.out.println(" 5:  :Get Balance");
			System.out.println(" 6:  :Close Month");
			System.out.println(" --------------------");
			System.out.println(" 9:  :Exit");
			option = sc.nextInt();
			this.actionMenu(option, checking, saving);
			}while (option !=9);		
	}
	
	private void actionMenu(int option, Checking checking, Saving saving){
		//System.out.println("actionMenu");
		
		switch (option) {
		case 1:
			bank.displayDepositChecking(checking);break;
		
		case 2:
			bank.displayDepositSaving(saving); break;
		
		case 3:
			bank.displayWithdrawlChecking(checking,saving); break;
		
		case 4:
			bank.displayWithdrawlSavings(saving); break;
		
		case 5:
			bank.displayBalanceScreen(checking, saving); break;
		
		case 6:
			bank.doEndMonth(checking, saving); break;
		
		case 9:
			bank.displayExitScreen(); break;
		
		case 7:
		case 8:
			System.out.println("You have entered an invalid option. Please try again."); 
			break;
		
	}
	}
	private void doEndMonth(Checking checking, Saving saving) { 
		double amount = (saving.getAccountBalance() * saving.getAnnualInterestRate() / 12);
		saving.setAccountBalance(saving.getAccountBalance() + amount);
		
		
		if (saving.getAccountBalance() >= saving.getMinBalance())  { 
			System.out.println("Your end of month interest is $" + amount + ".");
			
		}
		else {
			saving.setAccountBalance(saving.getAccountBalance() - saving.getServiceFee());
			System.out.println("Account" + "(" + saving.getAccountNumber() + ")" + "end of month balance fell below " + "$" + saving.getMinBalance() + ".");
			System.out.println(" A $25 fee has been charged to your account.");
			
		}
		System.out.println("End of Month Savings Balance: $" + saving.getAccountBalance() + " as of " + dtf.format(now) + ".");
		System.out.println("End of Month Checking Account Balance is: $" +  checking.getAccountBalance() + " as of " + dtf.format(now) + ".");
		
}
	private void displayExitScreen() {
		
		System.out.println("Have a great day!");
	
	}
	private void displayBalanceScreen(Checking checking, Saving saving) {
		System.out.println("Checking Account ending in" + " ("+  checking.getAccountNumber()  +")" +  " balance is $" +  checking.getAccountBalance()  + " as of " + dtf.format(now) + "!");
		System.out.println("Your Saving Account ending in" + " ("+  saving.getAccountNumber() + ")" + " balance is $" +  saving.getAccountBalance() + " as of " + dtf.format(now) + "!");
		
	}
	private void displayWithdrawlSavings(Saving saving) {
		//**need to 
		
		System.out.println("WITHDRAW FROM SAVINGS" + "(" + saving.getAccountNumber() + ")");
		System.out.println("Your savings balance is: $" + saving.getAccountBalance() + "!");
		System.out.println("====================================");
		System.out.println("Enter withdrawl amount: $");
		double amount = sc.nextDouble();
		saving.setAccountBalance(saving.getAccountBalance() - amount);
		if (saving.getAccountBalance() >= saving.getMinBalance()) {
			System.out.println("Account" + " (" + saving.getAccountNumber() + ")");
			System.out.println("Your Balance:$ " + saving.getAccountBalance() + " as of " + dtf.format(now) + "!");
			}
		
			else {
				System.out.println("Account" + " (" + saving.getAccountNumber() + ")");
				System.out.println("Your Balance: $" + saving.getAccountBalance() + " is below the allowable limit" + " as of " + dtf.format(now) + "."); 
				System.out.println("Balance has fallen below " + "$" + saving.getMinBalance() + ". Please make a deposit before the end of month to avoid a " + saving.getServiceFee() + " fee."); 
				System.out.println("A " + "$" + saving.getServiceFee() + " fee can be been charged to your account.");
			}		
	
	}
	private void displayWithdrawlChecking(Checking checking, Saving saving) {
		System.out.println("WITHDRAW FROM CHECKING" + " (" + checking.getAccountNumber() + ")");
		System.out.println("Your checking balance is $" + checking.getAccountBalance() + "!"); 
		System.out.println("====================================");
		System.out.println("Enter withdraw amount: ");
		double amount = sc.nextDouble();
		checking.setAccountBalance(checking.getAccountBalance() - amount);
		
		if (checking.getAccountBalance() >saving.getMinBalance()) {
			System.out.println("Account" + " (" + checking.getAccountNumber() + ")");
			System.out.println("New Balance: $" + checking.getAccountBalance());
		}
		
		else if (checking.getAccountBalance() >= 1) {
			System.out.println("Account" + " (" + checking.getAccountNumber() + ")");
			System.out.println("New Balance: $" + checking.getAccountBalance() + " as of " + dtf.format(now) + ".");
			System.out.println("Account is at or under $" + saving.getMinBalance() + ".");
			System.out.println("An overdraft fee of $" + checking.getOverDraft() + " will be applied for every deposit made once account falls below $1.");
			System.out.println("To avoid an overdraft fee please make a deposit.");
		}
	
		else {checking.setAccountBalance(checking.getAccountBalance() - checking.getOverDraft());
			System.out.println("Account" + " (" + checking.getAccountNumber() + ")");
			System.out.println("New Balance: $" + checking.getAccountBalance() + " as of " + dtf.format(now) + ".");
			System.out.println("An overdraft fee of " +  "$" + checking.getOverDraft() + " has be applied to your account.");	
		}		
	}
	private void displayDepositSaving(Saving saving) {
		
		System.out.println("DEPOSIT TO SAVINGS" + " (" + saving.getAccountNumber() + ")");
		System.out.println("Your savings balance is: $" + saving.getAccountBalance() + "!");
		System.out.println("Enter deposit amount: $");
		System.out.println("====================================");
		double amount = sc.nextDouble();
		saving.setAccountBalance(saving.getAccountBalance() + amount);
		System.out.println("New Balance: $" + saving.getAccountBalance() + " as of " + dtf.format(now) + "!");
		
	}
	private void displayDepositChecking(Checking checking) {
		
		System.out.println("DEPOSIT TO CHECKING" + " (" + checking.getAccountNumber() + ")");
		System.out.println("Your savings balance is: $" + checking.getAccountBalance() + "!");
		System.out.println("Enter deposit amount: $");
		System.out.println("====================================");
		double amount = sc.nextDouble();
		checking.setAccountBalance(checking.getAccountBalance() + amount);
		System.out.println("New Balance: $" + checking.getAccountBalance() + " as of " + dtf.format(now) + "!");
	}
	
}

