import java.lang.Math;
import java.util.*;

class PrimitivePythagoreanTriples
{
    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int input(String prompt)
    {
        System.out.print(prompt);
        return new Scanner(System.in).nextInt();
    }

    public static void main(String args[])
    {
        System.out.println("Primitive Pythagorean Triples between n1 and n2.");
        int n1 = input("Enter n1 :\t");
        int n2 = input("Enter n2 :\t");
        if (n1 > n2)
            n1 = n1 + n2 - (n2 = n1);
        if (n1 < 3)
            n1 = 3;
        if (n1 != n2 && n2 > 4)
        {
            int b=1, i=0, f=1, n=(int)Math.log10(n2) + 1;
            for (int a = 2; ; a += 2)
            {
                if (gcd(a, b) != 1)
                    continue;
                int p = 2*a*b, q = a*a - b*b;
                if (p > q)
                    p = p + q - (q = p);
                if (p < n1)
                {
                    f = 1;
                    continue;
                }
                int r = a*a + b*b;
                if (r <= n2 && p >= n1)
                {
                    i++;
                    f = 1;
                    System.out.printf("%"+n+"d (%"+n+"d, %"+n+"d, %"+n+"d)\n", i, p, q, r);
                }
                else if (f != 0)
                {
                    a = b++;
                    f = 0;
                }
                else
                    break;
            }
        }
    }
}