package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rachana Rao on 1/17/2017.
 */
public class AllUniquePermutations {
    public static void main(String[] args) {
        AllUniquePermutations allUniquePermutations = new AllUniquePermutations();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,1,2));
        allUniquePermutations.permute(a);
    }

    private ArrayList<Integer> permute(ArrayList<Integer> a) {
        Set<Set<Integer>> result = new HashSet<>();
        Integer[] str = new Integer[a.size()];
        for (int i = 0; i < a.size(); i++) {
            str[i] = a.get(i);
        }
        unqPermute(str,0,result);
        return null;
    }

    private Set<Set<Integer>> unqPermute(Integer[] str, int pos, Set<Set<Integer>> result) {
        if(pos == str.length){
        }
        return null;
    }

    private void swap(Integer[] str, int l, int r){
        int temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
}
