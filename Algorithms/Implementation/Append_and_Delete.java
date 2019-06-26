import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //O(n) - time complexity
    static String appendAndDelete(String initialStr, String targetStr, int operations) {
        if (initialStr.length() + targetStr.length() <= operations) {
            return "Yes";
        }
        int i = 0;
        for (; i < Math.min(initialStr.length(), targetStr.length()); i++) {
            if (initialStr.charAt(i) != targetStr.charAt(i))
                break;
        }
        int minOperations = initialStr.length() - i + targetStr.length() - i;
        if (operations >= minOperations && (operations - minOperations) % 2 == 0)
            return "Yes";
        else 
            return "No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
