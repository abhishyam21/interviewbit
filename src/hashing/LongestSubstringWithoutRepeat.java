package hashing;

import java.util.HashSet;
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
        Set<Character> counts = new HashSet<>();
        int result = Integer.MIN_VALUE;
        int wl =0;
        for (int i = 0; i < a.length(); i++) {
            char entity = a.charAt(i);
            if(counts.contains(entity)){
                result = Math.max(result,counts.size());
                counts.clear();
            }
            counts.add(entity);
        }
        result = Math.max(result,counts.size());
        return result;
    }
}
