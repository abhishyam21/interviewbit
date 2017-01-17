package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 1/10/2017.
 */
public class Diffk {
    public static void main(String[] args) {
        Diffk diffk = new Diffk();
        Integer[] temp = {1,3,5};
        int b=4;
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        int i = diffk.diffPossible(a, b);
        System.out.println(i);
    }

    private int diffPossible(ArrayList<Integer> a, int b) {
        int n= a.size();
        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n; j++) {
                if(Math.abs(a.get(i) -a.get(j)) == b) return 1;
            }
        }
        return 0;
    }
}
