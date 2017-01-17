package heapsandmaps;

import java.util.*;

/**
 * Created by Rachana Rao on 1/15/2017.
 */
public class MagicianAndChocolates {
    public static void main(String[] args) {
        int K = 10 ;
        Integer[] temp ={2147483647, 2000000014, 2147483647};
        //Integer[] temp ={6,5};
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(temp));
        MagicianAndChocolates magicianAndChocolates = new MagicianAndChocolates();
        int nchoc = magicianAndChocolates.nchoc(K, b);
        System.out.println(nchoc);
    }

    private int nchoc(int A, ArrayList<Integer> B) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (Integer val : B) {
            addToMap(val,map);
        }
        int mod = 1000000007;
        int result = 0;
        for (int i = 0; i < A; i++) {
            Map.Entry<Integer, Integer> entity = map.pollLastEntry();
            Integer key = entity.getKey();
            Integer value = entity.getValue();
            result=(result%mod)+(key%mod);
            result = result%mod;
            key/=2;
            //map.put(key,1);
            addToMap(key,map);
             if(value>1){
                 map.put(entity.getKey(),--value);
             }
        }
        return result;
    }

    private void addToMap(Integer val, TreeMap<Integer, Integer> map) {
        Integer count = map.get(val);
        if (count == null)
            map.put(val, 1);
        else {
            map.put(val, ++count);
        }
    }
}

/*
{
        int mod = 1000000007;
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.addElement(B);
        int result = 0;
        for (int i = 0; i < A; i++) {
            int val = maxHeap.poll();
            result=(result%mod)+(val%mod);
            result = result%mod;
            val/=2;
            maxHeap.addElement(val);
        }
        return result;
    }
 */