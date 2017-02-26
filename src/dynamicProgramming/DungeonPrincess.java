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

    private static ArrayList<ArrayList<Integer>> getMatrix() {
        Integer[] temp1 = {-2, -3, 3};
        Integer[] temp2 = {-5, -10, 1};
        Integer[] temp3 = {10, 30, -5};
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(temp1));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(temp2));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(temp3));
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(one);
        a.add(two);
        a.add(three);
        return a;
    }

    private int getMinHealth(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] cache = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int num = a.get(i).get(j);
                if (i == m - 1 && j == n - 1) {
                    if (num > 0) {
                        cache[i][j] = 1;
                    } else
                        cache[i][j] = 1 - num;
                } else if (i == m - 1) {
                    cache[i][j] = Math.max(1, cache[i][j + 1] - num);
                } else if (j == n-1) {
                    cache[i][j] = Math.max(1, cache[i + 1][j] - num);
                } else {
                    cache[i][j] = Math.max(1, Math.min(cache[i + 1][j], cache[i][j + 1]) - num);
                }
            }
        }
        print(cache);
        return cache[0][0];
    }

    private void print(int[][] cache) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                System.out.print(cache[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
