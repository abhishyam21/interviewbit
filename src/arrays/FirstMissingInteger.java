package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rachana Rao on 8/20/2016.
 */
public class FirstMissingInteger {
    public static void main(String[] args) {
        Integer[] temp = {-8, -7, -6};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
        System.out.println(firstMissingInteger.firstMissingPositive(a));
    }

    private int firstMissingPositive(ArrayList<Integer> a) {
        Collections.sort(a);
        int count =0;
        int nexNumber=1;
        for (int i = 0; i < a.size(); i++) {
            if(count==a.size()){
                return nexNumber;
            }else {
                if(a.get(i) <1){
                    count++;
                }
                else if(a.get(i) != nexNumber){
                    return nexNumber;
                }else
                nexNumber = a.get(i)+1;
            }
        }
        return nexNumber;
    }
}
