package backtracking;

import java.util.ArrayList;

/**
 * Created by abhishyam.c on 1/16/2017.
 */
public class PermutationsOfString {
    private static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) {
        String a = "abc";
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
