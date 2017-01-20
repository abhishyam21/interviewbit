package backtracking;

import java.util.*;

/**
 * Created by Rachana Rao on 1/20/2017.
 */
public class CombinationSum2 {
    int N;
    ArrayList<Integer> list;
    Set<ArrayList<Integer>> subsetsList;
    public static void main(String[] args) {
        Integer[] temp = {10,1,2,7,6,1,5};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int b =8;
        ArrayList<ArrayList<Integer>> subsets = combinationSum2.combinationSum(a, b);
        for (ArrayList<Integer> arrayList : subsets) {
            System.out.println(arrayList.toString());
        }
    }

    private ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
            N = a.size();
            this.list = a;
            Collections.sort(this.list);
        subsetsList = new HashSet<>();

        subList(0,new ArrayList<Integer>(),b,0);
        ArrayList<ArrayList<Integer>>  result = new ArrayList<>();
        result.addAll(subsetsList);
        return result;
    }

    private void subList(int position, ArrayList<Integer> subset, int b, int sum) {
        if(position == N){
            if(sum == b) {
                Collections.sort(subset);
                subsetsList.add(new ArrayList<>(subset));
            }
            return;
        }
        subList(1+position,subset,b, sum);
        subset.add(list.get(position));
        sum+=list.get(position);
        subList(position+1,subset,b,sum);
        subset.remove(subset.size()-1);
    }
}
