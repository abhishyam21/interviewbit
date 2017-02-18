package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumAbsoluteDifference {
    public static void main(String[] args) {
        Integer[] temp = {1,3,-1,-4,6};
        ArrayList<Integer> a= new ArrayList<>(Arrays.asList(temp));
        MaximumAbsoluteDifference maximumAbsoluteDifference = new MaximumAbsoluteDifference();
        int result = maximumAbsoluteDifference.maxArr(a);
        System.out.println(result);
    }

    public int maxArr(ArrayList<Integer> a) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                    int val = Math.abs(a.get(i) - a.get(j))+ Math.abs(i-j);
                result  = result< val ? val : result;
            }
        }
        return result;
    }


}
