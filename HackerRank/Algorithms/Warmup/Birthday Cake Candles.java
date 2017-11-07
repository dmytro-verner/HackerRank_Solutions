import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int tallestCandle = 1;
        int count = 0;
        
        int n = in.nextInt();
        int[] ar = new int[n];
        
        for(int i : ar){
            ar[i] = in.nextInt();
            
            if(tallestCandle < ar[i]){
                tallestCandle = ar[i];
                count = 1;
            }
            else if(tallestCandle == ar[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}