package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by abhishyam.c on 12/16/2016.
 */
public class Subset {
    public static void main(String[] args) {
        Integer[] temp = {15, 20, 12, 19, 4};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        Subset subset = new Subset();
        ArrayList<ArrayList<Integer>> subsets = subset.subsets(a);
        for (ArrayList<Integer> arrayList : subsets) {
            System.out.println(arrayList.toString());
        }
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j <= a.size(); j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                    temp.addAll(new ArrayList<>(a.subList(i,j)));
                result.add(temp);
            }

        }
        return result;
    }


}
