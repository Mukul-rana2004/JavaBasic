import java.util.Scanner;

class Person {
String name;
int age;
}

class Employee extends Person {
double salary;

void inputDetails() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Name: ");
    name = sc.nextLine();
    System.out.print("Enter Age: ");
    age = sc.nextInt();
    System.out.print("Enter Salary: ");
    salary = sc.nextDouble();
}

void displayDetails() {
    System.out.println("\n--- Employee Details ---");
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Salary: " + salary);
}

public static void main(String[] args) {
    Employee emp = new Employee();
    emp.inputDetails();
    emp.displayDetails();
}

}
