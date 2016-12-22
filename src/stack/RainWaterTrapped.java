package stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abhishyam.c on 12/2/2016.
 */
public class RainWaterTrapped {
    public static void main(String[] args) {
        List<Integer> a = getNumbers();
        RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
        System.out.println(rainWaterTrapped.trap(a));
    }

    private int trap(final List<Integer> a) {
        int result = 0;
        List<Integer> leftMax = getLeftMax(a);
        List<Integer> rightMax = getRightMax(a);
        int size = a.size()-1;
        for (int i = 0; i < a.size(); i++) {
            int current = a.get(i);
            result += Math.max(Math.min(leftMax.get(i),rightMax.get(size-i)) - current,0);
        }
        return result;
    }

    private List<Integer> getRightMax(List<Integer> a) {
        List<Integer> rightMax = new LinkedList<>();
        int rMax = 0;
        for (int i = a.size()-1; i >=0 ; i--) {
                if(rMax < a.get(i)) {
                    rightMax.add(rMax);
                    rMax = a.get(i);
                }
            else
                rightMax.add(rMax);
        }
        return rightMax;
    }

    private List<Integer> getLeftMax(List<Integer> a) {
        List<Integer> leftMax = new LinkedList<>();
        int lMax = 0;
        for (int i = 0; i < a.size(); i++) {
                if(lMax < a.get(i)){
                    leftMax.add(i,lMax);
                    lMax = a.get(i);
                }else
                leftMax.add(i,lMax);
        }
        return leftMax;
    }

    private static List<Integer> getNumbers() {
        Integer[] temp = {0,1,0,2,1,0,1,3,2,1,2,1};
        return Arrays.asList(temp);
    }
}
