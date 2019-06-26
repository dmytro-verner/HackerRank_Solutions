import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Solution {

    //O(n) - time complexity
    //O(k) - space complexity
    static int nonDivisibleSubset(int k, int[] nums) {
        int[] remaindersCount = new int[k];
        for (int n : nums) {
            remaindersCount[n % k]++;
        }
        int maxSubsetElementsCount = remaindersCount[0] > 0 ? 1 : 0;
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i)
                maxSubsetElementsCount += Math.max(remaindersCount[i],
                                                   remaindersCount[k - i]);
            else
                maxSubsetElementsCount++;
        }
        return maxSubsetElementsCount;
    }

    static class Pair<T> {
        private T x1;
        private T x2;
        public Pair(T x1, T x2) {
            this.x1 = x1;
            this.x2 = x2;
        } 
        public List<T> getBoth() {
            return Arrays.asList(x1, x2);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
