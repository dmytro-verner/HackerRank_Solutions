import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import static java.util.stream.IntStream.of;

public class Solution {

    //O(n + m) - time complexity
    //O(n + m) - space complexity
    static int[] climbingLeaderboard(int[] scoresInput, int[] aliceScores) {
        int[] scores = of(scoresInput).distinct().toArray();
        int[] aliceLeaderboardPositions = new int[aliceScores.length];
        int scoresIndex = scores.length - 1;
        int alicePositionIndex = 0;
        for (int aliceScore : aliceScores) {
            while (scoresIndex >= 0) {
                if (aliceScore >= scores[scoresIndex]) {
                    scoresIndex--;
                } else {
                    aliceLeaderboardPositions[alicePositionIndex++] = scoresIndex + 2;
                    break;
                }
            }
            if (scoresIndex < 0) {
                aliceLeaderboardPositions[alicePositionIndex++] = 1;
            }
        }

        return aliceLeaderboardPositions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

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
