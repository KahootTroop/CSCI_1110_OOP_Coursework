/* Author: Isaac Bezzant
   Date: 9/17/2020
   Simple program that checks if a number is odd,        even, or prime. It also parses an user given list      of numbers to an Int.
*/
import java.util.Scanner;
class Exercise10_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an Integer: ");
		MyInteger myInteger = new MyInteger(input.nextInt());
		System.out.println("Entered Integer: " + myInteger.getValue());
		System.out.println("Entered Integer is even: " + myInteger.isEven());
		System.out.println("Entered Integer is odd: " + myInteger.isOdd());
		System.out.println("Entered Integer is prime: " + myInteger.isPrime());
		System.out.print("Enter an Integer to check if it is even: ");
		System.out.println("Entered Integer is even: " + MyInteger.isEven(input.nextInt()));
		System.out.print("Enter an Integer to check if it is odd: ");
		System.out.println("Entered Integer is odd: " + MyInteger.isOdd(input.nextInt()));
		System.out.print("Enter an Integer to check if it is prime: ");
		System.out.println("Entered Integer is prime: " + MyInteger.isPrime(input.nextInt()));
		System.out.print("Enter an Integer: ");
		int value = input.nextInt();
		System.out.println("Entered Integer is even: " + MyInteger.isEven(value));
		System.out.println("Entered Integer is odd: " + MyInteger.isOdd(value));
		System.out.println("Entered Integer is prime: " + MyInteger.isPrime(value));
		System.out.print("Enter an Integer to check if it is equal to the first Integer entered: ");
		System.out.println("Entered Integer is equal: " + myInteger.equals(input.nextInt()));
		System.out.print("Enter an Integer to check if it is equal to the first Integer entered: ");
		System.out.println("Entered Integer is equal: " + myInteger.equals(input.nextInt()));
		String temp = input.nextLine();
		System.out.print("Enter a list of numbers to be parsed into an int: ");
		System.out.println("Parsed list: " + MyInteger.parseInt(input.nextLine().toCharArray()));
		System.out.print("Enter a list of numbers to be parsed into an int: ");
		System.out.println("Parsed list: " + MyInteger.parseInt(input.nextLine()));
	}
}
class MyInteger {
	int value;
	MyInteger(int newValue) {
		value = newValue;
	}
	int getValue() {
		return value;
	}
	boolean isEven() {
		if(value % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	boolean isOdd() {
		if(value % 2 == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	boolean isPrime() {
		int check = 0;
		if(value == 0 || value == 1) {
			return false;
		}
		else {
			for(int i = 2; i < value; i++) {
				if(value % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
	static boolean isEven(int newValue) {
		if(newValue % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	static boolean isOdd(int newValue) {
		if(newValue % 2 == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	static boolean isPrime(int newValue) {
		int check = 0;
		if(newValue == 0 || newValue == 1) {
			return false;
		}
		else {
			for(int i = 2; i < newValue; i++) {
				if(newValue % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
	static boolean isEven(MyInteger a) {
		if(a.value % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	static boolean isOdd(MyInteger a) {
		if(a.value % 2 == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	static boolean isPrime(MyInteger a) {
		int check = 0;
		if(a.value == 0 || a.value == 1) {
			return false;
		}
		for(int i = 2; i < a.value; i++) {
			if(a.value % i == 0) {
				return false;
			}
		}
		return true;
	}
	boolean equals(int newValue) {
		return newValue == value;
	}
	boolean equals(MyInteger a) {
		return a.value == value;
	}
	static int parseInt(char[] newCharArray) {
		int temp1 = 1;
		Scanner input = new Scanner(System.in);
		try {
			String temp = new String(newCharArray);
			temp = temp.replaceAll(" ", "");
			return Integer.parseInt(temp);
		}
		catch(NumberFormatException ex) {
			System.out.println("Please Enter each number seperated by a space");
			System.out.print("Enter a list of numbers to be parsed into an int: ");
			temp1 = MyInteger.parseInt(input.nextLine().toCharArray());
		}
		return temp1;
	}
	static int parseInt(String newString) {
		Scanner input = new Scanner(System.in);
		int temp1 = 1;
		try {
			newString = newString.replaceAll(" ", "");
			return Integer.parseInt(newString);
		}
		catch(NumberFormatException ex) {
			System.out.println(" Please Enter each number seperated by a space");
			System.out.print("Enter a list of numbers to be parsed into an int: ");
			temp1 = MyInteger.parseInt(input.nextLine());
		}
		return temp1;
	}

}