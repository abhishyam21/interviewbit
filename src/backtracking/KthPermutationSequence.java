package backtracking;

import java.util.*;

/**
 * Created by Rachana Rao on 1/23/2017.
 */


public class KthPermutationSequence {
    private  List<String> result = new ArrayList<>();
    int counter =1;
    public static void main(String[] args) {
        KthPermutationSequence kthPermutationSequence = new KthPermutationSequence();
        int n=3,k=4;
        System.out.println(kthPermutationSequence.getPermutation(4,2));
        System.out.println(kthPermutationSequence.result.toString());
    }

    private String getPermutation(int n, int k) {
        ArrayList<Integer> str = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            str.add(i);
        }
     return    printPermutations(str, k-1);
    }

    private String printPermutations(ArrayList<Integer> str, int k) {
        int n = str.size();
        if( n == 0) return "";

        int numGroup = fact(n);

        if( k > numGroup) return "";
            numGroup=fact(n-1);

           int pos = k / numGroup;
           String val = String.valueOf(str.get(pos));
            str.remove(pos);
            k = k % numGroup;
        return val+printPermutations(str,k);
    }

    private int fact(int n) {
        if (n > 12) {
            // this overflows in int. So, its definitely greater than k
            // which is all we care about. So, we return INT_MAX which
            // is also greater than k.
            return Integer.MAX_VALUE;
        }
        if( n <=1)
            return 1;
        return fact(n-1)*n;
    }
}


/*
 private String getPermutation(int n, int k) {
       ArrayList<Integer> str = new ArrayList<>();
       ArrayList<Integer> counts = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            str.add(i);
            counts.add(1);
        }
        printPermutations(str,"",counts,0,k);
        return ans;
    }

    private  void printPermutations(ArrayList<Integer> str, String results, ArrayList<Integer> counts, int level, int k) {
        if(level == str.size()){
            result.add(results);
            if(k == counter)
                ans = results;
            counter++;
            return;
        }
        for (int i = 0; i < str.size() && result.size() <=k; i++) {
            if(counts.get(i) > 0){
                results+=str.get(i)+"";
                counts.set(i,counts.get(i)-1);
                printPermutations(str,results,counts,level+1, k);
                counts.set(i,counts.get(i)+1);
                results = results.substring(0,results.length()-1);
            }
        }
    }
 */