package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problem source: http://www.techiedelight.com/increasing-subsequence-with-maximum-sum/
 * Created by Rachana Rao on 2/14/2017.
 */
public class IncreasingSubsequencewithMaximumSum {
    public static void main(String[] args) {
        Integer[] temp = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        System.out.println(maxSum(a));
        printMaxSum(a);
    }

    /**
     * This method returns the max sum of increasing sub sequence
     * @param a list of number
     * @return max sum
     */
    private static int maxSum(List<Integer> a) {
        int max = 0;
        int n = a.size();
        int[] cache = new int[n];
        cache[0] = a.get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a.get(i) > a.get(j) && cache[i] < (cache[j]+a.get(i))){
                    cache[i] = cache[j]+a.get(i);
                }
            }
            max = Math.max(cache[i],max);
        }
        return max;
    }

    /**
     * This method prints list of elements which had formed the max sum
     * @param a list of numbers
     */
    private static void printMaxSum(List<Integer> a) {
        int max = 0;
        int n = a.size();
        int[] cache = new int[n];
        cache[0] = a.get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a.get(i) > a.get(j) && cache[i] < (cache[j]+a.get(i))){
                    cache[i] = cache[j]+a.get(i);
                }
            }
            max = Math.max(cache[i],max);
        }
        for (int i = cache.length - 1; i >= 0; i--) {
            if(max == cache[i] && max >0){
                System.out.print(a.get(i)+"  ");
                max-=a.get(i);
            }
        }
    }
}
