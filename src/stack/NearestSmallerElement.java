package stack;

import java.util.ArrayList;
import java.util.Arrays;
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

    private ArrayList<Integer> prevSmaller(ArrayList<Integer> a) {
        ArrayList<Integer> minVal = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        minVal.add(0,-1);
        for (int i = 1; i < a.size(); i++) {
            int prev = i-1;
            //if prev value less than current add that value
            if(a.get(prev) < a.get(i)){
                minVal.add(i,a.get(prev));
                if(a.get(prev) < stack.peek())
                stack.push(a.get(prev));
            }else {
                    if(a.get(i) > minVal.get(prev))
                        minVal.add(minVal.get(prev));
                else if(a.get(i) > stack.peek())
                    minVal.add(stack.peek());
                else minVal.add(-1);
            }
        }
        return minVal;
    }

    private int getPrevValMin(ArrayList<Integer> minVal, Integer val) {
        for (int i = minVal.size()-1; i >=0 ; i--) {
            if(minVal.get(i) < val && minVal.get(i) != -1)
                return minVal.get(i);
        }
        return -1;
    }
}
