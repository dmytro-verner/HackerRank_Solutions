import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int listOfListsSize = scanner.nextInt();

        List<List<Integer>> listOfLists = new ArrayList<>(listOfListsSize);

        for(int i = 0; i < listOfListsSize; i++) {
            int listSize = scanner.nextInt();
            List<Integer> list = new ArrayList<>(listSize);
            for (int j = 0; j < listSize; j++) {
                list.add(scanner.nextInt());
            }
            listOfLists.add(list);
        }

        int queries = scanner.nextInt();
        for(int i = 0; i < queries; i++){
            int listIndex = scanner.nextInt();
            int innerListIndex = scanner.nextInt();

            if(listIndex > listOfLists.size() || innerListIndex > listOfLists.get(listIndex - 1 ).size())
                System.out.println("ERROR!");
            else {
                int result = listOfLists.get(listIndex - 1).get(innerListIndex - 1);
                System.out.println(result);
            }
        }
    }
}
