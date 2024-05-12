import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class pell_sqrt
{
    static BigDecimal pell_sqrt(int N, int digits)
    {
        MathContext mcon = new MathContext(digits + 6);
        BigDecimal D = BigDecimal.valueOf(N), x, y;
        BigDecimal x1 = BigDecimal.ONE, y1 = BigDecimal.ZERO;
        int arr[] = new int[2];
        arr = new sqrt(N).solve_pell_equation(false);
        BigDecimal x2 = BigDecimal.valueOf(arr[0]), y2 = BigDecimal.valueOf(arr[1]);
        BigDecimal y_target = BigDecimal.valueOf(10).pow(digits / 2 + 5);
        while (true)
        {
            x = x1.multiply(x2).add(D.multiply(y1).multiply(y2));
            y = x1.multiply(y2).add(y1.multiply(x2));
            if (y.compareTo(y_target) == 1)
                return x.divide(y, mcon).setScale(digits, RoundingMode.DOWN);
            x1 = x2;
            y1 = y2;
            x2 = x;
            y2 = y;
        }
    }

    public static int len(String array[])
    {
        int i;
        String s;
        for (i = 0; ; i++)
        {
            try
            {
                s = array[i];
            }
            catch (java.lang.ArrayIndexOutOfBoundsException e)
            {
                break;
            }
        }
        return i;
    }

    /**
     * Print a usage message
     */
    public static void print_usage()
    {
        System.out.println("usage: java pell_sqrt [D] [digits]");
    }

    public static void main(String args[])
    {
        BigDecimal sqrtx;
        int D, digits;

        switch (len(args))
        {
            case 0:
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the number :\t");
                D = sc.nextInt();
                System.out.printf("How many digits of \u221A%d :\t",D);
                digits = sc.nextInt();
                break;

            case 2:
                D = Integer.parseInt(args[0]);
                digits = Integer.parseInt(args[1]);
                break;

            default:
                print_usage();
                return;
        }

        sqrtx = pell_sqrt(D, digits);

        System.out.println("\u221A"+D+" = "+sqrtx+"...");
    }
}