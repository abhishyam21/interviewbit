package backtracking;

import java.util.*;

/**
 * For this problem, general permutations of the string is not going to work.
 * We need to arrange the numbers in the lexicographical  sorted order
 * We are going do recursive calls till Kth element and then we are gone return
 * the list of all the permutations of the given number in lexicographical order
 *
 * Created by Rachana Rao on 1/23/2017.
 */


public class KthPermutationSequence {
    private static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        KthPermutationSequence kthPermutationSequence = new KthPermutationSequence();
        int n=3,k=4;
        System.out.println(kthPermutationSequence.getPermutation(4,28));
    }

    private String getPermutation(int n, int k) {
       ArrayList<Integer> str = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            str.add(i);
        }
       permute(str,0,k);
        String temp = result.get(--k);
        return temp;
    }

    private void permute(ArrayList<Integer> str, int pos, int k) {
        if(pos == str.size()) {
            if(result.size() > k)
                return;
            result.add(getString(str));

        }else
            for (int i = pos; i < str.size() ; i++) {
                swap(str,i,pos);
                permute(str,pos+1, k);
                swap(str,pos,i);
            }
    }

    private String getString(ArrayList<Integer> str) {
        String res = "";
        for (Integer aStr : str) res += aStr + "";
        return res;
    }

    private void swap(ArrayList<Integer> a, int position, int i) {
        Integer integer = a.get(position);
        a.set(position,a.get(i));
        a.set(i,integer);
    }
}
