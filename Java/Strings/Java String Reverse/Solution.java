import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        char[] reversed = new char[A.length()];
        for(int i = A.length() - 1, j = 0; i >= 0 ; i--, j++){
            reversed[j] = A.charAt(i);
        }
        
        String reversedStr = new String(reversed);
        
        if(A.equals(reversedStr))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
