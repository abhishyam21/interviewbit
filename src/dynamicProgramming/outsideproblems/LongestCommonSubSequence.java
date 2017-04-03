package dynamicProgramming.outsideproblems;

import java.util.HashSet;
import java.util.Set;

/**
 * problem link: http://www.techiedelight.com/longest-common-subsequence/
 * Created by Rachana Rao on 2/12/2017.
 */
public class LongestCommonSubSequence {
    static int[][] sol;
    public static void main(String[] args) {
        String a = "ABCBDAB";
        String b = "BDCABA";
        System.out.println(nativeMethod(a, b, 0, 0));
        System.out.println(dp1(a, b));
        System.out.println(dp2(a, b));
        for (String s : getAllLCS(a, b)) {
            System.out.println(s);
        }

    }

    /**
     * This is native method where it will check all the possible combinations
     * that can be formed.
     * Time Complexity O(2 pow (M+N))
     * M = length of 1st string
     * N= length of 2ns string
     *
     * @param a first string
     * @param b second string
     * @param i position of the first string
     * @param j position of the second string
     * @return maximum length of the longest common sub sequence
     */
    private static int nativeMethod(String a, String b, int i, int j) {
        if (i >= a.length() || j >= b.length())
            return 0;
        if (a.charAt(i) == b.charAt(j)) {
            return nativeMethod(a, b, i + 1, j + 1) + 1;
        } else {
            return Math.max(nativeMethod(a, b, i + 1, j), nativeMethod(a, b, i, j + 1));
        }
    }

    /**
     * This is the optimized version of the lcs
     * Time complexity O(M*N) and
     * space complexity O(M*N) where
     * M = length of 1st string
     * N= length of 2ns string
     *
     * @param a first string
     * @param b second string
     * @return maximum length of the longest common sub sequence
     */
    static int dp1(String a, String b) {
        int m = a.length() + 1;
        int n = b.length() + 1;
        sol = new int[m][n];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    sol[i][j] = sol[i - 1][j - 1] + 1;
                } else {
                    sol[i][j] = Math.max(sol[i - 1][j], sol[i][j - 1]);
                }
                max = Math.max(sol[i][j], max);
            }
        }
        return max;
    }

    /**
     *  This solution is with
     *  Time Complexity : O(M*N)
     *  Space Complexity: O(N)
     * @param a first string
     * @param b second string
     * @return maximum length of the longest common sub sequence
     */
    private static int dp2(String a, String b) {
        int m = a.length() + 1;
        int n = b.length() + 1;
        int[] sol = new int[n];
        int max = Integer.MIN_VALUE;
        int prev = 0;
        int backup = 0;
        for (int i = 1; i < m; i++) {
         //   System.out.println(Arrays.toString(sol));
            prev = sol[0];
            for (int j = 1; j < n; j++) {
                backup = sol[j];
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    sol[j] = prev + 1;
                } else {
                    sol[j] = Math.max(sol[j - 1], sol[j]);
                }
                max = Math.max(max, sol[j]);
                prev = backup;
            }
        }
      //  System.out.println(Arrays.toString(sol));
        return max;
    }

    /**
     * This method will print all the longest common sub sequences
     * that can be formed from given strings
     * @param a input
     * @param b input
     */
    static Set<String> getAllLCS(String a, String b) {
        int m = sol.length-1;
        int n= sol[0].length-1;
          return  util(a,b,m,n);
    }

    private static Set<String> util(String a, String b, int m, int n) {
        Set<String> result = new HashSet<>();
        if(m ==0 || n==0) {
            result.add("");
            return result;
        }
        //if the both the characters are equal, then
        //add that character to the all the result in the set
        if(a.charAt(m-1) ==b.charAt(n-1)){
            Set<String> temp = util(a,b,m-1,n-1);
            for (String s : temp) {
                result.add(s+a.charAt(m-1));
            }
        }else {//if not
            //check top element in the matrix is grater than
            //left element of current element in the matrix
                if(sol[m-1][n] >= sol[m][n-1]){
                    result = util(a,b,m-1,n);
                }
                if(sol[m-1][n] <= sol[m][n-1]) {
                    Set<String> temp = util(a, b, m, n - 1);
                    result.addAll(temp);
                }
        }
        return result;
    }
}
