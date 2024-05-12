import java.util.*;

class sqrt
{
    int N, a0, recursionlimit=1000;
    double x;
    boolean print_table=false, trivial=true;
    char hv='h', nondefault='v';
    ArrayList<Integer> c, a;

    sqrt(int N)
    {
        this.N = N;
        x = Math.sqrt(N);
        c = new ArrayList<>();
        a = new ArrayList<>();
    }

    public ArrayList<Integer> as_continued_fraction()
    {
        int N = this.N, a, a0, _2a0, r, s;
        double x = this.x;
        this.a0 = a = a0 = (int)x;
        _2a0 = 2 * a0;
        r = 0;
        s = 1;
        if (this.c.size() != 0)
            this.c.clear();
        this.c.add(a0);
        if (N != a0*a0)
            while (a != _2a0)
            {
                r = a * s - r;
                s = (N - r*r) / s;
                a = (r + a0) / s;
                this.c.add(a);
            }
        return this.c;
    }

    int convergent_table(ArrayList<Integer> pq, int k, int k0)
    {
        if ((k < 0 && pq.get(pq.size() + k) != 0) || (k >= 0 && pq.get(k) != 0))
            return pq.get(k);
        if (k < 1)
        {
            if (k == 0)
                pq.set(k, (int)Math.pow(this.a.get(k), k0));
            return (k != 0) ? k0 : pq.get(k);
        }
        pq.set(k, this.a.get(k) * convergent_table(pq, k - 1, k0) + convergent_table(pq, k - 2, k0));
        return pq.get(k);
    }

    int iterative_convergent_table(int pq[], int k, int k0)
    {
        pq[0] = (int)Math.pow(this.a.get(0), k0);
        pq[1] = this.a.get(1) * pq[0] + k0;
        for (int i=2; i<=k; i++)
        {
            pq[2] = this.a.get(i) * pq[1] + pq[0];
            pq[0] = pq[1];
            pq[1] = pq[2];
        }
        return pq[(k<2) ? k : 2];
    }

    public int[] solve_pell_equation(boolean print_table, boolean trivial, char hv, char nondefault)
    {
        int arr[] = new int[2], i;
        if (this.c.size() == 0)
            as_continued_fraction();
        int m = this.c.size() - 1;
        if (m == 0)
        {
            if (print_table)
                System.out.printf("Error: %d is a perfect square.\n", this.N);
            arr[0] = (trivial) ? 1 : this.a0;
            arr[1] = (trivial) ? 0 : 1;
            return arr;
        }
        if (m % 2 == 0)
            for (i = 0; i < m; i++)
                this.a.add(this.c.get(i));
        else
        {
            this.a.addAll(this.c);
            for (i = 1; i < m; i++)
                this.a.add(this.c.get(i));
        }
        int k = this.a.size(), x, y;
        if (!print_table || k >= this.recursionlimit)
        {
            int p[] = new int[3];
            int q[] = new int[3];
            for (i = 0; i < 3; i++)
            {
                p[i] = 0;
                q[i] = 0;
            }
            if (print_table)
                System.out.println("Error: Convergent table too large to display.");
            x = iterative_convergent_table(p, k - 1, 1);
            y = iterative_convergent_table(q, k - 1, 0);
        }
        else
        {
            ArrayList<Integer> p = new ArrayList<>(), q = new ArrayList<>();
            for (i = 0; i < k; i++)
            {
                p.add(0);
                q.add(0);
            }
            x = convergent_table(p, k - 1, 1);
            y = convergent_table(q, k - 1, 0);
            ArrayList<String> d = new ArrayList<>();
            d.add("k");
            d.add("a\u2096");
            d.add("p\u2096");
            d.add("q\u2096");
            if (hv == nondefault)
            {
                for (i = 0; i < 4; i++)
                {
                    System.out.print(d.get(i));
                    if (i != 3)
                        System.out.print("\t");
                }
                System.out.println();
                for (i = 0; i < k; i++)
                {
                    System.out.print(i);
                    System.out.print("\t");
                    System.out.print(this.a.get(i));
                    System.out.print("\t");
                    System.out.print(p.get(i));
                    System.out.print("\t");
                    System.out.println(q.get(i));
                }
            }
            else
            {
                System.out.print(d.get(0));
                for (i = 0; i < k; i++)
                {
                    System.out.print("\t");
                    System.out.print(i);
                }
                System.out.println();
                System.out.print(d.get(1));
                for (i = 0; i < k; i++)
                {
                    System.out.print("\t");
                    System.out.print(this.a.get(i));
                }
                System.out.println();
                System.out.print(d.get(2));
                for (i = 0; i < k; i++)
                {
                    System.out.print("\t");
                    System.out.print(p.get(i));
                }
                System.out.println();
                System.out.print(d.get(3));
                for (i = 0; i < k; i++)
                {
                    System.out.print("\t");
                    System.out.print(q.get(i));
                }
                System.out.println();
            }
        }
        arr[0] = x;
        arr[1] = y;
        return arr;
    }

    public int[] solve_pell_equation(boolean print_table, char hv, char nondefault)
    {
        return solve_pell_equation(print_table, this.trivial, hv, nondefault);
    }

    public int[] solve_pell_equation(boolean trivial)
    {
        return solve_pell_equation(this.print_table, trivial, this.hv, this.nondefault);
    }

    public int[] solve_pell_equation()
    {
        return solve_pell_equation(this.print_table, this.trivial, this.hv, this.nondefault);
    }

    public static char chr(String s)
    {
        return (s == "") ? '\0' : s.charAt(0);
    }

    public static void printArrayList(ArrayList<Integer> c)
    {
        int s = c.size(), i;
        System.out.print("[");
        for (i = 0; i < s; i++)
        {
            System.out.print(c.get(i));
            if (i != s - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String args[])
    {
        int x, arr[] = new int[2], x1 = 1, y1 = 0;
        sqrt calc, sqrtx;
        char yn, yn2, hv, yn3;
        ArrayList<Integer> c = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number :\t");
        x = Integer.parseInt(sc.nextLine());

        calc = sqrtx = new sqrt(x);

        System.out.println("\u221A"+x+" = "+sqrtx.x);
        System.out.print("Display as continued fraction? (y/n) :\t");
        yn = Character.toLowerCase(chr(sc.nextLine().trim()));
        if (yn == 'y')
        {
            c = calc.as_continued_fraction();
            System.out.print("\u221A"+x+" = ");
            printArrayList(c);
        }
        System.out.print("Display convergent table of \u221A"+x+"? (y/n) :\t");
        yn2 = Character.toLowerCase(chr(sc.nextLine().trim()));
        if (yn2 == 'y')
        {
            System.out.println("1. Display Horizontally (Default)");
            System.out.println("2. Display Vertically");
            System.out.print("Enter Your Choice :\t");
            hv = chr(sc.nextLine().trim());
            arr = calc.solve_pell_equation(true, hv, '2');
            x1 = arr[0];
            y1 = arr[1];
        }
        System.out.printf("Solve x² - %dy² = 1? (y/n) :\t", x);
        yn3 = Character.toLowerCase(chr(sc.nextLine().trim()));
        if (yn3 == 'y')
        {
            if (yn2 != 'y')
            {
                arr = calc.solve_pell_equation();
                x1 = arr[0];
                y1 = arr[1];
            }
            System.out.printf("x = %d\ny = %d\n", x1, y1);
        }
    }
}