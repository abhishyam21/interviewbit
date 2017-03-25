package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 3/13/2017.
 */
public class LengthOfLongestSubsequence {
    public static void main(String[] args) {
        Integer[] temp = {1, 11, 2, 10, 4, 5, 2, 1};
        List<Integer> a = Arrays.asList(temp);
        LengthOfLongestSubsequence subsequence = new LengthOfLongestSubsequence();
        System.out.println(subsequence.longestSubsequenceLength(a));
    }

    private int longestSubsequenceLength(final List<Integer> a) {
        int result = 0;
        //get the longest increasing sub sequence
        return result;
    }
}
