package dynamicProgramming;

/**
 * Created by Rachana Rao on 2/18/2017.
 */
public class RepeatingSubSequence {
    public static void main(String[] args) {
        String a ="aabb";
        RepeatingSubSequence subSequence = new RepeatingSubSequence();
        System.out.println(subSequence.findSeq(a));
    }

    /**
     * This solution is same as longest common subSequence
     * here we will check extra validation like i!=j
     *
     * worst case time complexity is O(N2) and
     * space complexity O(N2)
     * @param a string
     * @return 1-yes 0-No
     */
    private int findSeq(String a) {
        int n = a.length()+1;
        int[][] cache = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(a.charAt(i-1) == a.charAt(j-1) && i!=j) {
                    cache[i][j] = 1+cache[i-1][j-1];
                }else {
                    cache[i][j] = Math.max(cache[i-1][j],cache[i][j-1]);
                }
                if(cache[i][j] >=2) return 1;
            }
        }
        return 0;
    }



}
