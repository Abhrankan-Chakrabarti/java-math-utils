import java.util.*;
import java.math.*;

class acot
{
    BigInteger s;
    int n, x = 10;

    acot(int x, int n)
    {
        this.n = n;
        BigInteger i = BigInteger.ONE, TWO = BigInteger.valueOf(2), t, x2;
        s = t = BigInteger.TEN.pow(n + this.x).divide(BigInteger.valueOf(x));
        x2 = BigInteger.valueOf(x * x);
        while (t.signum() != 0)
        {
            i = i.add(TWO);
            t = t.divide(x2.negate());
            s = s.add(t.divide(i));
        }
    }

    public static BigDecimal valueOf(int x, int n)
    {
        return new BigDecimal(new acot(x, n).toString());
    }

    public static String zfill(String s, int length)
    {
        return String.format("%1$" + length + "s", s).replace(' ', '0');
    }

    public String toString()
    {
        String acotx = s.divide(BigInteger.TEN.pow(n + x)).toString() + "." + zfill(s.divide(BigInteger.TEN.pow(x)).abs().mod(BigInteger.TEN.pow(n)).toString(), n);
        if (s.signum() == -1)
            acotx = "-" + acotx;
        return acotx;
    }

    public static BigDecimal machin(int a[], int b[], int nterms, int n, int x)
    {
        BigDecimal PiBy4 = BigDecimal.ZERO;
        for (int i = 0; i < nterms; ++i)
            PiBy4 = PiBy4.add(BigDecimal.valueOf(a[i]).multiply(acot.valueOf(b[i], n + x)));
        return PiBy4;
    }

    public static BigDecimal pi(int n)
    {
        int a[] = {183, 32, -68, 12, -12, -100};
        int b[] = {239, 1023, 5832, 110443, 4841182, 6826318};
        int nterms = 6, x = 10;
        return BigDecimal.valueOf(4).multiply(machin(a, b, nterms, n, x));
    }

    public static int input(String prompt)
    {
        System.out.print(prompt);
        return new Scanner(System.in).nextInt();
    }

    public static void printchar(char c, int n)
    {
        for (; n > 0; --n)
            System.out.print(c);
    }

    public static void main(String args[])
    {
        System.out.println("This program computes acot(x).");
        int x = input("Enter an integer x :\t");
        int n = input("How many digits of acot(" + x + ")? :\t");
        if (n > 0)
        {
            MathContext con = new MathContext(n);
            int ntimes;
            if (x == 0)
                ntimes = 8;
            else
                ntimes = (int)Math.log10(Math.abs(x)) + (x / Math.abs(x) == 1 ? 8 : 9);
            if (Math.abs(x) != 1 && x != 0)
            {
                acot acotx = new acot(x, n);
                System.out.println("acot(" + x + ") = " + acotx.toString() + " rad");
                printchar(' ', ntimes);
                System.out.println("= " + BigDecimal.valueOf(180).multiply(new BigDecimal(acotx.toString())).divide(pi(n), con) + "°");
            }
            else
            {
                System.out.println("acot(" + x + ") = " + BigDecimal.valueOf(x == 0 ? 1 : x).multiply(pi(n)).divide(BigDecimal.valueOf(x == 0 ? 2 : 4), con) + " rad");
                printchar(' ', ntimes);
                System.out.println("= " + (x == 0 ? 90 : 45 * x) + "°");
            }
        }
    }
}
