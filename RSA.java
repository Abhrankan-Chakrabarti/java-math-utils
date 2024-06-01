import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {

    private BigInteger n, e, d; // (e,n) Public Key, (d,n) Private Key.

    public RSA() {
        int keySize = 256;
        BigInteger p = BigInteger.probablePrime(keySize, new Random());
        BigInteger q = BigInteger.probablePrime(keySize, new Random());
        n = p.multiply(q); //n = p*q

        BigInteger p2 = p.subtract(BigInteger.ONE); //p-1
        BigInteger q2 = q.subtract(BigInteger.ONE); //q-1
        BigInteger w = p2.multiply(q2); //(p-1).(q-1)

        this.e = new BigInteger(keySize + 1, new Random());
        while ((!this.e.gcd(w).equals(BigInteger.ONE)) || (this.e.compareTo(w) != -1)) {
            e = new BigInteger(keySize + 1, new Random());
            //e =  new BigInteger("65537");
        }

        d = e.modInverse(w);

        //System.out.println(" P : " + p);
        //System.out.println(" Q : " + q);
    }

    BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }
    public static BigInteger encrypt2(BigInteger message, BigInteger e2, BigInteger n2) {
        return message.modPow(e2, n2);
    }
    BigInteger decrypt(BigInteger encryptedMessage) {
        return encryptedMessage.modPow(d, n);
    }
    public static BigInteger decrypt2(BigInteger encryptedMessage, BigInteger d2, BigInteger n2) {
        return encryptedMessage.modPow(d2, n2);
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }

    public static void main(String args[]) {
        System.out.println("ENTER MESSAGE OR STRING TO ENCRYPT");
        String msg = new Scanner(System.in).nextLine();
        RSA rsa = new RSA();
        BigInteger m = BigInteger.ZERO, t = BigInteger.valueOf(1000);
        for (int i = 0, l = msg.length(); i < l; i++)
            m = m.multiply(t).add(BigInteger.valueOf(msg.charAt(i) + 100));
        m = rsa.encrypt(m);
        String enc = "";
        System.out.println("\nTHE ENCRYPTED MESSAGE IS");
        for (; !m.equals(BigInteger.ZERO); m = m.divide(t))
            enc = (char)(Integer.parseInt(m.mod(t).toString())) + enc;
        System.out.println(enc);
        for (int i = 0, l = enc.length(); i < l; i++)
            m = m.multiply(t).add(BigInteger.valueOf(enc.charAt(i)));
        m = rsa.decrypt(m);
        String dec = "";
        System.out.println("\nTHE DECRYPTED MESSAGE IS");
        for (; !m.equals(BigInteger.ZERO); m = m.divide(t))
            dec = (char)(Integer.parseInt(m.mod(t).toString()) - 100) + dec;
        System.out.println(dec);
    }
}