package arrays;

import java.util.*;

/**
 * Created by Rachana Rao on 1/20/2017.
 */
public class LargestNumber {
    public static void main(String[] args) {
        Integer[] temp = {3, 30, 34, 5, 9};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        LargestNumber largestNumber = new LargestNumber();
        largestNumber.largestNumber(a);
    }

    public String largestNumber(final List<Integer> a) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Variable> temp = new ArrayList<>();
        for (Integer num : a) {
            temp.add(new Variable(num));
        }
        Collections.sort(temp);
        for (Variable s : temp) {
            if(Objects.equals(s.num,0) && stringBuilder.length()>0)
                continue;
            stringBuilder.append(s.num);
        }
        return stringBuilder.toString();
    }
    class Variable implements Comparable<Variable>{
        int num;

        public Variable(int num) {
            this.num = num;
        }

        @Override public int compareTo(Variable o) {
            String s1 = String.valueOf(o.num)+String.valueOf(this.num);
            String s2 = String.valueOf(this.num)+String.valueOf(o.num);
            return s1.compareTo(s2);
        }
    }
}
