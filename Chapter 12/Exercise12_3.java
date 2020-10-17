import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
class Exercise12_3 {
  public static void main(String[] args) {
    int[] randomArray = new int[100];
    Random rando = new Random();
    Scanner input = new Scanner(System.in);
    int choice = 0;
    boolean test;
    for(int i = 0; i < randomArray.length; i++) {
      randomArray[i] = rando.nextInt(500);
    }
    while(true) {
      System.out.print("Enter an index from 0 to 99 to check its value: ");
      try {
        choice = input.nextInt();
        test = true;
      }
      catch(InputMismatchException ex) {
        System.out.println("Please only enter Integers...");
        test = false;
        String temp = input.next().toString();
      }
      if(test == true) {
        if(choice >= 0 && choice <= 99) {
          System.out.println("The value at index " + choice + " is " + randomArray[choice]);
        }
        else {
          System.out.println("Out Of Bounds");
        }
      }
    }
  }
}