import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class SqrtBenchmark {
    public static void main(String[] args) {
        int digits = 1000; // Number of decimal digits
        BigDecimal number = new BigDecimal("2"); // Number to calculate square root of

        // Benchmark BigDecimal in-built sqrt
        long startTime = System.currentTimeMillis();
        BigDecimal sqrt1 = number.sqrt(new MathContext(digits + 1, RoundingMode.HALF_UP))
                                  .setScale(digits, RoundingMode.HALF_UP);
        long endTime = System.currentTimeMillis();
        long timeBigDecimal = endTime - startTime;

        // Benchmark pell_sqrt
        startTime = System.currentTimeMillis();
        BigDecimal sqrt2 = new pell_sqrt().pell_sqrt(2, digits + 1)
                                          .setScale(digits, RoundingMode.HALF_UP);
        endTime = System.currentTimeMillis();
        long timePellSqrt = endTime - startTime;

        System.out.println("BigDecimal sqrt result: " + sqrt1);
        System.out.println("Pell sqrt result: " + sqrt2);

        // Check if the results are the same
        System.out.println("Results are equal: " + sqrt1.equals(sqrt2));

        // Print benchmark times
        System.out.println("BigDecimal sqrt time: " + timeBigDecimal + " ms");
        System.out.println("Pell sqrt time: " + timePellSqrt + " ms");
    }
}