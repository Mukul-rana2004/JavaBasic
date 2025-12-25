abstract class Ex1{
    void m1(){

    }
}
abstract class Ex2{
    abstract void m1();
    void m2(){
        // non abstract method
    }
}
class child extends Ex2{
    void m1(){
        // overriding abstract method m1 of parent class Ex2
    }
}
class test{
    public static void main(String[] args){
       // Ex1 obj = new Ex1();
    }
}