package dynamicProgramming.outsideproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Link:
 * https://www.techiedelight.com/counting-paths-on-grid-to-reach-destination-cell/
 * Created by Rachana Rao on 4/3/2017.
 */
public class TotalPathsInMatrixWithGivenSum {
    private static Map<String, Integer> cache = new HashMap<>();
    public static void main(String[] args) {
        int mat[][] =
        {
            { 4, 7, 1, 6 },
            { 5, 7, 3, 9 },
            { 3, 2, 1, 2 },
            { 7, 1, 6, 3 }
        };
        int cost = 25;
        int m = mat.length-1;
        int n = mat[0].length-1;
        System.out.println("Total Paths With Count "+cost+": "+getTotalCount(mat,m,n,cost));
        System.out.println("Total Paths With Count "+cost+": "+getTotalCountWithDP(mat,m,n,cost));
    }

    private static int getTotalCountWithDP(int[][] mat, int m, int n, int cost) {
        if( cost <0) return 0;
        if( m==0 && n == 0)
            return (cost-mat[m][n] ==0)? 1:0;
        String key = m+"-"+n+"-"+cost;
        if(!cache.containsKey(key)){
            if(m ==0)
                cache.put(key,getTotalCountWithDP(mat,m,n-1,cost-mat[m][n]));
            else if(n ==0)
                cache.put(key,getTotalCountWithDP(mat,m-1,n,cost-mat[m][n]));
            else
                cache.put(key,getTotalCountWithDP(mat,m,n-1,cost-mat[m][n])+
                getTotalCountWithDP(mat,m-1,n,cost-mat[m][n]));

        }
        return cache.get(key);
    }

    /**
     * This is recursive approach with
     * No Optimization. The time complexity is
     * in exponential form
     * @param mat matrix
     * @param m no:of rows
     * @param n no:of columns
     * @param cost total cost of the path
     * @return no:of paths with given cost
     */
    private static int getTotalCount(int[][] mat, int m, int n, int cost) {
        if(cost < 0) return 0;

        if(m==0 && n == 0){
            if(cost-mat[m][n] ==0)
                return 1;
            else return 0;
        }
        if(m == 0){
            return getTotalCount(mat,m,n-1,cost-mat[m][n]);
        }
        if(n ==0){
            return getTotalCount(mat,m-1,n,cost-mat[m][n]);
        }

        return getTotalCount(mat,m-1,n,cost-mat[m][n])+
                getTotalCount(mat,m,n-1,cost-mat[m][n]);
    }
}
