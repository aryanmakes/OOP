import java.util.Scanner;

// Abstract base class Shape
abstract class Shape {
    protected double side1, side2;

    public Shape(double s1, double s2) {
        side1 = s1;
        side2 = s2;
    }

    public abstract double computeArea(); // Abstract method
}

// Derived class Triangle
class Triangle extends Shape {
    public Triangle(double base, double height) {
        super(base, height);
    }

    @Override
    public double computeArea() {
        return 0.5 * side1 * side2; // Area of a triangle
    }
}

// Derived class Rectangle
class Rectangle extends Shape {
    public Rectangle(double length, double width) {
        super(length, width);
    }

    @Override
    public double computeArea() {
        return side1 * side2; // Area of a rectangle
    }
}

class ShapeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base and height of the triangle: ");
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        System.out.print("Enter the length and width of the rectangle: ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        // Create objects of derived classes
        Triangle triangle = new Triangle(base, height);
        Rectangle rectangle = new Rectangle(length, width);

        // Reference to the base class
        Shape shapeRef;

        // Dynamic binding - computeArea method of the appropriate derived class is
        // called
        shapeRef = triangle;
        System.out.println("Area of the triangle: " + shapeRef.computeArea());

        shapeRef = rectangle;
        System.out.println("Area of the rectangle: " + shapeRef.computeArea());

        scanner.close();
    }
}
