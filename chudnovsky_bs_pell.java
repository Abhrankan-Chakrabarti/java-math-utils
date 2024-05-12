import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;
public class chudnovsky_bs_pell
{
// how many to display if the user doesn't specify:
public static int DEFAULT_DIGITS = 60;

// how many decimal digits the algorithm generates per iteration:
public static double DIGITS_PER_ITERATION = 14.1816474627254776555;

public static long C = 640320, C3_OVER_24;

public static BigDecimal t(long a)
{
	BigDecimal Tab;
	Tab = BigDecimal.valueOf(545140134).multiply(BigDecimal.valueOf(a)).add(BigDecimal.valueOf(13591409));
	if ((a & 1) == 1)
		Tab = Tab.negate();
	return Tab;
}
public static BigDecimal p(long a)
{
	long P1 = 6 * a - 5, P2 = 2 * a - 1, P3 = 6 * a - 1;
	return BigDecimal.valueOf(P1).multiply(BigDecimal.valueOf(P2)).multiply(BigDecimal.valueOf(P3));
}
public static BigDecimal q(long a)
{
	return BigDecimal.valueOf(a).pow(3).multiply(BigDecimal.valueOf(C3_OVER_24));
}
public static BigDecimal[] bs(long a, long b)
{
	long m;
	BigDecimal Pab, Qab, Tab, Pam, Qam, Tam, Pmb, Qmb, Tmb, PQT[] = new BigDecimal[3];
	if (b - a == 1)
	{
		if (a == 0)
		{
			Pab = BigDecimal.ONE;
			Qab = BigDecimal.ONE;
		}
		else
		{
			Pab = p(a);
			Qab = q(a);
		}
		Tab = t(a);
		Tab = Tab.multiply(Pab);
	}
	else
	{
		m = (a + b) / 2;
		PQT = bs(a, m);
		Pam = PQT[0];
		Qam = PQT[1];
		Tam = PQT[2];
		PQT = bs(m, b);
		Pmb = PQT[0];
		Qmb = PQT[1];
		Tmb = PQT[2];
		Pab = Pam.multiply(Pmb);
		Qab = Qam.multiply(Qmb);
		Tab = Qmb.multiply(Tam).add(Pam.multiply(Tmb));
	}
	PQT[0] = Pab;
	PQT[1] = Qab;
	PQT[2] = Tab;
	return PQT;
}
public static BigDecimal pell_sqrt_10005(int digits, MathContext mcon)
{
	BigDecimal D = BigDecimal.valueOf(10005), x, y;
	BigDecimal x1 = BigDecimal.ONE, y1 = BigDecimal.ZERO;
	BigDecimal x2 = BigDecimal.valueOf(4001), y2 = BigDecimal.valueOf(40);
	BigDecimal y_target = BigDecimal.valueOf(10).pow(digits / 2 + 5);
	while (true)
	{
		x = x1.multiply(x2).add(D.multiply(y1).multiply(y2));
		y = x1.multiply(y2).add(y1.multiply(x2));
		if (y.compareTo(y_target) == 1)
			return x.divide(y, mcon);
		x1 = x2;
		y1 = y2;
		x2 = x;
		y2 = y;
	}
}
public static BigDecimal chudnovsky(int digits)
{
	BigDecimal con, pi;
	BigDecimal Q, T, PQT[] = new BigDecimal[3];
	double bits_per_digit;

	long iterations = (long)(digits / DIGITS_PER_ITERATION) + 1;

	MathContext mcon = new MathContext(digits + 6);

	// first the constant sqrt part
	con = pell_sqrt_10005(digits, mcon);
	con = con.multiply(BigDecimal.valueOf(426880));

	// now the fun bit
	C3_OVER_24 = C * C * C / 24;
	PQT = bs(0, iterations);
	Q = PQT[1];
	T = PQT[2];

	// final calculations (solve for pi)
	pi = Q.divide(T, mcon); // pi already Q / T at this point, so just FYI
	pi = pi.multiply(con).setScale(digits, RoundingMode.DOWN);  // multiply by constant sqrt part

	return pi;
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
	System.out.println("usage: java chudnovsky_bs_pell [digits]");
}

/**
 * MAIN
 *
 * See print_usage() for usage.
 */
public static void main(String args[])
{
	BigDecimal pi;
	int digits;

	switch (len(args))
	{
	case 0:
		digits = DEFAULT_DIGITS;
		break;

	case 1:
		digits = Integer.parseInt(args[0]);
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

	pi = chudnovsky(digits);

	System.out.println(pi);
}
}
