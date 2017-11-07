import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String timeConversion(String s) {
        String[] tAttrs = s.split(":");
        int hh = Integer.parseInt(tAttrs[0]);
        int mm = Integer.parseInt(tAttrs[1]);
        int ss = Integer.parseInt(tAttrs[2].substring(0, 2));
        String amPm = tAttrs[2].substring(2, 4);
        
        int h = hh;
        String checkPM = "PM", checkAM = "AM";
        
        if(amPm.equals(checkAM) && hh == 12)
            h = 0;
        else if(amPm.equals(checkPM) && hh < 12)
            h += 12;
        
        return String.format("%02d:%02d:%02d",h,mm,ss);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}