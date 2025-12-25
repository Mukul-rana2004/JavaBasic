import java.util.Scanner;
import mylab.AdvancedCalculator;

public class MainProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AdvancedCalculator calc = new AdvancedCalculator();

        try {
            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(sc.nextLine());

            System.out.print("Enter operator (+, -, *, /, %): ");
            char op = sc.next().charAt(0);

            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(sc.nextLine());

            double result = 0;

            switch (op) {
                case '+':
                    result = calc.add(num1, num2);
                    break;

                case '-':
                    result = calc.subtract(num1, num2);
                    break;

                case '*':
                    result = calc.multiply(num1, num2);
                    break;

                case '/':
                    result = calc.divide(num1, num2);
                    break;

                case '%':
                    result = calc.modulus(num1, num2);
                    break;

                default:
                    System.out.println("Invalid operator entered.");
                    return;
            }

            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input.");
        } catch (ArithmeticException e) {
            System.out.println("Math Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred.");
        } finally {
            sc.close();
        }
    }
}
