import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            int a = scan.nextInt();
            int b = scan.nextInt();
            System.out.println(a / b);
        } catch(ArithmeticException e){
            System.out.println(e);
        }
        catch(InputMismatchException e){
           System.out.println(e.getClass().getName());
        }
        
    }
}