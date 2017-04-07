package dynamicProgramming.outsideproblems;

import java.util.Arrays;

/**
 * Problem Link:
 * https://www.techiedelight.com/partition-problem/
 * Created by Rachana Rao on 4/4/2017.
 */
public class PartitionProblem {
    private static boolean[][] cache;
    public static void main(String[] args) {
        int arr[] = { 1, 5, 3 };
        if(partition(arr))
            System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean partition(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        sum/=2;
        int n = arr.length;
        cache = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            cache[i][0] = true;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=sum ; j++) {
                if(j < arr[i-1])
                    cache[i][j] = cache[i-1][j];
                else
                    cache[i][j] = cache[i-1][j] || cache[i-1][j-arr[i-1]];
            }
        }
        for (boolean[] booleans : cache) {
            System.out.println(Arrays.toString(booleans));
        }

        return cache[n][sum] && (Arrays.stream(arr).sum()%2 == 0);
    }
}
