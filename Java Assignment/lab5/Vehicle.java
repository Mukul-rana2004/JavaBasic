public abstract class Vehicle{
    public abstract int getNo_ofwheels();
}
class Bus extends Vehicle{
    public int getNo_ofwheels(){
        return 6;
    }
}
class Auto extends Vehicle{
    public int getNo_ofwheels(){
        return 3;
    }
}
class Ev extends Auto{
    //Restriction of implementing the abstract method of parent is upto immmediate child class only 
}
 class test2{
    public static void main(String[] args){
        Bus b = new Bus();
        System.out.println(b.getNo_ofwheels());
        Auto a = new Auto();
        System.out.println(a.getNo_ofwheels());
    }
 }