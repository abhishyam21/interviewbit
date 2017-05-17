package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rachana Rao on 5/17/2017.
 */
public class WindowString {
    public static void main(String[] args) {
        String s = "A";
        String t = "A";
        WindowString windowString = new WindowString();
        System.out.println(windowString.minWindow(s, t));
    }

    private String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, -1);
            Integer integer = counts.get(c);
            if (integer == null)
                integer = 0;
            counts.put(c, ++integer);
        }
        for (int i = 0; i < s.length(); i++) {
            Integer pos = map.get(s.charAt(i));
            if (pos != null) {
                if (pos == -1) {
                    map.put(s.charAt(i), i);
                } else {
                    map.put(s.charAt(i), i);
                    result = getMax(map, result, s);
                }
            }
        }
        result = getMax(map, result, s);
        return result;
    }

    private String getMax(Map<Character, Integer> map, String result, String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == -1) {
                return "";
            } else {
                min = Math.min(min, entry.getValue());
                max = Math.max(max, entry.getValue());
            }
        }
        int len = result.length();
        if (len == 0) {
            result = s.substring(min, max + 1);
        } else if (len > (max - min)) {
            result = s.substring(min, max + 1);
        }
        return result;
    }
}
