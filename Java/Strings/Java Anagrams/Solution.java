import java.io.*;
import java.util.*;

public class Solution {
	    static boolean isAnagram(String a, String b) {
        if(a == null || b == null || a.equals("") || b.equals(""))
            throw new IllegalArgumentException("The strings shouldn't be null or empty.");

        if(a.length() != b.length())
            return false;

        a = a.toLowerCase().trim();
        b = b.toLowerCase().trim();

        Map<Character, Integer> occurrencesMap = new HashMap();
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);

            if(occurrencesMap.containsKey(c)){
                int frequency = occurrencesMap.get(c);
                occurrencesMap.put(c, ++frequency);
            }
            else {
                occurrencesMap.put(c, 1);
            }
        }

        for(int i = 0; i < b.length(); i++){
            char c = b.charAt(i);

            if(!occurrencesMap.containsKey(c))
                return false;

            Integer frequency = occurrencesMap.get(c);

            if(frequency == 0)
                return false;
            else
                occurrencesMap.put(c, --frequency);
        }

        return true;
    }
	public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}