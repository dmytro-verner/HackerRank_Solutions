import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.function.IntPredicate;

public class Solution {

    //O(1) - time complexity
    static long repeatedString(String str, long n) {
        IntPredicate isA = c -> (c == 'a');
        long wholeWordRepeats = n / str.length();
        long leftCharsCount = n % str.length();
        long countInWholeWord = str.chars()
                              .filter(isA)
                              .count();
        long countInTruncatedWord = str.chars()
                                       .limit(leftCharsCount)
                                       .filter(isA)
                                       .count();
        return (wholeWordRepeats * countInWholeWord) + countInTruncatedWord;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
