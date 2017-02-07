package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/7/2017.
 */
public class MinSumPathInTriangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = getMatrix();
        MinSumPathInTriangle minSumPathInTriangle = new MinSumPathInTriangle();
        System.out.println(minSumPathInTriangle.minimumTotal(a));
    }

    private int minimumTotal(ArrayList<ArrayList<Integer>> a) {

        int m, n;
        m = a.size();
        n = a.get(m - 1).size();
        int [] dp = new int[n + 1];
        int size = n;

        for (int i = m - 1; i >= 0; i--) {

            for (int j = 0; j < size; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + a.get(i).get(j);
            }

            size--;
        }

        return dp[0];
    }

    private static ArrayList<ArrayList<Integer>> getMatrix() {
        Integer[] temp1 = {2};
        Integer[] temp2 = {3,4};
        Integer[] temp3 = {6,5,7};
        Integer[] temp4 = {4,1,8,3};
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(temp1));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(temp2));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(temp3));
        ArrayList<Integer> four = new ArrayList<>(Arrays.asList(temp4));
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(one);
        a.add(two);
        a.add(three);
        a.add(four);
        return a;
    }
}
