package dynamicProgramming;

/**
 * Created by Rachana Rao on 2/18/2017.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        String a = "banana";
        String b = "ban";
        System.out.println(distinctSubsequences.subSeq(a, b));
    }

    private int subSeq(String a, String b) {
        int n = a.length() + 1;
        int m = b.length() + 1;
        int[][] cache = new int[n][m];

        for (int i = 0; i < n; i++) {
            cache[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a.charAt(i - 1) != b.charAt(j - 1))
                    cache[i][j] = cache[i-1][j];
                else
                    cache[i][j] = cache[i-1][j] + cache[i - 1][j - 1];
            }
        }
        print(cache);
        return cache[n - 1][m - 1];
    }

    private void print(int[][] cache) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                System.out.print(cache[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
