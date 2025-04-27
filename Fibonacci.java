import java.util.*;
import java.math.BigInteger;

class Fibonacci
{
    public static BigInteger F(int n)
    {
        if (n == 0)
            return BigInteger.ZERO;
        if (n == 1)
            return BigInteger.ONE;
        if (n % 2 == 0)
        {
	    int k = n / 2;
            BigInteger a = F(k), b = F(k - 1);
            return a.multiply(BigInteger.valueOf(2).multiply(b).add(a));
        }
	int k = (n - 1) / 2;
        BigInteger a = F(k), b = F(k - 1);
        return BigInteger.valueOf(2).multiply(a).add(b).multiply(BigInteger.valueOf(2).multiply(a).subtract(b)).add(BigInteger.valueOf(-4 * (k % 2) + 2));
    }

    public static void main(String args[])
    {
        System.out.println("This program computes the n-th Fibonacci number.");
        Scanner sc = new Scanner(System.in);
        int n;
        do
        {
            System.out.print("Enter n :\t");
            n = sc.nextInt();
            if (n >= 0)
                System.out.printf("F(%,d)\t=%, d\n", n, F(n));
        }
        while (n >= 0);
    }
}
