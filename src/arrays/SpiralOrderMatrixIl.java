package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 8/21/2016.
 */
public class SpiralOrderMatrixIl {
    public static void main(String[] args) {
        int a=5;
        SpiralOrderMatrixIl spiralOrderMatrixIl = new SpiralOrderMatrixIl();
        ArrayList<ArrayList<Integer>> result = spiralOrderMatrixIl.generateMatrix(a);
        for (ArrayList<Integer> integers : result) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    private ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[][]  temp = new int[a][a];
        int count =1;
        for (int i=0;i<a;i++){
            int j=i;
            for (; j < (a-i); j++) {
                temp[i][j] = count++;
            }
            if(isCompleted(count,a)){
                break;
            }
            j--;
            int k=i+1;
            for (;k<(a-i-1);k++){
                temp[k][j] = count++;
            }
            int l = j,m=j-1;
            for (;l>=i;l--){
                temp[j][l] = count++;
            }
            for (;m>i;m--){
                temp[m][i] = count++;
            }
        }
        for (int i = 0; i < a; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < a; j++) {
                row.add(temp[i][j]);
            }
            result.add(row);
        }
        return result;
    }

    private boolean isCompleted(int count, int a) {
        return count>(a*a);
    }
}
