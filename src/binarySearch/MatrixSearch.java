package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class MatrixSearch {
    public static void main(String[] args) {
        int b = 16;
        ArrayList<ArrayList<Integer>> a = getMatrix(10,4);
        for (ArrayList<Integer> integers : a) {
            System.out.println(integers.toString());
        }
        MatrixSearch matrixSearch = new MatrixSearch();
        System.out.println(matrixSearch.searchMatrix(a,b));
    }

    private int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int m = a.size();
        int n= a.get(0).size();
        for (int i = 0; i < m; i++) {
            int start = a.get(i).get(0);
            int end = a.get(i).get(n-1);
            if (start == b || end == b) return 1;
            if( start < b && end > b){
                return binarySearch(a.get(i),b);
            }
        }
        return 0;
    }

    private int binarySearch(List<Integer> a, int b) {
        if(a.size() == 0)
            return 0;
        int mid = a.size()/2;
        if(a.get(mid) == b) return 1;
        else {
            if(a.get(mid) > b){
                return binarySearch(a.subList(0,mid),b);
            }else if(a.get(mid) < b)
                return binarySearch(a.subList(mid+1,a.size()),b);
            else return 0;
        }
    }

    private static ArrayList<ArrayList<Integer>> getMatrix(int m, int n) {
        int[][] a= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(count++);
            }
            result.add(row);
        }
        return result;
    }
}
