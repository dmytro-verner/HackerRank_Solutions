import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        String[] combinations = new String[s.length() - k + 1];
        for(int i = 0; i < s.length() - k + 1; i++){
            combinations[i] = s.substring(i, k + i);
        }

        Arrays.sort(combinations);

        System.out.println(combinations[0]);
        System.out.println(combinations[combinations.length - 1]);

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
