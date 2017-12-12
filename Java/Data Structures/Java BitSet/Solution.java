import java.io.*;
import java.util.*;
import java.util.function.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int numOfOps = scanner.nextInt();
      
        BitSet[] bitSets = new BitSet[] {new BitSet(dimension), new BitSet(dimension)};
        
        Map<String, BiConsumer<Integer, Integer>> ops = new HashMap<>();
        ops.put("AND", (index1, index2) -> bitSets[index1 - 1].and(bitSets[index2 - 1]));
        ops.put("OR", (index1, index2) -> bitSets[index1 - 1].or(bitSets[index2 - 1]));
        ops.put("XOR", (index1, index2) -> bitSets[index1 - 1].xor(bitSets[index2 - 1]));
        ops.put("SET", (index1, index2) -> bitSets[index1 - 1].set(index2));
        ops.put("FLIP", (index1, index2) -> bitSets[index1 - 1].flip(index2));
        
        for(int i = 0; i < numOfOps; i++) {
            ops.get(scanner.next()).accept(scanner.nextInt(), scanner.nextInt());
            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
        }
    }
}