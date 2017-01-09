package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Rachana Rao on 1/8/2017.
 */
public class RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Integer[] temp = {1,1,1,2,2,2,2,3,4,4,5,6};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        RemoveDuplicatesFromSortedArrayIi removeDuplicatesFromSortedArrayIi = new RemoveDuplicatesFromSortedArrayIi();
        removeDuplicatesFromSortedArrayIi.removeDuplicates(a);
        System.out.println(a.toString());
    }

    private int removeDuplicates(ArrayList<Integer> a) {
        int pos = 0;
        int i=0;
        int count = 0;
        int n=a.size();
        while (i <n){
            if((i+1) < n && Objects.equals(a.get(i), a.get(i + 1))){
                count++;
            }else {
                if(count == 0){
                    a.set(pos++,a.get(i));
                }else if(count>=1){
                    a.set(pos++,a.get(i));
                    a.set(pos++,a.get(i));
                }
                count = 0;
            }
            i++;
        }
        n--;
        for (int j = 0; j <= (n-pos); j++) {
            a.remove(n-j);
        }
        return a.size();
    }
}
