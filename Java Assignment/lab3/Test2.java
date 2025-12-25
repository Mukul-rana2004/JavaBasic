class Person {
    void showPersonDetails() {
        System.out.println("I am a Person");
    }
}

class Employee extends Person {
    void showEmployeeDetails() {
        System.out.println("I am an Employee");
    }
}

class Manager extends Employee {
    void showManagerDetails() {
        System.out.println("I am a Manager");
    }
}

public class Test2 {
    public static void main(String[] args) {
        Manager m = new Manager();

        m.showManagerDetails();

        m.showEmployeeDetails();

        m.showPersonDetails();
    }
}
