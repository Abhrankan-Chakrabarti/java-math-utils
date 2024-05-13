import java.math.BigDecimal;
import java.math.RoundingMode;

public class SqrtBenchmark {
    public static void main(String[] args) {
        int digits = 1000; // Number of decimal digits
        BigDecimal number = new BigDecimal("2"); // Number to calculate square root of

        // Benchmark BigDecimal in-built sqrt
        long startTime = System.currentTimeMillis();
        BigDecimal sqrt1 = number.sqrt(new MathContext(digits, RoundingMode.HALF_UP));
        long endTime = System.currentTimeMillis();
        long timeBigDecimal = endTime - startTime;

        // Benchmark pell_sqrt
        startTime = System.currentTimeMillis();
        BigDecimal sqrt2 = pell_sqrt(2, digits);
        endTime = System.currentTimeMillis();
        long timePellSqrt = endTime - startTime;

        System.out.println("BigDecimal sqrt time: " + timeBigDecimal + " ms");
        System.out.println("Pell sqrt time: " + timePellSqrt + " ms");

        // Check if the results are the same
        System.out.println("Results are equal: " + sqrt1.equals(sqrt2));
    }

    public static BigDecimal pell_sqrt(int N, int digits) {
        // Your pell_sqrt implementation here
        return BigDecimal.ZERO;
    }
}