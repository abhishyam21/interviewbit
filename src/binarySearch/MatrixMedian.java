package binarySearch;

import java.util.*;

public class MatrixMedian {
    public static void main(String[] args) {
        //ArrayList<ArrayList<Integer>> a = getMatrix(7,1);
      /*  ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        Integer[] temp = {1, 1, 3, 3, 3};
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(temp));
        a.add(a1);
      */
      ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(2);
        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(1);
        ArrayList<Integer> temp3= new ArrayList<>();
        temp3.add(4);
        ArrayList<Integer> temp4 = new ArrayList<>();
        temp4.add(1);
        ArrayList<Integer> temp5 = new ArrayList<>();
        temp5.add(2);
        ArrayList<Integer> temp6 = new ArrayList<>();
        temp6.add(2);
        ArrayList<Integer> temp7 = new ArrayList<>();
        temp7.add(5);
        a.add(temp1);
        a.add(temp2);
        a.add(temp3);
        a.add(temp4);
        a.add(temp5);
        a.add(temp6);
        a.add(temp7);

      for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).toString());
        }
        MatrixMedian matrixMedian = new MatrixMedian();
        System.out.println(matrixMedian.findMedian(a));
    }

    private int findMedian(ArrayList<ArrayList<Integer>> A) {
      int m = A.size();
        int n = A.get(0).size();
        int product = m*n;
        int median = (product/2)+1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               int result = getElementsCountLessThanParameter(A.get(i).get(j),A);
                if(result == median)
                    return A.get(i).get(j);
            }
        }
        return -1;
    }

    private int getElementsCountLessThanParameter(Integer number, ArrayList<ArrayList<Integer>> a) {
        int result = 0;
        for (ArrayList<Integer> anA : a) {
            result += binarySearch(number, anA);
        }
        return result;
    }

    /**
     * The purpose of this method is to get the total number of numbers less
     * than provided number as method argument.
     * @param number
     * @param a
     * @return
     */
    private int binarySearch(Integer b, ArrayList<Integer> a) {
        int start = 0;
        int end = a.size()-1;
        while (start <=end){
            int mid = (start+end)/2;
            if(Objects.equals(a.get(mid), b))
                return mid+1;
            else {
                if(a.get(mid) < b){
                    start=mid+1;
                }else if(a.get(mid) > b){
                    start= 0;
                    end = mid-1;
                }else return mid;
            }
        }
        return start;
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
/*
{
        int n = a.size();
        int start = 0;
        int end = n-1;
        int mid = 0;
        while (start<=end){
            mid = (start+end)/2;
            int next = (mid+1)%n;
            if(a.get(mid) <= number && (a.get(next)>= number))
                return mid+1;
            else {
                if(a.get(mid) > number){
                    end = mid-1;
                }else if(a.get(mid) < number)
                    start = mid+1;
            }
        }
        return mid+1;
    }
 */