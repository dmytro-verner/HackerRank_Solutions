import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //O(n) - time complexity
    static int viralAdvertising(int day) {
        int sharedCount = 5;
        int totalLikes = 0;
        int sharesWithFriendsPerLike = 3;
        while (day-- > 0) {
            int currentDayLikes = sharedCount / 2;
            totalLikes += currentDayLikes;
            sharedCount = currentDayLikes * sharesWithFriendsPerLike;
        }
        return totalLikes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
