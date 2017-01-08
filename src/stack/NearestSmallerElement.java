package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NearestSmallerElement {
    public static void main(String[] args) {
        Integer[] temp = {39, 27, 11, 4, 24, 32, 32, 1};
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(temp));
        NearestSmallerElement nearestSmallerElement = new NearestSmallerElement();
        ArrayList<Integer> list = nearestSmallerElement.prevSmaller(a);
        System.out.println(list.toString());
    }

    private ArrayList<Integer> prevSmaller(ArrayList<Integer> a){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            while (!stack.isEmpty() && stack.peek() >= a.get(i)) stack.pop();
            if(stack.isEmpty())
                result.add(-1);
            else result.add(stack.peek());
            stack.push(a.get(i));
        }
    //   Collections.reverse(result);
        return result;
    }
}

/*
//code for next smallest element on the right side
{
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = a.size()-1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peek() >= a.get(i)) stack.pop();
            if(stack.isEmpty())
                result.add(-1);
              else result.add(stack.peek());
            stack.push(a.get(i));
        }
        Collections.reverse(result);
        return result;
    }
 */