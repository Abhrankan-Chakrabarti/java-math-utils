import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class golden_ratio_pell
{
    static BigDecimal golden_ratio(int digits)
    {
        MathContext mcon = new MathContext(digits + 6);
        BigDecimal D = BigDecimal.valueOf(5), x, y;
        BigDecimal x1 = BigDecimal.ONE, y1 = BigDecimal.ZERO;
        BigDecimal x2 = BigDecimal.valueOf(9), y2 = BigDecimal.valueOf(4);
        BigDecimal y_target = BigDecimal.TEN.pow(digits / 2 + 5);
        while (true)
        {
            x = x1.multiply(x2).add(D.multiply(y1).multiply(y2));
            y = x1.multiply(y2).add(y1.multiply(x2));
            if (y.compareTo(y_target) == 1)
                return x.divide(y, mcon).add(BigDecimal.ONE).divide(BigDecimal.valueOf(2), mcon).setScale(digits, RoundingMode.DOWN);
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
        System.out.println("usage: java golden_ratio_pell [digits]");
    }

    public static void main(String args[])
    {
        BigDecimal phi;
        int digits;

        switch (len(args))
        {
            case 0:
                Scanner sc = new Scanner(System.in);
                System.out.print("How many digits of ϕ :\t");
                digits = sc.nextInt();
                break;

            case 1:
                digits = Integer.parseInt(args[0]);
                break;

            default:
                print_usage();
                return;
        }

        phi = golden_ratio(digits);

        System.out.println("ϕ = "+phi+"...");
    }
}