import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Arrays;
class Exercise12_15 {
  public static void main(String[] args) throws FileNotFoundException, InputMismatchException {
    PrintWriter output = new PrintWriter("Exercise12_15.txt");
    File file = new File("Exercise12_15.txt");
    Scanner input = new Scanner(file);
    Random rando = new Random();
    int[] numbers = new int[100];
    int j = 0;
    for(int i = 0; i <= 99; i++) {
      output.print(rando.nextInt(200) + " ");
    }
    output.close();
    while(input.hasNextInt()) {
      numbers[j++] = input.nextInt();
    }
    input.close();
    Arrays.sort(numbers);
    for(int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");
    }
  }
}