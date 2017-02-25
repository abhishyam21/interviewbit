package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Rachana Rao on 2/24/2017.
 */
public class SubstringConcatenation {
    public static void main(String[] args) {
        String a = "abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa";
        String[] temp = {"cac", "aaa", "aba", "aab", "abc"};
        ArrayList<String> b = new ArrayList<>(Arrays.asList(temp));
        SubstringConcatenation substringConcatenation = new SubstringConcatenation();
        ArrayList<Integer> substring = substringConcatenation.findSubstring(a, b);
        System.out.println(substring.toString());
    }

    private ArrayList<Integer> findSubstring(String a, ArrayList<String> b) {
        HashMap<String, Integer> cache = new HashMap<>();
        int len = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int i=0;

        for (String s : b) {
            Integer count = cache.get(s);
            if(count == null)
                cache.put(s,1);
            else
            cache.put(s,++count);
        }

        if (b.size() > 0) {
            len = b.get(0).length();
        }

        int size = b.size();
        int prevPosition = 0;
        for (i = 0; i < a.length() - len; i++) {
            String substring = a.substring(i, (i + len));
            Integer pos = cache.get(substring);
            if (pos == null){
                size = b.size();
                 i-= (prevPosition*len);
                 prevPosition = 0;
            }else {
                size--;
                prevPosition++;
                i+=len-1;
            }
            if(size == 0){
                result.add(i-(prevPosition*len));
            }
        }
        return result;
    }
}
