package arrays;

import java.util.*;

/**
 * Created by Rachana Rao on 9/11/2016.
 */
public class SetMatrixZeros {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = getMatrix(100,100);
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        setMatrixZeros.print(a);
        setMatrixZeros.setZeroes(a);
    }

    private void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m= a.size();
        int n= a.get(0).size();
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(a.get(i).get(j) ==0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int j = 0; j < n; j++) {
                a.get(row).set(j,0);
            }
        }

        for (Integer column : columns) {
            for (int i = 0; i < m; i++) {
                a.get(i).set(column,0);
            }
        }
    }

    private void makeRowColumnZero(ArrayList<ArrayList<Integer>> a, int i, int j, int m, int n) {
        if(i<m && j<n) {
            for (int k = 0; k < n; k++) {
                if (a.get(i).get(k) == 0) {
                    a.get(i).set(k, -1);
                    makeRowColumnZero(a, i, k, m, n);
                }
                a.get(i).set(k, -1);
            }
            for (int k = 0; k < m; k++) {
                if (a.get(k).get(j) == 0) {
                    a.get(k).set(j, -1);
                    makeRowColumnZero(a, k, j, m, n);
                }
                a.get(k).set(j, -1);
            }
        }
    }


    private static ArrayList<ArrayList<Integer>> getMatrix(int m, int n) {
        ArrayList<ArrayList<Integer>> a  = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(random.nextInt(2));
            }
            a.add(row);
        }
        return a;
    }

    private void print(ArrayList<ArrayList<Integer>> a){
        int m =a.size();
        int n = a.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a.get(i).get(j)+"\t");
            }
            System.out.println(" ");
        }
    }
}
