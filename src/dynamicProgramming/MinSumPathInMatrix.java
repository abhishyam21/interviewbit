package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/5/2017.
 */
public class MinSumPathInMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = getMatrix();
        MinSumPathInMatrix minSumPathInMatrix = new MinSumPathInMatrix();
        System.out.println(minSumPathInMatrix.minPathSum(a));
    }

    private int minPathSum(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] result = new int[m][n];
        int prev = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j==0){
                    result[i][j] = a.get(i).get(j)+prev;
                    prev = result[i][j];
                }else {
                        int min = Math.min(result[i-1][j-1],Math.min(result[i-1][j],result[i][j-1]));
                        result[i][j] = min+a.get(i).get(j);
                }
            }
            prev = result[i][0];
        }
        return result[m-1][n-1];
    }

    private static ArrayList<ArrayList<Integer>> getMatrix() {
        Integer[] temp1 = {1,3,2,1,4,5};
        Integer[] temp2 = {4,6,3,2,1,2};
        Integer[] temp3 = {2,4,9,6,4,5};
        Integer[] temp4 = {3,1,8,7,4,2};
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
