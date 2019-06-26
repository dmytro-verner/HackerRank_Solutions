import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void extraLongFactorials(int n) {
        System.out.println(factorial(n));
    }

    private static BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            BigInteger mult = BigInteger.valueOf(i);
            factorial = factorial.multiply(mult);
        }
        return factorial;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
