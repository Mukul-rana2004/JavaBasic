public class TryCatchFinally {
    public static void main(String[] args) {
        try{
            int[] numbers = {1, 2 ,3};// this will cause ArthmeticException
            System.out.println(numbers[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Array index is out range");
        }
        finally {
            System.out.println("Finally block always executes");
        }
    }
}

