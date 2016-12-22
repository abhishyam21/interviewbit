package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 8/21/2016.
 */
public class PascalTriangleRows {
    public static void main(String[] args) {
        int a =5;
        PascalTriangleRows pascalTriangleRows = new PascalTriangleRows();
        ArrayList<ArrayList<Integer>> result = pascalTriangleRows.generate(a);
        for (ArrayList<Integer> integers : result) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    private ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a==0)
            return result;
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        for (int i = 1; i <a ; i++) {
                ArrayList<Integer> row = new ArrayList<>();
            int j=1;
            row.add(1);
            ArrayList<Integer> prevRow = null;
            if(i!=1)
             prevRow = result.get(i-1);
            for(;j<i;j++){
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            row.add(j,1);
            result.add(row);
        }
        return result;
    }
}
