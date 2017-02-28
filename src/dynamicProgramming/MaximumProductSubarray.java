package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Rachana Rao on 2/27/2017.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray subarray = new MaximumProductSubarray();
        //Integer[] temp = {-2,-3,-1,4};
        Integer[] temp = {-4, 0, -5, 0 };
        //Integer[] temp = {6, -3, -10, 0, 2};
       // Integer[] temp = {-1, -3, -10, 0, 60};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        System.out.println(subarray.maxProduct1(a));
        System.out.println(subarray.maxProduct(a));
    }

    private int maxProduct(List<Integer> a) {
        int n = a.size();
        if(n == 0) return 0;
        if(n ==1) return a.get(0);

        int result = 0;
        int max = 1;
        int min = 1;
        for (int i = 0; i < n; i++) {
            Integer num = a.get(i);
            if(num < 0){
                int temp = max;
                max = Math.max(min*num,1);
                min = temp * num;
          }else if(num == 0){
                max = 1;
                min = 1;
            }
          else {
                max=Math.max(num*max,num);
                min = Math.min(min*num,num);
            }
            if(max != 1)
            result = Math.max(max,result);
        }
        //print(cache);
        return result;
    }

    /**
     * This method is of space complexity O(N*N)
     * where N is length of the array
     * @param a input list of numbers
     * @return maximum product
     */
    private int maxProduct1(final List<Integer> a) {
        int n = a.size();
        int[][] cache = new int[n][n];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                    if(i == j){
                        cache[i][j] = a.get(i);
                    }else {
                        cache[i][j] = cache[i][j-1]*a.get(j);
                    }
                    result = Math.max(result,cache[i][j]);
            }
        }
        //print(cache);
        return result;
    }

    private void print(int[][] cache) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                System.out.print(cache[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
