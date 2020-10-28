/* Author: Isaac Bezzant
	Date: 10/22/2020
*/
public class Exercise13_7{
  public static void main(String[] args) {
    Triangle[] objarr = new Triangle[5];
    objarr[0] = new Triangle(8, 6, 7);
    objarr[1] = new Triangle(9, 7, 8);
    objarr[2] = new Triangle(7, 5, 6);
    objarr[3] = new Triangle(10, 8, 9);
    objarr[4] = new Triangle(6, 4, 5);
    for(int i = 0; i < 5; i++) {
      System.out.printf("%.2f ", objarr[i].getArea());
      if(objarr[i] instanceof Triangle) {
        objarr[i].howToColor();
      }
      System.out.println();
    }
  }
}
class GeometricObject {
	private String color = "white";
	private boolean filled = false;
	private java.util.Date dateCreated;
	public GeometricObject() {
		dateCreated = new java.util.Date();
	}
	public GeometricObject(String newColor, boolean newFilled) {
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
}
interface Colorable {
  public void howToColor();
}
class Triangle extends GeometricObject implements Colorable{
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
  @Override
  public void howToColor() {
    System.out.println("Color all three sides");
  }
}