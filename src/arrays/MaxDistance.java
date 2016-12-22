package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 9/9/2016.
 */
public class MaxDistance {
    public static void main(String[] args) {
        Integer[] temp = { 1, 10, 5 };
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        MaxDistance maxDistance = new MaxDistance();
        System.out.println(maxDistance.maximumGap(a));
    }

    private int maximumGap(final List<Integer> a) {
        int size = a.size()-1;
        int[] leftMin = new int[1+size];
        int[] rightMax = new int[1+size];
        leftMin[0] = a.get(0);
        rightMax[size] = a.get(size);
        for (int i = 1; i <=size; i++) {
            leftMin[i] = Math.min(a.get(i),leftMin[i-1]);
            rightMax[size-i] = Math.max(a.get(size-i),rightMax[size-i+1]);
        }
        int k=0,i=0;
        for (; i <= size;i++) {
            if(leftMin[k] > rightMax[i]){
                k++;
            }
        }
        return (i-1-k);

    }
}
/*

 */