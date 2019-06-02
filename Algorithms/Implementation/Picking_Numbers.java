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

class Result {

    public static int pickingNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        int lastOneValueAwayNumber = numbers.get(0);
        int currentOneValueAwayCount = 1;
        int maxOneAwayCount = 1;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) - lastOneValueAwayNumber <= 1) {
                currentOneValueAwayCount++;
            }
            else {
                maxOneAwayCount = currentOneValueAwayCount > maxOneAwayCount ? currentOneValueAwayCount : maxOneAwayCount;
                currentOneValueAwayCount = 1;
                lastOneValueAwayNumber = numbers.get(i);
            }
        }
        return maxOneAwayCount > currentOneValueAwayCount ? maxOneAwayCount : currentOneValueAwayCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
