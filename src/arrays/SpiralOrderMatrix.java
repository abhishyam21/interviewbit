package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 7/26/2016.
 */
public class SpiralOrderMatrix {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> a = getMatrix(2,3);
        for (ArrayList<Integer> integers : a) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
        System.out.println("-----------------------------------------------------------");
        SpiralOrderMatrix spiralOrderMatrix = new SpiralOrderMatrix();
        System.out.println(spiralOrderMatrix.spiralOrder(a).toString());
    }

    private ArrayList<Integer> spiralOrder(List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = a.size()-1;

        int columnStart = 0;
        int columnEnd = a.get(0).size()-1;
        while (rowStart<=rowEnd && columnStart<=columnEnd) {
            for (int i = columnStart; i <= columnEnd; i++) {
                result.add(a.get(rowStart).get(i));
            }
            rowStart++;
            for (int i = rowStart; i <=rowEnd; i++) {
                result.add(a.get(i).get(columnEnd));
            }
            --columnEnd;
            if(rowStart<=rowEnd) {
                for (int i = columnEnd; i >= columnStart; i--) {
                    result.add(a.get(rowEnd).get(i));
                }
                --rowEnd;
            }
            if(columnStart<=columnEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(a.get(i).get(columnStart));
                }
                ++columnStart;
            }

        }
        return result;
    }
    private static ArrayList<ArrayList<Integer>> getMatrix(int m, int n) {
        ArrayList<ArrayList<Integer>> a  = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(count++);
            }
            a.add(row);
        }
        return a;
    }
}

/**
 if(a.size()==1){
 return a.get(0);
 }else if(a.get(0).size() ==1){
 for (ArrayList<Integer> integers : a) {
 result.add(integers.get(0));
 }
 return result;
 }

 int m=a.size();
 int n= a.get(0).size();
 int i=0,j=0,l=0,d=0,r=0,u=0;
 while (true) {
 for (l = i; l < (n - j); l++) {
 result.add(a.get(i).get(l));
 }
 l--;
 for (d = i + 1; d < (m - j); d++) {
 result.add(a.get(d).get(l));
 }
 l--;d--;
 for (r = l; r > (j); r--){
 result.add(a.get(d).get(r));
 }
 for (u=d;u>i;u--)
 result.add(a.get(u).get(r));
 i++;j++;
 if(result.size() == a.size()*a.get(0).size()){
 break;
 }
 }
 return result;


 int m=a.size();
 int n= a.get(0).size();
 int s=0,e=n-1,de=m-2;

 int i=0,d=0;
 while (s<m && e <n) {
 for (i=s;i<=e;i++){
 result.add(a.get(s).get(i));
 }
 for (d=s+1;d<=de;d++){
 result.add(a.get(d).get(e));
 }
 for (i= e; i>=s;i--){
 result.add(a.get(de+1).get(i));
 }
 for (d--;d>s+1;d--){
 result.add(a.get(d).get(s));
 }
 /*
 if(result.size() == (a.size()*a.get(0).size()))
 break;
 */
