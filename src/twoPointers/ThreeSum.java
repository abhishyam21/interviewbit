package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rachana Rao on 12/30/2016.
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        Integer[] temp = {-1,4,2,-2,6,3,8,-6,7};
        //Integer[] temp = {-10,-10,-10};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        int b = 4;
        int sum = threeSum.sum(a, b);
        System.out.println(sum);
    }

    private int sum(ArrayList<Integer> a, int b) {
        Collections.sort(a);

        int n= a.size(),sum;
        int result = a.get(0)+a.get(1)+a.get(2);

        for (int i = 0; i < n-2; i++) {
            int l=i+1,r =n-1;
            int num = b-a.get(i);
            while (l<r){
                sum = a.get(l)+a.get(r);
                if(sum == num) return b;
               // result = getResult(i,l,r,b,a,result);
                if(sum< num)
                    l++;
                else r--;
                int diff = Math.abs(sum - num);
                int otherDiff = Math.abs(result - b);

                if (diff < otherDiff)
                    result = sum + a.get(i);
            }
        }
        return result;
    }

    private int getResult(int i, int j, int k, int b, ArrayList<Integer> a, int result) {
        int sum = a.get(i)+a.get(j)+a.get(k);
        int oldSumDiff = Math.abs(b-result);
        int newSumDiff = Math.abs(b-sum);
        return (oldSumDiff >= newSumDiff) ? sum: result;
    }
}
