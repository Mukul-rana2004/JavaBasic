import java.util.Scanner;
class MCAII {
         int sapId=1299456;
         String name="Student1";
         
void display()
{
System.out.println("My SapId is "+ sapId+ "My Name is "+ name);
System.out.println(" I am in MCA AL/ML");
}
void details(){
Scanner sc=new Scanner(System.in);
System.out.println("Enter frist no. ");
int x=sc.nextInt();
System.out.println("Enter Second no. ");
int y=sc.nextInt();
int sum=x+y;
System.out.println("Sum of number is:"+sum);
}
public static void main(String[] args){
MCAII mca= new MCAII();
mca.display();
mca.details();
}
}
