package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhishyam.c on 1/16/2017.
 */
public class PermutationsOfString {
    private static Set<String> result = new HashSet<>();
    public static void main(String[] args) {
        String a = "1234";
        PermutationsOfString permutationsOfString = new PermutationsOfString();
        permutationsOfString.permutation(a);
        System.out.println(result.toString());
    }

    private void permutation(String a) {
        char[] str = a.toCharArray();
        permute(str,0);
    }

    private void permute(char[] str, int pos) {
            if(pos == str.length) {
                result.add(String.valueOf(str));
            }else
        for (int i = pos; i < str.length; i++) {
            swap(str,i,pos);
            permute(str,pos+1);
            swap(str,i,pos);
        }
    }

    private void swap(char[] str, int l,int r){
        char temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
}
