/*
* Compute exp(x) to a certain number of decimal digits, and print it.
*
*   javac exp_bs.java
*
* WARNING: This is a demonstration program only, is not optimized for
* speed, and should not be used for serious work!
*
*/

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;
public class exp_bs
{

/**
 * Compute exp(x) to the specified number of decimal digits using the
 * Taylor Series.
 *
 */
public static BigDecimal[] bs(int a, int b, BigDecimal x)
{
	int m;
	BigDecimal Pab, Qab, Pam, Qam, Pmb, Qmb, PQ[] = new BigDecimal[2];
	if (b - a == 1)
	{
		Pab = x.pow(b);
		Qab = BigDecimal.valueOf(b);
	}
	else
	{
		m = (a + b) / 2;
		PQ = bs(a, m, x);
		Pam = PQ[0];
		Qam = PQ[1];
		PQ = bs(m, b, x);
		Pmb = PQ[0];
		Qmb = PQ[1];
		Pab = Pam.multiply(Qmb).add(Pmb);
		Qab = Qam.multiply(Qmb);
	}
	PQ[0] = Pab;
	PQ[1] = Qab;
	return PQ;
}
public static int invgammaof10tothepower(int y)
{
  int x=1;
  double s=0;
  while (y>s)
  {
    x++;
    s+=Math.log10(x);
  }
  return x;
}
public static BigDecimal exp(double x, int digits)
{
	BigDecimal expx, pow = BigDecimal.valueOf(x);
	BigDecimal P, Q, PQ[] = new BigDecimal[2];

	int iterations = invgammaof10tothepower(digits) + 1;

	MathContext mcon = new MathContext(digits + 6);

	// now the fun bit
	PQ = bs(0, iterations, pow);
	P = PQ[0];
	Q = PQ[1];

	// final calculations (solve for exp(x))
	expx = P.divide(Q, mcon); // exp(x) already P / Q at this point, so just FYI
	expx = expx.add(BigDecimal.ONE).setScale(digits, RoundingMode.DOWN);  // add 1

	return expx;
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
	System.out.println("usage: java exp_bs [x] [digits]");
}

/**
 * MAIN
 *
 * See print_usage() for usage.
 */
public static void main(String args[])
{
	BigDecimal expx;
	double x;
	int digits;

	switch (len(args))
	{
	case 0:
	  System.out.print("Enter power of e :\t");
	  x = new Scanner(System.in).nextDouble();
	  System.out.print("How many digits of exp("+x+")? :\t");
		digits = new Scanner(System.in).nextInt();
		break;

	case 2:
	  x = Double.parseDouble(args[0]);
		digits = Integer.parseInt(args[1]);
		break;

	default:
		print_usage();
		return;
	}

	if (digits < 0)
	{
		print_usage();
		return;
	}

	expx = exp(x, digits);

	System.out.println(expx);
}
}
