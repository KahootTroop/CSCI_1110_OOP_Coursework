/* Author: Isaac Bezant
   Date: 9/4/2020
  Simple program to display Account balance, interest, and date created after deposits and withdrawls
*/
import java.util.Date;
class Exercise09_7 {
	public static void main(String[] args) {
		Account account1 = new Account(1122, 20000);
		account1.setAnnualInterestRate(4.5);
		account1.withdraw(2500);
		account1.deposit(3000);
		System.out.println("Account Balance: " + account1.getBalance());
		System.out.println("Monthly Interest: " + account1.getMonthlyInterest());
		System.out.println("Account Date Created: " + account1.getDateCreated());
	}
}
class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new Date();
	Account() {
		
	}
	Account(int newId, double newBalance) {
		id = newId;
		balance = newBalance;
	}
	void setId(int newId) {
		id = newId;
	}
	void setBalance(double newBalance) {
		balance = newBalance;
	}
	void setAnnualInterestRate(double newAnnualInterestRate) {
		annualInterestRate = newAnnualInterestRate / 100;
	}
	int getId() {
		return id;
	}
	double getBalance() {
		return balance;
	}
	double getAnnualInterestRate() {
		return annualInterestRate;
	}
	Date getDateCreated() {
		return dateCreated;
	}
	double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}
	double getMonthlyInterest() {
		return balance * (annualInterestRate / 12);
	}
	void withdraw(double newWithdraw) {
		balance = balance - newWithdraw;
	}
	void deposit(double newDeposit) {
		balance = balance + newDeposit;
	}
}