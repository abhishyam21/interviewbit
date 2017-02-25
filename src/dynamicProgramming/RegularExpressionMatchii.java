package dynamicProgramming;

/**
 * for reference video link with explanation
 * https://www.youtube.com/watch?v=l3hda49XcDE&list=PLrmLmBdmIlpuE5GEMDXWf0PWbBD9Ga1lO
 * Created by Rachana Rao on 2/25/2017.
 */
public class RegularExpressionMatchii {
    public static void main(String[] args) {
        String a = "efwihfioghih35i";
        String b = ".*";
        RegularExpressionMatchii regularExpressionMatchii = new RegularExpressionMatchii();
        System.out.println(regularExpressionMatchii.isMatch(a,b));
    }

    private int isMatch(String a, String b) {
        int m = a.length()+1;
        int n = b.length()+1;
        boolean[][] cache = new boolean[m][n];
        cache[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < cache[0].length; i++) {
            if (b.charAt(i-1) == '*') {
                cache[0][i] = cache[0][i - 2];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(a.charAt(i-1) ==b.charAt(j-1) || b.charAt(j-1) == '.'){
                    cache[i][j] = cache[i-1][j-1];
                }else if(b.charAt(j-1) =='*') {
                    cache[i][j] = cache[i][j - 2];
                    if(a.charAt(i-1) == b.charAt(j-2) || b.charAt(j-2) == '.')
                    cache[i][j] = cache[i][j] | cache[i - 1][j];
                }else cache[i][j] = false;
            }
        }

       print(cache);
        return cache[m-1][n-1] ? 1:0;
    }

    private void print(boolean[][] cache) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                System.out.print(cache[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
