package dynamicProgramming.outsideproblems;

import java.util.Arrays;

/**
 * Problem Link:
 * https://www.techiedelight.com/0-1-knapsack-problem/
 * Created by Rachana Rao on 4/4/2017.
 */
public class Knapsackproblem {
    private static int[][] cache;

    public static void main(String[] args) {
       /* int val[] = new int[]{3,1,3,4,3,1};
        int wt[] = new int[]{2,2,1,3,5,2};
        int W = 8;*/
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        printValues(wt, val);
    }

    /**
     * This method will find the result with
     * more value with weight less than or equal
     * to given weight
     *
     * @param w   given weight
     * @param wt  arrays of weights
     * @param val array of values
     * @param n   length of the array
     * @return max value we can obtain
     */
    private static int knapSack(int w, int[] wt, int[] val, int n) {
        cache = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < wt[i - 1]) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], (cache[i - 1][j - wt[i - 1]]) + val[i - 1]);
                }
            }
        }
        for (int[] aCache : cache) {
            System.out.println(Arrays.toString(aCache));
        }
        return cache[n][w];
    }

    private static void printValues(int[] wt, int[] val) {
        int m = cache.length - 1;
        int n = cache[0].length - 1;
        util(wt, val, m, n);
    }

    private static void util(int[] wt, int[] val, int m, int n) {
        if (m <= 0 || n <= 0) return;
        if ((cache[m][n] != cache[m - 1][n]) && (cache[m][n] != cache[m][n - 1])) {
            System.out.println(val[m - 1] + "-->" + wt[m - 1]);
            util(wt, val, m-1, (n - wt[m - 1] + 1));
        } else if (cache[m][n] == cache[m - 1][n]) {
            util(wt, val, m - 1, n);
        } else if (cache[m][n] == cache[m][n - 1])
            util(wt, val, m, n - 1);
        else
            util(wt, val, m-1, (n - val[m - 1]));
    }
}
