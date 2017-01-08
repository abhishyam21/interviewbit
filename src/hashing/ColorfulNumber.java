package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rachana Rao on 12/29/2016.
 */
public class ColorfulNumber {
    public static void main(String[] args) {
        ColorfulNumber colorfulNumber= new ColorfulNumber();
        int a=12;
        System.out.println(colorfulNumber.colorful(a));
    }

    private int colorful(int a) {
        Map<Long,Integer> map =new HashMap<>();
        return getPermutations(a,map);
    }

    private int getPermutations(int a, Map<Long, Integer> map) {
        int ten = 10;
        int divider = 10;
        while ((a%divider) != a){
            int num = a;
            while (num>0 && num>divider){
                int frac =num%divider;
                Long productVal = getProductVal(frac);
                if(map.containsKey(productVal))
                    return 0;
                map.put(productVal,frac);
                num/=ten;
            }
            Long productVal = getProductVal(num);
            if(map.containsKey(productVal))
                return 0;
            map.put(productVal,num);
            divider*=10;
        }
        Long productVal = getProductVal(a);
        if(map.containsKey(productVal))
            return 0;
        map.put(productVal,a);
        return 1;
    }

    private Long getProductVal(int frac) {
        if(frac <10) return (long) frac;
        Long res = 1L;
        int ten = 10;
        while (frac>0){
            res = res*(frac%ten);
            frac/=ten;
        }
        return res;
    }
}
