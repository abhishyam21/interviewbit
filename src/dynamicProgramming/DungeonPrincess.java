package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/25/2017.
 */
public class DungeonPrincess {
    public static void main(String[] args) {
        DungeonPrincess dungeonPrincess = new DungeonPrincess();
        ArrayList<ArrayList<Integer>> a = getMatrix();
        System.out.println(dungeonPrincess.getMinHealth(a));
    }

    private int getMinHealth(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                    if(i==0 && j==0){
                        cache[i][j] = Math.max(1,1-a.get(i).get(j));
                    }else if(i == 0){
                            cache[i][j] = Math.max(1,cache[i][j-1] -a.get(i).get(j));
                        }
                    else if(j ==0 ){
                        cache[i][j] = Math.max(1,cache[i-1][j]-a.get(i).get(j));
                    }else {
                        int up = cache[i-1][j]-a.get(i).get(j);
                        int side = cache[i][j-1]-a.get(i).get(j);
                            cache[i][j] = Math.max(1,Math.min(up,side));
                    }
            }
        }
        print(cache);
        return cache[m-1][n-1]+1;
    }

    private void print(int[][] cache) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                System.out.print(cache[i][j]+"  ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> getMatrix() {
        Integer[] temp1 = {-2,-3,3};
        Integer[] temp2 = {-5,-10,1};
        Integer[] temp3 = {10,30,-5};
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(temp1));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(temp2));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(temp3));
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(one);
        a.add(two);
        a.add(three);
        return a;
    }
}
