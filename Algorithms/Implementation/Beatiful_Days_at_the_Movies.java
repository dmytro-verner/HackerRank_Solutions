import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //O(endingNumber-startingNumber) - time complexity
    static int beautifulDays(int startingNumber, int endingNumber, int divisor) {
        int beautifulDaysCount = 0;
        for (int c = startingNumber; c <= endingNumber; c++) {
            int reversedNumber = reverseNumber(c);
            if (Math.abs(c - reversedNumber) % divisor == 0)
                beautifulDaysCount++;
        }
        return beautifulDaysCount;
    }

    private static int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            reversedNumber *= 10;
            reversedNumber += number % 10;
            number /= 10;
        }
        return reversedNumber;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
