package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by abhishyam.c on 12/5/2016.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Integer[] temp = {4,9,5,2,6,7,3};
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(temp));
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(a));
    }

    private int largestRectangleArea(ArrayList<Integer> a) {
        ArrayList<Integer> leftMin = getLeftMin(a);
        ArrayList<Integer> rightMin = getRightMin(a);
       /* System.out.println("Left:" +leftMin);
        System.out.println("Right: "+ rightMin);*/
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            int leftMinVal = leftMin.get(i);
            int rightMinVal = rightMin.get(i);
                    int area = (Math.abs(leftMinVal-rightMinVal)+1)* a.get(i);
                    result = area> result? area : result;
        }
        return result;
    }

    private ArrayList<Integer> getLeftMin(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> leftMin = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            while (!stack.isEmpty() && a.get(stack.peek()-1) >= a.get(i))
                stack.pop();
                if(stack.isEmpty())
                    leftMin.add(i,1);
            else leftMin.add(i,stack.peek()+1);
                stack.push(i+1);
        }
        return leftMin;
    }


    private ArrayList<Integer> getRightMin(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> rightMin = new ArrayList<>(a.size());
        for( int i= a.size()-1; i >=0 ; i--){
            while (!stack.isEmpty() && a.get(stack.peek()) >= a.get(i))
                stack.pop();
            if(stack.isEmpty()) rightMin.add(a.size());
            else rightMin.add(stack.peek());
            stack.push(i);
        }
        Collections.reverse(rightMin);
        return rightMin;
    }
}


/*
   for (int i = 0; i < a.size(); i++) {
            int leftMinVal = leftMin.get(i);
            int rightMinVal = rightMin.get(i);
            if(leftMinVal == start || rightMinVal == end){
                    int area = Math.abs(leftMinVal-rightMinVal)* a.get(i);
                    result = area> result? area : result;
            }else {
                    int area = (Math.abs(leftMinVal-rightMinVal)-1)* a.get(i);
                result = area > result ? area: result;
            }
        }
 */