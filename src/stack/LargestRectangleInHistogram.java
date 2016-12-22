package stack;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Integer[] temp = {1,4,2,1,3,1,4,2};
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(temp));
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(a));
    }

    private int largestRectangleArea(ArrayList<Integer> a) {
        int minVal = a.get(0);
        int result = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            int current = a.get(i);
            if(current < minVal)
                minVal = current;
             int min = Math.min(current,a.get(i-1))*2;
            result = result < min ? min : result;
        }
        return result > (minVal * a.size()) ? result : (minVal * a.size());
    }
}
