import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      BigInteger a = in.nextBigInteger();
      in.close();

      if(a.isProbablePrime(5))
        System.out.println("prime");
      else
        System.out.println("not prime");
   }
}
