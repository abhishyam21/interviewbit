package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class give all the permutations of the strings in
 * the lexicographical order
 * Created by Rachana Rao on 1/26/2017.
 */
public class LexicographicalPermutations {
    public static void main(String[] args) {
        String s = "abc";
        char[] str = s.toCharArray();
        ArrayList<Integer> counts = new ArrayList<>(Arrays.asList(1,1,1));
        printPermutations(str,new ArrayList<>(str.length), counts,0 );
    }

    private static void printPermutations(char[] str, ArrayList<String> results, ArrayList<Integer> counts , int level) {
        if(level == str.length){
            System.out.println(results.toString());
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if(counts.get(i) > 0){
                results.add(str[i]+"");
                counts.set(i,counts.get(i)-1);
                printPermutations(str,results,counts,level+1);
                counts.set(i,counts.get(i)+1);
                results.remove(results.size()-1);
            }
        }
    }

}
