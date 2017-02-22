package test.com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by abhishyam.c on 2/22/2017.
 */
public class LargestContinuousSequenceZeroSum {
    public static void main(String[] args) {
        Integer[] temp  ={1 ,2 ,-3,3};
        ArrayList<Integer> a =   new ArrayList<>(Arrays.asList(temp));
        LargestContinuousSequenceZeroSum zeroSum = new LargestContinuousSequenceZeroSum();
        System.out.println(zeroSum.lszero(a).toString());
    }

    private ArrayList<Integer> lszero(ArrayList<Integer> a) {
        Integer sum = 0;
        HashMap<Integer,Integer> cache = new HashMap<>();
        cache.put(0,-1);
        int end = -1,start = -1, len = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            sum+=a.get(i);
                Integer pos = cache.get(sum);
                if (pos == null) {
                    cache.put(sum, i);
                } else {
                    if(len <  (i-pos)){
                        start = pos;
                        end = i;
                        len = (i-pos);
                    }
                }
            }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start+1; i <=end ; i++) {
            result.add(a.get(i));
        }
        return result;
    }
}
