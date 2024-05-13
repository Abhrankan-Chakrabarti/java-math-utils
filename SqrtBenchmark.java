import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class SqrtBenchmark {
    public static void main(String[] args) {
        int digits = 1000; // Number of decimal digits
        BigDecimal number = new BigDecimal("2"); // Number to calculate square root of

        // Benchmark BigDecimal in-built sqrt
        BigDecimal sqrt1 = number.sqrt(new MathContext(digits, RoundingMode.HALF_UP));

        // Benchmark pell_sqrt
        BigDecimal sqrt2 = new pell_sqrt().pell_sqrt(2, digits);

        // Debugging: Print the values of sqrt1 and sqrt2
        System.out.println("BigDecimal sqrt: " + sqrt1.toString());
        System.out.println("Pell sqrt: " + sqrt2.toString());

        // Check if the results are the same
        System.out.println("Results are equal: " + sqrt1.equals(sqrt2));
    }
}