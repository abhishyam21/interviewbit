package binarySearch;

import java.util.ArrayList;

public class PrintMatrixInDiagonalForm {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = getMatrix(4,7);
        for (ArrayList<Integer> list : a) {
            System.out.println(list.toString());
        }
        System.out.println("-------------------------------------------------------------------------------------");
        int count = -1;
        int m = a.size()-1;
        int n = a.get(0).size();
        for (int i = 0; i < n; i++) {
            count++;
             for (int j = 0;j<=count;j++) {
                System.out.print(a.get(j).get(i-j)+"\t");
            }
            if(count == m)
                break;
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> getMatrix(int m, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++)
                row.add(count++);
            result.add(row);
        }
        return result;
    }
}
