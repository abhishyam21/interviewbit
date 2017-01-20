package backtracking;

import java.util.*;

/**
 * Created by Rachana Rao on 1/21/2017.
 */
public class Subset2 {
    int N;
    ArrayList<Integer> list;
    Set<ArrayList<Integer>> result;
    public static void main(String[] args) {
        Integer[] temp = {1,2,2};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        Subset2 subset = new Subset2();
        ArrayList<ArrayList<Integer>> subsets = subset.subsets(a);
        for (ArrayList<Integer> arrayList : subsets) {
            System.out.println(arrayList.toString());
        }
    }

    private ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        this.list = a;
        Collections.sort(list);
        N = list.size();
        result = new HashSet<>();
        subset(0, new ArrayList<>());

        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        subsets.addAll(result);
        subsets.sort((a12, b) -> {
            int a1 = a12.size();
            int a2 = b.size();
            int res = 0;
            for (int i = 0; i < Math.min(a1, a2); i++) {
                res = Integer.compare(a12.get(i), b.get(i));
                if (res != 0) return res;
            }
            return Integer.compare(a1, a2);
        });
        return subsets;
    }

    private void subset(int position, ArrayList<Integer> subset) {
        if(position == N){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset(1+position,subset);
        subset.add(list.get(position));
        subset(position+1,subset);
        subset.remove(subset.size()-1);
    }
}

