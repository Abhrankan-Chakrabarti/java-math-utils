import java.util.*;
import java.math.BigInteger;

class CatalanNumber {
    public int n = 0;
    public BigInteger C = BigInteger.ONE;

    public BigInteger next() {
        n++;
        C = C.multiply(BigInteger.valueOf(4 * n - 2)).divide(BigInteger.valueOf(n + 1));
        return C;
    }

    public static void main(String args[]) {
        System.out.println("This program finds the first n Catalan numbers.");
        System.out.print("Enter n :\t");
        try {
            int n = new Scanner(System.in).nextInt();
            for (CatalanNumber C = new CatalanNumber(); C.n < n; C.next())
                System.out.printf("Cat(%,d)\t=%, d\n", C.n, C.C);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer.");
        }
    }
}