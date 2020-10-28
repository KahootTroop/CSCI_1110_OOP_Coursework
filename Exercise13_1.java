/* Author: Isaac Bezzant
	Date: 10/22/2020
*/
import java.util.Scanner;
class Exercise13_1 {
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		double side1;
		double side2;
		double side3;
		String color;
		boolean filled;
		System.out.print("Enter side 1: ");
		side1 = user.nextDouble();
		System.out.print("Enter side 2: ");
		side2 = user.nextDouble();
		System.out.print("Enter side 3: ");
		side3 = user.nextDouble();
		System.out.print("Enter the color of the triangle: ");
		color = user.next();
		System.out.print("Is the triangle filled? ");
		if(user.next().equalsIgnoreCase("YES")) {
			filled = true;
		}
		else {
			filled = false;
		}
		System.out.println();
		Triangle testTriangle = new Triangle(side1, side2, side3);
		testTriangle.setFilled(filled);
		testTriangle.setColor(color);
		System.out.printf("Area: " + "%.2f", testTriangle.getArea());
		System.out.println();
		System.out.println("Perimeter: " + testTriangle.getPerimiter());
		System.out.println("Color: " + testTriangle.getColor());
		System.out.println("Date created: " + testTriangle.getDateCreated());
		System.out.println("Triangle is filled: " + testTriangle.isFilled());
	}
}
abstract class GeometricObject {
	private String color = "white";
	private boolean filled = false;
	private java.util.Date dateCreated;
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	protected GeometricObject(String newColor, boolean newFilled) {
		dateCreated =  new java.util.Date();
		color = newColor;
		filled = newFilled;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	} 
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	public String toString() {
		return "Created on " + dateCreated + "\n color: " + color + " and filled: " + filled;
	}
	public abstract double getArea();
	public abstract double getPerimiter();
}
class Triangle extends GeometricObject{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	Triangle() {
		
	}
	Triangle(double newSide1, double newSide2, double newSide3) {
		side1 = newSide1;
		side2 = newSide2;
		side3 = newSide3;
	}
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	public void setSide3(double side3) {
		this.side3 = side3;
	} 
	public double getArea() {
		double s = (side1 + side2 + side3) / 2.0;
		double area =  Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		return area;
	}
	public double getPerimiter() {
		return (side1 + side2 + side3);
	}
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}