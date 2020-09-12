public class Exercise9_1 {
	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(4, 40);
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		System.out.println("Rectangle one-");
		System.out.println("Width: " + rectangle1.width);
		System.out.println("Height: " + rectangle1.height);
		System.out.println("Area: " + rectangle1.getArea(rectangle1.width, rectangle1.height));
		System.out.println("Perimeter: " + rectangle1.getPerimeter(rectangle1.width, rectangle1.height));
		System.out.println();
		System.out.println("Rectangle two-");
		System.out.println("Width: " + rectangle2.width);
		System.out.println("Height: " + rectangle2.height);
		System.out.printf("Area: %3.1f", rectangle2.getArea(rectangle2.width, rectangle2.height));
		System.out.println();
		System.out.println("Perimeter: " + rectangle2.getPerimeter(rectangle2.width, rectangle2.height));
	}
}
class Rectangle {
	double width = 1;
	double height = 1;
	Rectangle() {
	}
	Rectangle(double newWidth, double newHeight) {
		width = newWidth;
		height = newHeight;
	}
	double getArea(double width, double height) {
		return width * height;
	}
	double getPerimeter(double width, double height) {
		return 2 * (width + height);
	}
}
