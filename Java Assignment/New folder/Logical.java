import java.util.Scanner; //Mukul Rana 590028229
class Logical  {
public static void main(String[] args){
 Scanner sc=new Scanner(System.in);
System.out.println("Enter first number");
int a= sc.nextInt();
System.out.println("Enter second number");
int b= sc.nextInt();
System.out.println("(a>b && a>=0:)" + (a>b && a>=0));
System.out.println("(a>10 || a<20:)" + (a>10 || a<20));
System.out.println("!(a>0)" + (!(a>0)));
}
}
