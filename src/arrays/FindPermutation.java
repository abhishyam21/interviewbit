package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Rachana Rao on 8/6/2016.
 */
public class FindPermutation {
    public static void main(String[] args) {
        int B = 3;
        String A = "ID";
        System.out.println(findPerm(A,B).toString());
    }

    private static ArrayList<Integer> findPerm(String A, int B) {
            ArrayList<Integer> result = new ArrayList<>();
            int h=B,l=1;
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == 'D'){
                result.add(h--);
            }else {
                result.add(l++);
            }
        }
        result.add(l);
        return result;
    }
}
