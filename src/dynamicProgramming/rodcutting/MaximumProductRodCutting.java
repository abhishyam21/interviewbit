package dynamicProgramming.rodcutting;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/27/2017.
 */
public class MaximumProductRodCutting {
    public static void main(String[] args) {
        MaximumProductRodCutting rodCutting = new MaximumProductRodCutting();
        System.out.println(rodCutting.profit(15));
    }

    private int profit(int n) {
    int[] cache = new int[n+1];
        Arrays.fill(cache,1);
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                cache[i] = Math.max(cache[i-j]*j,cache[i]);
            }
        }
        System.out.println(Arrays.toString(cache));
        return cache[n];
    }
}
