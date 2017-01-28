package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 1/28/2017.
 */
public class SlidingWindowMax {
    public static void main(String[] args) {
        Integer[] temp = {648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};
     //   Integer[] temp = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        ArrayList<Integer> result = slidingWindowMax.slidingMaximum(a, 9);
        System.out.println(result.toString());
    }

    private ArrayList<Integer> slidingMaximum(List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        Integer maxVal=Integer.MIN_VALUE,maxPos =-1;
        int i=0;
        for(;i<b && i<a.size();i++){
            if(maxVal < a.get(i)){
                maxVal = a.get(i);
                maxPos = i;
            }
        }
            result.add(maxVal);

        for (; i < a.size(); i++) {
            if(maxVal > a.get(i) && maxPos-1> (i-b)) result.add(maxVal);
            else {
                maxVal = Integer.MIN_VALUE;
                for (int j = (i - b)+1; j <= i; j++) {
                    if (a.get(j) > maxVal) {
                        maxVal = a.get(j);
                        maxPos = j;
                    }
                }
                result.add(maxVal);
            }
        }
        return result;
    }
}
