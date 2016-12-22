package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rachana Rao on 8/6/2016.
 */
public class FindDuplicateinArray {
    public static void main(String[] args) {
        Integer[] temp = {3,4,1,4,1};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        System.out.println(repeatedNumber(a));
    }

    private static int repeatedNumber(List<Integer> a) {
        int size = a.size();
        if(size == 1){
            return a.get(0);
        }
        Collections.sort(a);
        for (int i = 1; i < size; i++) {
                if((a.get(i) ^ a.get(i-1) )==0){
                    return a.get(i);
                }
        }
        return 0;
    }
}
