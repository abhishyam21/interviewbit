package dynamicProgramming;

import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/18/2017.
 */
public class InterleavingStrings {
    public static void main(String[] args) {
        String a = "abcd";
        String b = "xyz";
        String c = "abxycdz";
        InterleavingStrings interleavingStrings = new InterleavingStrings();
        System.out.println(interleavingStrings.compute(a,b,c));
    }

    private int compute(String a, String b, String c) {
        int m = a.length();
        int n = b.length();
        //row is length of both and and b and column size is c length
        boolean[][] cache = new boolean[m+1][n+1];

        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <= n; j++) {
                // Both strings are empty
                if(i==0 && j==0)
                   cache[i][j] = true;
                // string A is empty, compare characters in C and B
                else  if(i==0 && c.charAt(j-1) == b.charAt(j-1)){
                   cache[i][j] = cache[i][j-1];
                }
                // string B is empty, compare characters in C and A
                else if(j==0 && c.charAt(i-1) == a.charAt(i-1)){
                   cache[i][j] = cache[i-1][j];
                }
                // Both strings are not empty
                //1. If character of A matches with character of C
                // but not of B
                else if (a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) != c.charAt(i+j-1)){
                   cache[i][j] =cache[i-1][j];
                }
                //2. If character of B matches with character of C
                // but not of A
                else if (a.charAt(i-1) != c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1)){
                   cache[i][j] =cache[i][j-1];
                }
                //1. If character of A matches with character of C
                // and character of B also matches with C
                else if (a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1)){
                   cache[i][j] =cache[i-1][j] ||cache[i][j-1];
                }
            }
        }
        print(cache);
        return cache[m-1][n-1] ? 1:0;
    }

    private void print(boolean[][] cache) {
        for (int i = 0; i < cache.length; i++) {
            System.out.println(Arrays.toString(cache[i]));
        }
    }
}
