public class TryCatchExample {
    public static void main(String[] args) {
        try{
            int a=10, b=0;
            int result = a/b; // this will cause ArthmeticException
            System.out.println("Result:"+result);
            System.out.println("This line will only occur if there is no exception");
        }
        catch(ArithmeticException e){
            System.out.println("Error: Division by zero is not allowed");
        }
        System.out.println("Program continues...");
    }
}
