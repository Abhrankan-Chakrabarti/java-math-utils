import java.util.*;

public class pell_equation_solver
{
    static void solve_pell_equation(int D, int n)
    {
        if (n < 1)
            return;
        int x1 = 1, y1 = 0, x2, y2, x, y;
        System.out.printf("0 (%d, %d)\n", x1, y1);
        if (n < 2)
            return;
        int arr[] = new int[2];
        arr = new sqrt(D).solve_pell_equation();
        x2 = arr[0];
        y2 = arr[1];
        if (y2 == 0)
        {
            System.out.printf("No more solutions for x² - %dy² = 1.\n", D);
            return;
        }
        System.out.printf("1 (%d, %d)\n", x2, y2);
        x1 = x2;
        y1 = y2;

        for (int i = 2; i < n; i++)
        {
            x = x1*x2 + D*y1*y2;
            y = x1*y2 + y1*x2;
            x2 = x;
            y2 = y;
            System.out.printf("%d (%d, %d)\n", i, x2, y2);
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
        System.out.println("usage: java pell_equation_solver [D] [n]");
    }

    public static void main(String args[])
    {
        int D, n;
        System.out.println("This program solves the equation x² - Dy² = 1.");

        switch (len(args))
        {
            case 0:
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the number D :\t");
                D = sc.nextInt();
                System.out.printf("How many solutions of x² - %dy² = 1? :\t",D);
                n = sc.nextInt();
                break;

            case 2:
                D = Integer.parseInt(args[0]);
                n = Integer.parseInt(args[1]);
                break;

            default:
                print_usage();
                return;
        }

        solve_pell_equation(D, n);
    }
}