package backtracking;

import java.util.*;

/**
 * Created by Rachana Rao on 1/19/2017.
 */
public class SubsetSum {
     ArrayList<Integer> a;
     int N;
    public static void main(String[] args) {
        Integer[] temp = {15, 20, 12, 19, 4 };
    //    Integer[] temp = {1,2,2};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        SubsetSum subsetSum = new SubsetSum();
        int b=12;
        ArrayList<ArrayList<Integer>> result = subsetSum.subSetSum(a);
        result.forEach(list -> System.out.println(list.toString()));
    }

    private ArrayList<ArrayList<Integer>> subSetSum(ArrayList<Integer> a) {
        Collections.sort(a);
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int pow = (int) Math.pow(2, a.size());
        for (int i = 0; i < pow; i++) {
            ArrayList<Integer> set = new ArrayList<>();
            for (int j = 0; j < a.size(); j++) {
                if ((i & (1<<j)) !=0)
                    set.add(a.get(j));
            }
            result.add(set);
            }

            result.sort((a12, b) -> {
                int a1 = a12.size();
                int a2 = b.size();
                int res = 0;
                for (int i = 0; i < Math.min(a1, a2); i++) {
                    res = Integer.compare(a12.get(i), b.get(i));
                    if (res != 0) return res;
                }
                return Integer.compare(a1, a2);
            });
        return result;
        }
}
