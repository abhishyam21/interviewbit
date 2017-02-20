package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/20/2017.
 */
public class CoinSumInfinite {
    public static void main(String[] args) {
        int N = 4;
        ArrayList<Integer> S = new ArrayList<>(Arrays.asList(1,2,3));
        CoinSumInfinite coinSumInfinite = new CoinSumInfinite();
        System.out.println(coinSumInfinite.coinSum(N,S));
    }

    private int coinSum(int n, ArrayList<Integer> s) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        for (int i = 0; i <s.size() ; i++) {
            for (int j = s.get(i); j <=n ; j++) {
                cache[j]+=cache[j-s.get(i)];
                if(cache[j] > 1000007){
                    cache[j]%=1000007;
                }
            }
        }
        return cache[n]%1000007;
    }
}
