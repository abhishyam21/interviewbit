package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 3/13/2017.
 */
public class LengthOfLongestSubsequence {
    public static void main(String[] args) {
       // Integer[] temp = {1, 11, 2, 10, 4, 5, 2, 1};
        Integer[] temp ={4, 2, 5, 9, 7, 6, 10, 3, 1};
     //   Integer[] temp = new Integer[0];
        List<Integer> a = Arrays.asList(temp);
        LengthOfLongestSubsequence subSequence = new LengthOfLongestSubsequence();
        System.out.println(subSequence.longestSubSequenceLength(a));
    }

    private int longestSubSequenceLength(final List<Integer> A) {
        int n = A.size();
        if(n == 0) return 0;
        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1;
        for(int i=1; i<n; i++)
        {
            inc[i] = 1;
            for(int j=i-1; j>=0; j--)
            {
                if(A.get(i) > A.get(j) && inc[i] < inc[j] + 1)
                    inc[i] = inc[j] + 1;
            }
        }

        dec[n-1] = 1;
        for(int i=n-2; i>=0; i--)
        {
            dec[i] = 1;
            for(int j=i+1; j<n; j++)
            {
                if(A.get(i) > A.get(j) && dec[i] < dec[j] + 1)
                    dec[i] = dec[j] + 1;
            }
        }

        int mx = 0;
        for(int i=0; i<n; i++)
            mx = Math.max(mx, inc[i] + dec[i] - 1);

        return mx;
    }
}
