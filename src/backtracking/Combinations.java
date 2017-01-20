package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rachana Rao on 1/21/2017.
 */
public class Combinations {
    ArrayList<ArrayList<Integer>> result;
    public static void main(String[] args) {
        int n=5,k=3;
        Combinations combinations = new Combinations();
        ArrayList<ArrayList<Integer>> result = combinations.combinations(n, k);
        for (ArrayList<Integer> aResult : result) {
            System.out.println(aResult.toString());
        }
    }

    private ArrayList<ArrayList<Integer>> combinations(int n, int k) {
        result = new ArrayList<>();
        subset(n,0,new ArrayList<>(),k);
        return result;
    }

    private void subset(int n,int position, ArrayList<Integer> subset, int k) {
        if(subset.size() == k){
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = position+1; i <= n; i++) {
            subset.add(i);
            subset(n,1+position,subset,k);
            subset.remove(subset.size()-1);
        }
    }
}
