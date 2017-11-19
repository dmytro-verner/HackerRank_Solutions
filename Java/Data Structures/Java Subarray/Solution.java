import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        int[] array = new int[n];
        
        for(int i = 0; i < array.length; i++){
            array[i] = scan.nextInt();
        }
        
        int count = 0;
        int sum   = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
              sum += array[j];
                if (sum < 0) {
                    count++;
             }
        }
        sum = 0;
    }
        
    System.out.println(count);
    }
}