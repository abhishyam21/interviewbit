package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Rachana Rao on 8/22/2016.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        ArrayList<ArrayList<Integer>> a = getarray();
        rotateMatrix.rotate(a);
        for (ArrayList<Integer> integers : a) {
            System.out.print(Arrays.toString(integers.toArray()) + " ");
            System.out.println();
        }
    }

    private void rotate(ArrayList<ArrayList<Integer>> a) {
        int m= a.size();
        int n= a.get(0).size();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = (m-1); j >-1; j--) {
                temp.add(a.get(j).get(i));
            }
            a.add(temp);
        }

        int count =0;
        for (ListIterator<ArrayList<Integer>> iterator = a.listIterator();iterator.hasNext();){
            ArrayList<Integer> temp = iterator.next();
            if(count<m)
                iterator.remove();
            count++;
        }
    }


        private static ArrayList<ArrayList<Integer>> getarray() {
            int count = 1;
            int m = 4, n = 3;
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
            for (int i = 0; i < m; i++) {
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
    }


/*
 int row = a.get(0).size()-1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i <=row; i++) {
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = row; j >=0 ; j--) {
                line.add(a.get(j).get(i));
            }
            result.add(line);
        }
        a=result;
 */

/*

 */