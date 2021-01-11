# Object Oriented Programming Final Project

## Synopsis
This is a text based animal logging system that allows the user to save new animals they encounter.

## Motivation
This was created to demonstrate the use of classes in creating objects as well as editing and saving program data in files.

## How to use
When the program is run you will be prompted to enter an animal. Once an animal is entered it is saved in a file on your desktop. When the program is stopped
the save file keeps all of the data safe. When the program is run again you can look at previous entries by having the program retreive the data about them. 
<img src="FinalProject/ss.png" />

## Code Example
This part of the code is how the program finds and displays data about a Mammal entry
```
Scanner file3 = new Scanner(save);
System.out.println(viewId);
while(file3.hasNext()) {
  String theNextLine = file3.nextLine();
  Scanner nextRead = new Scanner(theNextLine);
  Scanner typeFinder = new Scanner(theNextLine);
  typeFinder.next();
  String typeFound = typeFinder.next();
  if(theNextLine.startsWith(Integer.toString(tempId))) {
    if(typeFound.equals("M")) {
      System.out.println("Id: " + nextRead.nextInt());
      nextRead.next();
      System.out.println("Name: " + nextRead.next());
      System.out.println("Type: " + nextRead.next());
      System.out.println("Color: " + nextRead.next());
      System.out.println("Lifespan in years: " + nextRead.nextDouble());
      System.out.println("Legs: " + nextRead.nextInt());
      System.out.println("Arms: " + nextRead.nextInt());
      System.out.println("Has a tail: " +  nextRead.next());
      System.out.println("Hair or Fur: " + nextRead.next());
    }
```
