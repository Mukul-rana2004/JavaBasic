import java.util.Scanner; //Mukul Rana 590028229
class Unary {
public static void main(String[] args){
 Scanner sc=new Scanner(System.in);
System.out.println("Enter first number");
int a= sc.nextInt();
System.out.println("Enter second number");
int b= sc.nextInt();
System.out.println("Post Increment" + (a++));
System.out.println("Pre Increment:" + (++a));
System.out.println("Post Decrement:" + (b--));
System.out.println("Pre Decrement:" + (--b));
}
}
