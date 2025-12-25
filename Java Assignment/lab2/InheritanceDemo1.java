class Parent {
    String S = "Parent Variable"; 
}

class Child extends Parent {
    String S = "Child Variable";    

    void showVariables() {
        System.out.println(S);        
        System.out.println(this.S);   
        System.out.println(super.S);  
    }
}

public class InheritanceDemo1 {
    public static void main(String[] args) {
        Child c = new Child();   
        c.showVariables();       
}
