package dynamicProgramming;

import java.util.Set;

/**
 * Problem Link:
 *https://www.techiedelight.com/longest-palindromic-subsequence-using-dynamic-programming/
 * Created by Rachana Rao on 4/1/2017.
 */
public class LongestPalindromicSubsequence {
    private static int[][] sol;

    public static void main(String[] args) {
        String a = "ATACTCGGA";
        LongestPalindromicSubsequence subsequence = new LongestPalindromicSubsequence();
        int length = subsequence.longestPalindromeSequence(a);
        System.out.println("Length of the Longest Palindrome: "+length);
    }

    private int longestPalindromeSequence(String a) {
        String x = a;
        String y = reverse(a);
        int length = LongestCommonSubSequence.dp1(x, y);
        for (String s : LongestCommonSubSequence.getAllLCS(x, y)) {
            System.out.println(s);
        }
        return length;
    }

    private String reverse(String a) {
        StringBuilder sb = new StringBuilder(a);
        sb = sb.reverse();
        return sb.toString();
    }
}
