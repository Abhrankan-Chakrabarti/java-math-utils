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
            BigInteger a = F(n / 2), b = F(n / 2 - 1);
            return a.multiply(BigInteger.valueOf(2).multiply(b).add(a));
        }
        BigInteger a = F((n + 1) / 2), b = F((n - 1) / 2);
        return a.multiply(a).add(b.multiply(b));
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