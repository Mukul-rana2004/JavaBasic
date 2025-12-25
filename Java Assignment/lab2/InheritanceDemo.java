class Parent {
    void parentMethod() {
        System.out.println("ParentMethod");
    }
}

class Child extends Parent {
    void childMethod() {
        System.out.println("ChildMethod");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Parent p = new Parent();   
        Child c = new Child();     

        p.parentMethod();          
        c.childMethod();           
        c.parentMethod();          
    }
}
