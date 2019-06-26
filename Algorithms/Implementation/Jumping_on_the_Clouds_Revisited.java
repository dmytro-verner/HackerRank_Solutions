import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int jumpingOnClouds(int[] clouds, int jumpDistance) {
        int cloud = 0;
        int energy = 100;
        do {
            if (clouds[cloud] == 1) {
                energy -= 2;
            }
            cloud = getNextCloudIndex(clouds.length, cloud, jumpDistance);
            energy -= 1;
        } while (cloud != 0);
        return energy;
    }

    private static int getNextCloudIndex(int length, int startCloudIndex, int jumpDistance) {
        return (startCloudIndex + jumpDistance) % length;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
