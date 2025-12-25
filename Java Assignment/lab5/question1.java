import java.util.Scanner;
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    int r;

    Circle(int r) {
        this.r = r;
    }

    double area() {
        return 3.14*r*r;
    }
}

class Rectangle extends Shape {
    int l, b;

    Rectangle(int l, int b) {
        this.l = l;
        this.b = b;
    }

    double area() {
        return l*b;
    }
}

class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        int radius = sc.nextInt();
        System.out.print("Enter length of rectangle: ");
        int length = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int breadth = sc.nextInt();
        Circle c = new Circle(radius);
        Rectangle r = new Rectangle(length,breadth);

        System.out.println("Area of Circle: " + c.area());
        System.out.println("Area of Rectangle: " + r.area());
        sc.close();
    }
}
