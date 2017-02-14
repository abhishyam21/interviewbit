package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 2/13/2017.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        //Integer[] temp = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        Integer[] temp = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        System.out.println(longestIncreasingSubsequence.lis(a));
        longestIncreasingSubsequence.printlis(a);
    }

    /**
     * This method just returns the max length of
     * increasing sub sequence
     * @param a ist of input values
     * @return longest increasing sub sequence
     */
    private int lis(List<Integer> a) {
        int max = 1;
        int n = a.size();
        int[] cache = new int[n];
        Arrays.fill(cache,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                        if(a.get(i) > a.get(j) && cache[i] <(cache[j]+1))
                            cache[i] = cache[j]+1;
            }
            max = Math.max(max,cache[i]);
        }
        return max;
    }

    private void printlis(List<Integer> a){
        int max = 1;
        int n = a.size();
        int[] cache = new int[n];
        Arrays.fill(cache,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a.get(i) > a.get(j) && cache[i] <(cache[j]+1))
                    cache[i] = cache[j]+1;
            }
            max = Math.max(max,cache[i]);
        }
        for (int i = cache.length - 1; i >= 0; i--) {
            if(cache[i] == max){
                System.out.print(a.get(i)+" ");
                max--;
            }
        }
        System.out.println();
    }
}
