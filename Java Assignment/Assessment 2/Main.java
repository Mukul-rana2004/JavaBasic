import java.util.Scanner;

abstract class Shape {
double area;

abstract void calculateArea();

void displayArea() {
    System.out.println("Area: " + area);
}

}

class Circle extends Shape {
double radius;


Circle(double radius) {
    this.radius = radius;
}

void calculateArea() {
    area = 3.14 * radius * radius;
}

}

class Rectangle extends Shape {
double length, breadth;


Rectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
}

void calculateArea() {
    area = length * breadth;
}

}

public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

    System.out.print("Enter radius of Circle: ");
    double r = sc.nextDouble();
    Circle c = new Circle(r);
    c.calculateArea();
    System.out.print("Circle ");
    c.displayArea();

    System.out.print("\nEnter length of Rectangle: ");
    double l = sc.nextDouble();
    System.out.print("Enter breadth of Rectangle: ");
    double b = sc.nextDouble();
    Rectangle rect = new Rectangle(l, b);
    rect.calculateArea();
    System.out.print("Rectangle ");
    rect.displayArea();

    sc.close();
}
}
