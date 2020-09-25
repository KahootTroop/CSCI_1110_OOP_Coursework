import java.util.Scanner;
import java.util.Date;
import java.util.*;
/* Author: Isaac Bezzant
   Date: 9/25/2020
	The purpose of the program is to demonstrate the use of the created Account class.
	This is shown with a simple banking program designed after an atm.
*/
class Exercise10_7 {
	public static void main(String[] args) {
		Account[] accountArray = new Account[10];
		Scanner input = new Scanner(System.in);
		int flag = 1;
		int flag1 = 1;
		int id = 0;
		int choice = 0;
		Double withdrawl = 0.0;
		Double deposit = 0.0;
		for(int i = 0; i < accountArray.length; i++) {
			accountArray[i] = new Account(i + 1, 100);
		}
		while(flag == 1) {
			flag1 = 1;
			while(flag1 == 1) {
				System.out.print("Enter an account id: ");
				try {
					id = input.nextInt();
					flag1 = 0;
				}
				catch(InputMismatchException ex) {
					System.out.println("Incorrect id, please remember that an id may only consist of numbers...");
					input.next();
					flag1 = 1;
				}
			}
			for(int i = 0; i < accountArray.length; i++) {
				if(id == accountArray[i].getId()) {
					flag = 0;
				}
			}
			if(id == 10) {
				flag = 1;
			}
			if(flag != 0) {
				System.out.println("Please enter a valid id...");
			}
		}
		flag = 1;
		while(flag == 1) {
			flag1 = 1;
			while(flag1 == 1) {
				System.out.println();
				System.out.println();
				System.out.println("Main menu");
				System.out.println("1: check balance");
				System.out.println("2: withdraw");
				System.out.println("3: deposit");
				System.out.println("4: exit");
				System.out.print("Enter a choice: ");
				try {
					choice = input.nextInt();
				}	
				catch(InputMismatchException ex) {
					System.out.println("Please enter a correct choice...");
					System.out.println();
					input.next();
				}
				for(int i = 1; i < 5; i++) {
					if(choice == i) {
						flag1 = 0;
					}
				}
				if(flag1 != 0) {
					System.out.println("Please enter a number that matches a given choice...");
					System.out.println();
				}
			}
			if(choice == 1) {
				System.out.println("The balance is " + accountArray[id].getBalance());
				System.out.println();
			}
			if(choice == 2) {
				flag1 = 1;
				while(flag1 == 1) {
					System.out.print("Enter an amount to withdraw: ");
					try {
						withdrawl = input.nextDouble();
						flag1 = 0;
						System.out.println();
					}
					catch(InputMismatchException ex ) {
						System.out.println("Incorrect amount given...");
						System.out.println();
					}
				}
				accountArray[id].withdraw(withdrawl);
			}
			if(choice == 3) {
				flag1 = 1;
				while(flag1 == 1) {
					System.out.print("Enter an amount to deposit: ");
					try {
						deposit = input.nextDouble();
						flag1 = 0;
						System.out.println();
					}
					catch(InputMismatchException ex) {
						System.out.println("Incorrect amount given...");
						System.out.println();
					}
				} 
				accountArray[id].deposit(deposit);
			}
			if(choice == 4) {
				System.out.println();
				System.out.println();
				main(args);
			}
		}
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