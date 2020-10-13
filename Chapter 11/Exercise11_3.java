/* Author: Isaac Bezzant
   Date: 10/9/2020 
*/
import java.util.Date;
public class Exercise11_3 {
  public static void main(String[] args) {
    SavingsAccount savings = new SavingsAccount(1, 100);
    CheckingAccount checking = new CheckingAccount(2, 100);
    Account account = new Account(3, 100);
    System.out.println(savings.toString());
    System.out.println(checking.toString());
    System.out.println(account.toString());
  }
}
class SavingsAccount extends Account {
  SavingsAccount() {  
    this.setAnnualInterestRate(2);
  }
  SavingsAccount(int id, double balance) {
    super(id, balance);
    this.setAnnualInterestRate(2);
  } 
  String getPolicy() {
    return "Savings Account Policy: " + "\n Overdraft: Savings accounts can not be overdrawn" + String.format("\n Annual Interest Rate: %.2f",(this.getAnnualInterestRate() * 100)) + String.format("\n Monthly Interest Rate: %.4f", this.getMonthlyInterestRate());
  }
  void withdraw(double withdrawl) {
    if(this.getBalance() - withdrawl >= 0) {
      this.setBalance(this.getBalance() - withdrawl);
    }
    else {
      System.out.println("Savings accounts cannot be withdrawn...");
    }
  }
  public String toString() {
    return "Account ID: " + this.getId() + "\n Account Balance: " + this.getBalance() + "\n Annual Interest: " + this.getAnnualInterestRate() + String.format("\n Monthly Interest: %.4f", this.getMonthlyInterestRate()) + "\n Account Type: Savings Account" + "\n Overdraft allowed: false";
  }
}
class CheckingAccount extends Account {
  CheckingAccount() {
    this.setAnnualInterestRate(2);
  }
  CheckingAccount(int id, double balance) {
    super(id, balance);
    this.setAnnualInterestRate(2);
  }
  String getPolicy() {
    return "Checking Account Policy: " + "\n Overdraft: Overdraft limit for a checking account is $500" + String.format("\n Annual Interest Rate: %2.f",(this.getAnnualInterestRate() * 100)) + String.format("\n Montly Interest Rate: %.4f", this.getMonthlyInterestRate());
  }
  double getLimit() {
    return 500;
  }
  void withdraw(double withdrawl) {
    if(this.getBalance() - withdrawl >= -500) {
      this.setBalance(this.getBalance() - withdrawl);
    }
    else {
      System.out.println("Checking accounts cannot be overdrawn more than $500...");
    }
  }
  public String toString() {
    return "Account ID: " + this.getId() + "\n Account Balance: " + this.getBalance() + "\n Annual Interest: " + this.getAnnualInterestRate() + String.format("\n Monthly Interest: %.4f", this.getMonthlyInterestRate()) + "\n Account Type: Checking Account" + "\n Overdraft allowed: true";
  }
}
class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
  private double monthlyInterestRate = 0;
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
  public String toString() {
    return "Account ID: " + this.getId() + "\n Account Balance: " + this.getBalance() + "\n Annual Interest: " + this.getAnnualInterestRate() + "\n Monthly Interest: " + this.getMonthlyInterestRate();
  }
}