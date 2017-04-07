package dynamicProgramming.rodcutting;

import java.util.Arrays;

/**
 * This problem is not from InterviewBit.
 * Problem source
 * http://www.techiedelight.com/rot-cutting/
 * Created by Rachana Rao on 2/27/2017.
 */
public class RodCuttingi {
    public static void main(String[] args) {
        RodCuttingi rodCutting = new RodCuttingi();

       int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        for (int i = 0; i < price.length; i++) {
            System.out.println(i+1+"=="+rodCutting.profit(i+1, price));
        }
    }

    private int profit(int n, int[] price) {
        int[] cache = new int[n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                cache[i] = Math.max(price[j-1]+cache[i-j], cache[i]);
            }
        }
     print(cache);
        return cache[n];
    }

    private void print(int[] cache) {
        System.out.println(Arrays.toString(cache));
    }
}
