package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by abhishyam.c on 12/16/2016.
 */
public class Subset {
    int N;
    ArrayList<Integer> list;
    ArrayList<ArrayList<Integer>> result;
    public static void main(String[] args) {
        Integer[] temp = {1,2,3,4,5};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        Subset subset = new Subset();
        ArrayList<ArrayList<Integer>> subsets = subset.subsets(a);
        for (ArrayList<Integer> arrayList : subsets) {
            System.out.println(arrayList.toString());
        }
        ArrayList<String> subset1 = subset(a);
        subset1.forEach(System.out::println);
    }

    private ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        this.list = a;
        Collections.sort(list);
        N = list.size();
        result = new ArrayList<>();
        subset(0, new ArrayList<>());
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

    /**
     * This is my own implementation which does not requires
     * any sorting.
     * @param a input integers set
     * @return list all subsets
     */
    private static ArrayList<String> subset(ArrayList<Integer> a) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        subsetUtil(result,a,0,builder);
        return result;
    }

    private static void subsetUtil(ArrayList<String> result, ArrayList<Integer> a, int pos, StringBuilder str) {
        for (int i = pos; i <a.size(); i++) {
            str.append(a.get(i));
            result.add(str.toString());
            subsetUtil(result, a, i + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
   /* public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> subsetsList = new ArrayList<>();
        int pow = (int) Math.pow(2, a.size());
        for (int i = 0; i < pow; i++) {
            ArrayList<Integer> subsetList = new ArrayList<>();
            for (int j = 0; j < a.size(); j++) {
                if ((i & (1<<j)) !=0)
                    subsetList.add(a.get(j));
            }
            subsetsList.add(subsetList);
        }

        subsetsList.sort((a12, b) -> {
            int a1 = a12.size();
            int a2 = b.size();
            int res = 0;
            for (int i = 0; i < Math.min(a1, a2); i++) {
                res = Integer.compare(a12.get(i), b.get(i));
                if (res != 0) return res;
            }
            return Integer.compare(a1, a2);
        });
        return subsetsList;
    }
*/
}
