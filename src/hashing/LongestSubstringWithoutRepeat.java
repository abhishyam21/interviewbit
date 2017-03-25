package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by abhishyam.c on 3/9/2017.
 */
public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeat withoutRepeat = new LongestSubstringWithoutRepeat();
        String a = "abbbbbb";
        System.out.println(withoutRepeat.countOfDistinct(a));
    }

    private int countOfDistinct(String a) {
        Map<Character,Integer> map = new HashMap<>();
        int result = 0;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            char entity = a.charAt(i);
            if(map.containsKey(entity)){
                int prev = map.get(entity);
                count = Math.min(count+1,i-prev);
            }else
            count++;
            map.put(entity,i);
            result = Math.max(result,count);
        }
        return result;
    }
}
