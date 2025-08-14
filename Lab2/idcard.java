// write a program to print your identity cards details using scanner class 

import java.util.Scanner;
class idcard {
void details(){
Scanner sc=new Scanner(System.in);
System.out.println("Enter your name");
String name=sc.nextLine();
System.out.println("Enter your School");
String sch=sc.nextLine();
System.out.println("Enter your Program");
String pg=sc.next();
System.out.println("Enter your Batch");
int b=sc.nextInt();
System.out.println("Enter your SapID");
int sapid=sc.nextInt();
System.out.println("Name:"+name+"\n School:"+sch+"\n Program"+pg+"\n Batch:"+b+ "\n SapID:"+sapid);
}
public static void main(String[] args){
idcard record= new idcard();
record.details();
}
}




