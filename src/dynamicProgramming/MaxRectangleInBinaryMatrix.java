package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by abhishyam.c on 2/6/2017.
 */
public class MaxRectangleInBinaryMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = getMatrix();
        MaxRectangleInBinaryMatrix maxRectangleInBinaryMatrix = new MaxRectangleInBinaryMatrix();
        System.out.println(maxRectangleInBinaryMatrix.maximalRectangle(a));
    }

    private int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n= a.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(a.get(0).get(i));
        }
        int maxArea = maxAreaInHist(result);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = a.get(i).get(j);
                if(val == 0) result.set(j,0);
                else result.set(j,result.get(j)+val);
            }
            maxArea = Math.max(maxArea,maxAreaInHist(result));
        }
        return maxArea;
    }

    private int maxAreaInHist(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        int top = 0;
        int i=0,n=a.size();
        while (i<n){
            if(stack.isEmpty() || a.get(stack.peek()) <=a.get(i)){
                stack.push(i++);
            }else {
                top = stack.pop();
                //calculate the area
                int area = a.get(top) * (stack.isEmpty() ? i :  (i-stack.peek()-1));
                //update the max are
                max_area = Math.max(max_area, area);
            }
        }
        while (!stack.isEmpty()){
            top = stack.pop();
            //calculate the area
            int area = a.get(top) * (stack.isEmpty() ? i :  (i-stack.peek()-1));
            //update the max are
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }

    private static ArrayList<ArrayList<Integer>> getMatrix() {
        Integer[] temp1 = {1,1,0,0,1,1};
        Integer[] temp2 = {1,1,1,1,1,0};
        Integer[] temp3 = {0,0,1,1,1,0};
        Integer[] temp4 = {1,1,1,1,1,1};
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(temp1));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(temp2));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(temp3));
        ArrayList<Integer> four = new ArrayList<>(Arrays.asList(temp4));
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(one);
        a.add(two);
        a.add(three);
        a.add(four);
        return a;
    }

}
