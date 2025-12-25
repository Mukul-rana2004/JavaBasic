class Parent {
    public void property() {
        System.out.println("Cash + Gold + other Property");
    }
    public void marry() {
        System.out.println("XYZ");
    }
}

class Child extends Parent {
    public void marry() {
        System.out.println("ABC");
    }
}

class Test {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.marry();  // (1)

        Child c = new Child();
        c.marry();  // (2)

        Parent p1 = new Child();
        p1.marry(); // (3)
    }
}