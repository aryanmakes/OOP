import java.util.*;

abstract class Shape {
    protected double side1, side2;

    public Shape(double s1, double s2) {
        side1 = s1;
        side2 = s2;
    }

    public abstract double computeArea();
}

class Triangle extends Shape {
    public Triangle(double base, double height) {
        super(base, height);
    }

    @Override
    public double computeArea() {
        return 0.5 * side1 * side2;
    }
}

class Rectangle extends Shape {
    public Rectangle(double length, double width) {
        super(length, width);
    }

    @Override
    public double computeArea() {
        return side1 * side2;
    }
}

class ShapeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base and height of triangle:\n");
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        System.out.print("Enter he length and width of rectangle:\n");
        double length = sc.nextDouble();
        double width = sc.nextDouble();
        Triangle triangle = new Triangle(base, height);
        Rectangle rectangle = new Rectangle(length, width);
        Shape ShapeRef;
        ShapeRef = triangle;
        System.out.print("Area of Triangle: " + ShapeRef.computeArea() + "\n");
        ShapeRef = rectangle;
        System.out.print("Area of rectangle: " + ShapeRef.computeArea() + '\n');
        sc.close();
    }
}