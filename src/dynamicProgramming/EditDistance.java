package dynamicProgramming;

/**
 * Created by Rachana Rao on 2/15/2017.
 */
public class EditDistance {
    public static void main(String[] args) {
        String a = "";
        String b = "";
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.dist(a,b));
    }

    private int dist(String a, String b) {
        int m = a.length()+1;
        int n= b.length()+1;
        int[][]  cache = new int[m][n];
        for (int i = 0; i < n; i++) {
            cache[0][i] = i+1;
        }
        for (int i = 0; i < m; i++) {
            cache[i][0] = i+1;
        }
        for (int i = 1; i < m; i++) {
            char c = a.charAt(i-1);
            for (int j = 1; j < n; j++) {
                if(c == b.charAt(j-1)){
                    cache[i][j] = cache[i-1][j-1];
                }else {
                    cache[i][j] = Math.min(cache[i-1][j-1],Math.min(cache[i][j-1],cache[i-1][j]))+1;
                }
            }
        }
      //  print(cache);
        return cache[m-1][n-1]-1;
    }

    private void print(int[][] cache) {
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                System.out.print(cache[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
