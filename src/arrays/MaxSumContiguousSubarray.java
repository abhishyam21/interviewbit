package arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rachana Rao on 7/23/2016.
 */
public class MaxSumContiguousSubarray {
    public static void main(String[] args) {
        List<Integer> a = new LinkedList<>();
        a.add(-2);
        a.add(1);
        a.add(-3);
        a.add(4);
        a.add(-1);
        a.add(2);
        a.add(1);
        a.add(-5);
        a.add(4);
        MaxSumContiguousSubarray maxSumContiguousSubarray = new MaxSumContiguousSubarray();
        System.out.println(maxSumContiguousSubarray.findMaxSum(a));
    }

    private int findMaxSum(List<Integer> a) {
            if (a.size() == 0) {
                return 0;
            }
            if (a.size() == 1) {
                return a.get(0);
            } else {
                int sum = 0;
                int ans = Integer.MIN_VALUE;
                for (Integer num : a) {
                    sum+= num;
                    ans = Math.max(sum,ans);
                    if(sum <0){
                        sum = 0;
                    }
                }
                return ans;
            }
    }
}
