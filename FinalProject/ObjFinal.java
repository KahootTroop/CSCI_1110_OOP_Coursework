import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
public class ObjFinal {
    public static void main(String[] args) throws FileNotFoundException, InputMismatchException, IOException {
        Scanner user = new Scanner(System.in);
        // add /Users/student/Desktop/ on front of path for stech mac
        File save = new File("/Users/student/Desktop/save.txt");
        int idCount = 0;
        if(save.exists()) {
            System.out.println("Save found!");
            Scanner idCheck = new Scanner(save);
            while(idCheck.hasNextLine()) {
                idCount++;
                idCheck.nextLine();
            }
        }
        else {
            save.createNewFile();
        }
        Scanner file = new Scanner(save);
        PrintWriter out = new PrintWriter(new FileWriter(save, true));
        Mammal[] mList = new Mammal[10];
        String[] strList = new String[10];
        Reptile[] rList = new Reptile[10];
        String color;
        String name;
        String size;
        String trashcan;
        double lifeSpan;
        int legs;
        int arms;
        boolean hasTail;
        String hairOrFur;
        int id = idCount + 1;
        String str;
        String userType = "mammal";
        while(1 != 0) {
            System.out.println("Would you like to enter a new animal? ");
            str = user.next();
            if(str.equalsIgnoreCase("yes")) {
                int pas = 0;
                while(pas != 1) {
                    System.out.println("Which of the following is the animal: A Mammal, Reptile, Fish, Bird, or Amphibian");
                    try {
                        userType = user.next();
                        pas = 1;
                    }
                    catch(InputMismatchException ex) {
                        System.out.println("Please only enter a String for the following...");
                    }
                }
                if(userType.equalsIgnoreCase("mammal")) {
                    System.out.println("What is the name of the animal? ");
                    name = user.next();
                    System.out.println("What color is the animal? ");
                    color = user.next();
                    System.out.println("What size is the animal? (Small, Medium, or Large)" );
                    size = user.next();
                    System.out.println("What is the animal's lifespan in years? ");
                    lifeSpan = user.nextDouble();
                    System.out.println("How many legs does the animal have? ");
                    legs = user.nextInt();
                    System.out.println("How many arms does the animal have? ");
                    arms = user.nextInt();
                    System.out.println("Does the animal have a tail?");
                    if(user.next().equalsIgnoreCase("yes")) {
                        hasTail = true;
                    }
                    else {
                        hasTail = false;
                    }
                    System.out.println("Does the animal have hair or fur? ");
                    if(user.next().equalsIgnoreCase("hair")) {
                        hairOrFur = "hair";
                    }
                    else {
                        hairOrFur = "fur";
                    }
                    mList[id] = new Mammal(name, color, size, lifeSpan, hairOrFur, legs, arms, hasTail, id);
                    out.append(mList[id].toString() + "\n");
                    out.flush();
                    id++;
                }
                else if(userType.equalsIgnoreCase("reptile")) {
                    System.out.println("What is the name of the animal? ");
                    name = user.next();
                    System.out.println("What color is the animal? ");
                    color = user.next();
                    System.out.println("What size is the animal? (Small, Medium, or Large)" );
                    size = user.next();
                    System.out.println("What is the animal's lifespan in years? ");
                    lifeSpan = user.nextDouble();
                    System.out.println("How many legs does the animal have? ");
                    legs = user.nextInt();
                    System.out.println("How many arms does the animal have? ");
                    arms = user.nextInt();
                    System.out.println("Does the animal have a tail?");
                    if(user.next().equalsIgnoreCase("yes")) {
                        hasTail = true;
                    }
                    else {
                        hasTail = false;
                    }
                    rList[id] = new Reptile(name, color, size, lifeSpan, legs, arms, hasTail, id);
                    out.append(rList[id].toString() + "\n");
                    out.flush();
                    id++;
                }
                else if(userType.equalsIgnoreCase("fish")) {
                    System.out.println("What is the name of the animal? ");
                    name = user.next();
                    System.out.println("What color is the animal? ");
                    color = user.next();
                    System.out.println("What size is the animal? (Small, Medium, or Large)" );
                    size = user.next();
                    System.out.println("What is the animal's lifespan in years? ");
                    lifeSpan = user.nextDouble();
                    System.out.println("What is the size of the aniaml's tail in inches: ");
                    int tailSize = user.nextInt();
                    System.out.println("How many fins does the animal have? ");
                    int fins = user.nextInt();
                    System.out.println("Is the animal a pet?");
                    boolean isPet = true;
                    if(user.next().equalsIgnoreCase("yes")) {
                        isPet = true;
                    }
                    else {
                        isPet = false;
                    }
                    rList[id] = new Reptile(name, color, size, lifeSpan, legs, arms, hasTail, id);
                    out.append(rList[id].toString() + "\n");
                    out.flush();
                    id++;
                }
            }
            else if(str.equalsIgnoreCase("no")) {
                System.out.println("End Program? ");
                if(user.next().equalsIgnoreCase("yes")) {
                    out.close();
                    System.exit(0);
                }
            }
            System.out.println("Would you like to view a previous entry? ");
            if(user.next().equalsIgnoreCase("yes")) {
                Scanner file1 = new Scanner(save);
                while(file1.hasNextLine()) {
                    try {
                        System.out.print(file1.nextInt() + " ");
                    }
                    catch(InputMismatchException ex) {
                        System.out.println("Error!");
                    }
                    try {
                        System.out.print(file1.next());
                        System.out.println();
                    }
                    catch(InputMismatchException ex) {
                        System.out.println("Error!");
                    }
                    file1.nextLine();
                }
                int wrong = 0;
                do {
                    int pass = 0;
                    int tempId = 0;
                    int viewId = 0;
                    while(pass != 1) {
                        System.out.println("Please enter the id of the animal you would like to view: ");
                        try {
                            tempId = user.nextInt();
                            pass = 1;
                        }
                        catch(InputMismatchException ex) {
                            String caught = user.next();
                            System.out.println("Please enter only whole numbers...");
                        }
                    }
                    int currentTotal = 0;
                    Scanner file2 = new Scanner(save);
                    while(file2.hasNextLine()) {
                        file2.nextLine();
                        currentTotal++;
                    }
                    Scanner file3 = new Scanner(save);
                    System.out.println(viewId);
                    String outputLine;
                    while(file3.hasNext()) {
                        String theNextLine = file3.nextLine();
                        Scanner nextRead = new Scanner(theNextLine);
                        if(theNextLine.startsWith(Integer.toString(tempId))) {
                            System.out.println("Id: " + nextRead.nextInt());
                            System.out.println("Name: " + nextRead.next());
                            System.out.println("Type: " + nextRead.next());
                            System.out.println("Color: " + nextRead.next());
                            System.out.println("Lifespan: " + nextRead.nextDouble());
                            System.out.println("Legs: " + nextRead.nextInt());
                            System.out.println("Arms: " + nextRead.nextInt());
                            System.out.println("Has a tail: " +  nextRead.next());
                            if(nextRead.hasNext()) {
                                System.out.println("Hair or Fur: " + nextRead.next());
                            }
                            wrong = 1;
                        }
                    }
                } while(wrong != 1);
            }
        }
    }
}
abstract class Animal {
    String color = "white";
    String type = "animal";
    String name = "dog";
    String size = "small";
    double lifeSpan = 25;
    int legs = 2;
    int arms = 2;
    boolean hasTail = false;
    int id = 0;
    protected Animal() {

    }
    abstract String getType();
    public String getColor() {
        return color;
    }
    public String getName() {
        return name;
    }
    public String getSize() {
        return size;
    }
    public double getLifeSpan() {
        return lifeSpan;
    }
    public int getLegs() {
        return legs;
    }
    public int getArms() {
        return arms;
    }
    public boolean getTail() {
        return hasTail;
    }
    public int getId() {
        return id;
    }
}
class Mammal extends Animal {
    String hairOrFur;
    Mammal(String newName, String newColor, String newSize, double newLifeSpan, String newHairOrFur, int newLegs, int newArms, boolean newHasTail, int newId) {
        type = "Mammal";
        name = newName;
        size = newSize;
        lifeSpan = newLifeSpan;
        hairOrFur = newHairOrFur;
        legs = newLegs;
        arms = newArms;
        hasTail = newHasTail;
        color = newColor;
        id = newId;
    }
    String getType() {
        return "Mammal";
    }
    String getHairOrFur() {
        return hairOrFur;
    }
    public String toString() {
        return (id + " " + name + " " + type + " " + color + " " + lifeSpan + " " + legs + " " + arms + " " + hasTail + " " + hairOrFur);
    }
    public String toOutput(int id, String name, String type, String color, double lifeSpan, int legs, int arms, boolean hasTail, String hairOrFur) {
        return ("ID: " + id + "\nName: " + name + "\nType: " + type + "\nColor: " + color + "\nLifeSpan: " + lifeSpan + "\nLegs: " + legs + "\nArms: " + arms + "\nHas Tail: " + hasTail + "\nHair Or Fur: " + hairOrFur);
    }
}
class Reptile extends Animal{
    Reptile(String newName, String newColor, String newSize, double newLifeSpan, int newLegs, int newArms, boolean newHasTail, int newId) {
        type = "Reptile";
        name = newName;
        size = newSize;
        lifeSpan = newLifeSpan;
        legs = newLegs;
        arms = newArms;
        hasTail = newHasTail;
        color = newColor;
        id = newId;
    }
    String getType() {
        return "Reptile";
    }
    public String toString() {
        return (id + " " + name + " " + type + " " + color + " " + lifeSpan + " " + legs + " " + arms + " " + hasTail);
    }
    public String toOutput(int id, String name, String type, String color, double lifeSpan, int legs, int arms, String hairOrFur) {
        return ("ID: " + id + "\nName: " + name + "\nType: " + type + "\nColor: " + color + "\nLifeSpan: " + lifeSpan + "\nLegs: " + legs + "\nArms: " + arms + "\nHas Tail: " + hasTail);
    }
}
class Fish extends Animal{
    Fish(String newName, String newColor, String newSize, double newLifeSpan, int newTailSize, int newFinCount, boolean newIsPet, int newId) {
            type = "Fish";
            name = newName;
            size = newSize;
            lifeSpan = newLifeSpan;
            int tailSize = newTailSize;
            int finCount = newFinCount;
            boolean isPet = newIsPet;
            color = newColor;
            id = newId;
        }
        String getType() {
            return "Fish";
        }
        public String toString() {
            return (id + " " + name + " " + type + " " + color + " " + lifeSpan + " " + tailSize + " " + finCount + " " + isPet);
        }
        public String toOutput(int id, String name, String type, String color, double lifeSpan, int tailSize, int finCount, boolean isPet) {
            return ("ID: " + id + "\nName: " + name + "\nType: " + type + "\nColor: " + color + "\nLifeSpan: " + lifeSpan + "\nTail Size: " + tailSize + "\nFin Count: " + finCount + "\nIs Pet: " + isPet);
        }
}
class Bird extends Animal{
    String getType() {
        return "Bird";
    }
}
class Amphibian extends Animal{
    String getType() {
        return "Amphibian";
    }
}
