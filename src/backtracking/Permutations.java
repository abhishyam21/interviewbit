package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rachana Rao on 1/23/2017.
 */
public class Permutations {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        Integer[] temp = {1,2,3};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        Permutations permutations = new Permutations();
        ArrayList<ArrayList<Integer>> permute = permutations.permute(a);
        permute.forEach( list -> System.out.println(list.toString()));

    }

    private ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        permutations(a,0);
        return result;
    }

    private void permutations(ArrayList<Integer> a, int position) {
        if(position == a.size()){
            result.add(new ArrayList<>(a));
        }
        for (int i = position; i < a.size(); i++) {
            swap(a,position,i);
            permutations(a,1+position);
            swap(a,i,position);
        }
    }

    private void swap(ArrayList<Integer> a, int position, int i) {
        Integer integer = a.get(position);
        a.set(position,a.get(i));
        a.set(i,integer);
    }
}
