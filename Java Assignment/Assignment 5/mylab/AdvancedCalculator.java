package mylab;

public class AdvancedCalculator extends Calculator {

    public double modulus(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot take modulus with zero");
        }
        return a % b;
    }
}
