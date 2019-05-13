import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    private static final int BIRD_TYPES_TOTAL_COUNT = 5;

    // O(n) - space complexity
    static int migratoryBirds(List<Integer> arr) {
        int[] birdCounts = new int[BIRD_TYPES_TOTAL_COUNT + 1];
        
        for (Integer bird : arr) {
            birdCounts[bird]++;
        }

        int mostFrequentBirdCount = 0;
        int mostFrequentBirdId = 0;
        for (int i = 0; i < birdCounts.length; i++) {
            if (birdCounts[i] > mostFrequentBirdCount) {
                mostFrequentBirdCount = birdCounts[i];
                mostFrequentBirdId = i;
            }
        }
        return mostFrequentBirdId;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
