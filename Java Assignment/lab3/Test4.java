class Person {
    void info() {
        System.out.println("This is a person");
    }
}

class Student extends Person {
    @Override
    void info() {
        System.out.println("This is a student");
    }
}

public class Test4 {
    public static void main(String[] args) {
        Student s = new Student();
        s.info();  
    }
}
