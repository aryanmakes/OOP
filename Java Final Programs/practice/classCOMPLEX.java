import java.util.*;

class Complex {
    private double real;
    private double imaginary;

    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;

    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;

    }

    public Complex add(Complex other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    public Complex sub(Complex other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new Complex(newReal, newImaginary);

    }

    public Complex multiply(Complex other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(newReal, newImaginary);
    }

    public void display() {
        System.out.println(this.real + "+" + this.imaginary + "i");

    }
}

class ComplexDemo {
    public static void main(string[] args) {
        Complex complex1 = new Complex(2.0, 3.0);
        Complex complex2 = new Complex(3.0, 4.0);
        Complex add = complex1.add(complex2);
        Complex sub = complex1.sub(complex2);
        Complex multiply = complex1.multiply(complex2);
        System.out.println("Complex 1: ");
        complex1.display();
        System.out.println("Complex 2: ");
        complex2.display();
        System.out.println("Addition: ");
        add.display();
        System.out.println("Subtraction: ");
        sub.display();
        System.out.println("Multiplication: ");
        multiply.display();
    }
}