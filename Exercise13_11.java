/* Author: Isaac Bezzant
   Date: 10/27/2020
*/
import java.lang.Cloneable;
import java.lang.Comparable;
class Exercise13_11 {
	public static void main(String[] args) {
		Octagon octa = new Octagon(4, 4, 4, 4, 4, 4, 4, 4);
    try {
      Octagon octag = (Octagon)octa.clone();
      System.out.println(octa.compareTo(octag));
    }
    catch(CloneNotSupportedException ex) {
      System.out.println("CloneNotSupportedException thrown...");
    } 

	}
}
class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
	double side1 = 0;
	double side2 = 0;
	double side3 = 0;
	double side4 = 0;
	double side5 = 0;
	double side6 = 0;
	double side7 = 0;
	double side8 = 0;
	public Octagon() {
		
	}
	public Octagon(double newSide1, double newSide2, double newSide3, double newSide4, double newSide5, double newSide6, double newSide7, double newSide8) {
		side1 = newSide1;
		side2 = newSide2;
		side3 = newSide3;
		side4 = newSide4;
		side5 = newSide5;
		side6 = newSide6;
		side7 = newSide7;
		side8 = newSide8;
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
	public double getSide4() {
		return side4;
	}
	public double getSide5() {
		return side5;
	}
	public double getSide6() {
		return side6;
	}
	public double getSide7() {
		return side7;
	}
	public double getSide8() {
		return side8;
	}
	public void setSide1(double newSide1) {
		side1 = newSide1;
	}
	public void setSide2(double newSide2) {
		side2 = newSide2;
	}	
	public void setSide3(double newSide3) {
		side3 = newSide3;
	}
	public void setSide4(double newSide4) {
		side4 = newSide4;
	}
	public void setSide5(double newSide5) {
		side5 = newSide5;
	}
	public void setSide6(double newSide6) {
		side6 = newSide6;
	}
	public void setSide7(double newSide7) {
		side7 = newSide7;
	}
	public void setSide8(double newSide8) {
		side8 = newSide8;
	}
  public double getArea() {
    return (2 + (4/Math.sqrt(2)) * side1 * side2);
  }
  public double getPerimeter() {
    return side1 * 8;
  }
  public String toString() {
    return "Octagon perimeter: " + getPerimeter() + String.format("\n Octagon area: %.2f", getArea());
  }
  @Override
  public Object clone() throws CloneNotSupportedException{
    return (Octagon)super.clone();
  }
  @Override
  public int compareTo(Octagon octagon) {
    if(getArea() > octagon.getArea()) {
      return 1;
    }
    if(getArea() < octagon.getArea()) {
      return -1;
    }
    else {
      return 0;
    }
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
	public abstract double getPerimeter();
}
