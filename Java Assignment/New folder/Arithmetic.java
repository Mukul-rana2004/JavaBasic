import java.util.Scanner; //Mukul Rana 590028229
class Arithmetic {
public static void main(String[] args){
 Scanner sc=new Scanner(System.in);
System.out.print("Enter first number");
int a= sc.nextInt();
System.out.print("Enter second Number");
int b= sc.nextInt();
System.out.println("a+b=" + (a+b));
System.out.println("a-b=" + (a-b));
System.out.println("a*b=" + (a*b));
System.out.println("a/b=" + (a/b));
System.out.println("a%b=" + (a%b));
}
}