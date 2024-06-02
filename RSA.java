import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class RSA {
    private BigInteger n, e, d;
    private SecureRandom random = new SecureRandom();
    private int bitlen = 2048;

    public RSA() {
        generateKeys();
    }

    private void generateKeys() {
        BigInteger p = BigInteger.probablePrime(bitlen / 2, random);
        BigInteger q = BigInteger.probablePrime(bitlen / 2, random);
        n = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.valueOf(65537); // Common choice for e
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public String encrypt(String message) {
        BigInteger plaintext = new BigInteger(message.getBytes(StandardCharsets.UTF_8));
        BigInteger ciphertext = plaintext.modPow(e, n);
        return ciphertext.toString(16); // Convert to hexadecimal string
    }

    public String decrypt(String encrypted) {
        BigInteger ciphertext = new BigInteger(encrypted, 16); // Convert back from hexadecimal string
        BigInteger plaintext = ciphertext.modPow(d, n);
        return new String(plaintext.toByteArray(), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a message to encrypt:");
        String message = scanner.nextLine();

        String encryptedMessage = rsa.encrypt(message);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = rsa.decrypt(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}