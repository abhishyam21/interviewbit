package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Rachana Rao on 1/8/2017.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Integer[] temp = {1,1,1,2,2,2,2,3,3,3,4,5,6,6,6,6};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        removeDuplicatesFromSortedArray.removeDuplicates(a);
        System.out.println(a.toString());
    }

    private int removeDuplicates(ArrayList<Integer> a) {
        int pos = 1;
        int i=1;
        while (i <a.size()){
            if(!Objects.equals(a.get(i), a.get(i - 1))){
                a.set(pos,a.get(i));
                pos++;
            }
            i++;
        }
        int n =a.size()-1;
        for (int j = 0; j <= (n-pos); j++) {
            a.remove(n-j);
        }
        return a.size();
    }
}
