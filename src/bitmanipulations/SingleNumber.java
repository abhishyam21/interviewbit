package bitmanipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 9/11/2016.
 */
public class SingleNumber {
    public static void main(String[] args) {
        Integer[] temp = {1,2,3,4};
        final List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(a));
    }

    private int singleNumber(final List<Integer> a) {
        int result = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            result = a.get(i) ^ result;
        }
        return result;
    }
}
