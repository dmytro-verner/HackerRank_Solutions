import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import static java.util.stream.Collectors.*;
import static java.util.Collections.singletonList;

public class Solution {

    //O(nm) - time complexity
    //O(n) - space complexity
    static int[] cutTheSticks(int[] arr) {
        List<Integer> sortedSticks = Arrays.stream(arr)
                                           .boxed()
                                           .sorted()
                                           .collect(toList());
        int distinctCount = (int) sortedSticks.stream().distinct().count();
        int[] resultArr = new int[distinctCount];
        for (int i = 0; i < distinctCount; i++) {
            int minStick = sortedSticks.get(0);

            resultArr[i] = (int) sortedSticks.stream()
                                       .count();

            sortedSticks.removeAll(singletonList(minStick));
            sortedSticks = sortedSticks.stream()
                                       .map(n -> n - minStick)
                                       .collect(toList());
        }
        return resultArr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
