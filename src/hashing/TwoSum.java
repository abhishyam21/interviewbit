package hashing;

import java.util.*;

/**
 * Created by Rachana Rao on 2/21/2017.
 */
public class TwoSum {
    public static void main(String[] args) {
        Integer[] temp = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.sum(a,-3).toString());
    }

    private ArrayList<Integer> sum(List<Integer> a, int b) {
        HashMap<Integer,Integer> cache = new HashMap<>();
        ArrayList<Integer> result =new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            int val1 = a.get(i);
            Integer pos = cache.get((b-val1));
            if(pos != null){
                result.add(i+1);
                result.add(pos+1);
                Collections.sort(result);
                return result;
            }else {
                if(!cache.containsKey(val1))
                cache.put(val1,i);
            }
        }
        return result;
    }
}
