package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 8/22/2016.
 */
public class AntiDiagonals {
    public static void main(String[] args) {
        AntiDiagonals antiDiagonals = new AntiDiagonals();
        ArrayList<ArrayList<Integer>> a = getarray();
            ArrayList<ArrayList<Integer>> result =  antiDiagonals.diagonal(a);
        for (ArrayList<Integer> integers : result) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    private static ArrayList<ArrayList<Integer>> getarray() {
        int n = 4,count=1;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(count++);
            }
            arrayLists.add(row);
        }
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(Arrays.toString(arrayList.toArray()));
        }
        System.out.println("----------------------------------");
        return arrayLists;
    }

    private ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            int row = a.get(0).size();
            for (int k=0;k<2;k++) {
                for (int i = k; i < row; i++) {
                    ArrayList<Integer> line = new ArrayList<>();
                    int m = i;
                    if(k==0) {
                        for (int j = 0; j <= i; j++) {
                            line.add(a.get(j).get(m--));

                        }
                    }else {
                        m=row-1;
                        for (int j = i; j < row; j++) {
                            line.add(a.get(j).get(m--));
                        }
                    }
                    result.add(line);
                }
            }
            return result;
    }
}
/*
ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int row = a.get(0).size();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> line = new ArrayList<>();
            int m=i;
            for (int j = 0; j <= i; j++) {
                    line.add(a.get(j).get(m--));

            }
            result.add(line);
        }
        for (int i = 1; i < row; i++) {
            ArrayList<Integer> line = new ArrayList<>();
            int m=row-1;
            for (int j = i; j < row; j++) {
                line.add(a.get(j).get(m--));
            }
            result.add(line);
        }
        return result;
 */