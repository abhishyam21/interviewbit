package stringmatching;

import java.util.*;

/**
 * Created by Rachana Rao on 10/23/2016.
 */
public class ZigzagString {
    public static void main(String[] args) {
        String a = "abhishyam";
        int b= 1;
        ZigzagString zigzagString = new ZigzagString();
        System.out.println(zigzagString.convert(a,b));
    }

    private String convert(String a, int b) {
        if(b==1)
            return a;
        Set<Integer> pattern = new LinkedHashSet<>();
        int len = a.length();
        int count = 0;
        int noOfRows = len/b;
        noOfRows = (len%b) == 0 ? noOfRows:++noOfRows;
        for (int i = 0; i < noOfRows; i++) {
            pattern.add(count);
           count = (b-1) *(2+(2*i));
        }
        int j=0;
        while (j<=b){
            Object[] size =  pattern.toArray();
            for (Object temp : size) {
                Integer n = (Integer) temp;
                int r = n - 1;
                int l = n + 1;
                if (r > 0) pattern.add(r);
                if (l < len) pattern.add(l);
            }
            j++;
        }
       // System.out.println(pattern.toString());
        String result = "";
        List<Integer> temp = new ArrayList<>();
        temp.addAll(pattern);
        for (Integer n : temp) {
            if(n<len)
            result += a.charAt(n) + "";
        }

        return result;
    }
}
