package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhishyam.c on 2/20/2017.
 */
public class UniquePathsInAGrid {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = getMatrix();
        UniquePathsInAGrid  uniquePathsInAGrid = new UniquePathsInAGrid();
        System.out.println(uniquePathsInAGrid.uniquePathsWithObstacles(a));
    }

    private int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
        //if starting value of the matrix is zero
        if(a.get(0).get(0) == 1) return 0;
        int m=a.size();
        int n=a.get(0).size();
        //if the end position m*n is zero
        if(a.get(m-1).get(n-1) ==1) return 0;
        int[][] cache = new int[m][n];
        cache[0][0] = 1;
        for (int i = 1; i < n; i++) {
             if(a.get(0).get(i) == 1)
                 break;
                cache[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            if(a.get(i).get(0) == 1) break;
                cache[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(a.get(i).get(j) !=1)
                cache[i][j] = cache[i-1][j]+cache[i][j-1];
            }
        }
     //  print(cache);
        return cache[m-1][n-1];
    }

    private void print(int[][] cache) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                System.out.print(cache[i][j]+"  ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> getMatrix() {
        /*Integer[] temp1 = {0,0,0,0,0,0};
        Integer[] temp2 = {0,0,0,1,0,0};
        Integer[] temp3 = {0,0,0,0,0,0};
        Integer[] temp4 = {0,0,0,0,0,0};*/
        Integer[] temp1 = {0,0};
        Integer[] temp2 = {0,0};
        Integer[] temp3 = {0,0};
        Integer[] temp4 = {1,0};
        Integer[] temp5 = {0,0};
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(temp1));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(temp2));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(temp3));
        ArrayList<Integer> four = new ArrayList<>(Arrays.asList(temp4));
        ArrayList<Integer> five = new ArrayList<>(Arrays.asList(temp5));
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(one);
        a.add(two);
        a.add(three);
        a.add(four);
        a.add(five);
        return a;
    }
}
