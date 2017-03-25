package graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 3/25/2017.
 */
public class BlackShapes {
    private static final char WHITE = 'O';
    private int di[] = new int[] {1, -1, 0, 0};
    private int dj[] = new int[] {0, 0, 1, -1};
    public static void main(String[] args) {
        BlackShapes blackShapes = new BlackShapes();
        ArrayList<String> a = getMatrix();
        System.out.println(blackShapes.black(a));
    }

    private int black(ArrayList<String> a) {
        int m = a.size();
        int n = a.get(0).length();
        boolean[][] isVisited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!isVisited[i][j] && a.get(i).charAt(j)!=WHITE){
                        dfs(a,isVisited,i,j);
                        result++;
                }
            }
        }
        return result;
    }

    private void dfs(ArrayList<String> a, boolean[][] isVisited, int row, int column) {
        isVisited[row][column] = true;
        for (int i = 0; i < 4; i++) {
            int ii = row+di[i];
            int jj = column+dj[i];
            if(isValid(ii,jj,a)&& !isVisited[ii][jj]){
                dfs(a,isVisited,ii,jj);
            }
        }
    }

    private boolean isValid(int i, int j, ArrayList<String> a) {
        if( i< 0 || i>= a.size() || j<0 || j>= a.get(0).length()){
            return false;
        }
        return a.get(i).charAt(j) !=WHITE;
    }

    private static ArrayList<String> getMatrix() {
        String s1 = "OOOXOOO";
        String s2 = "OOXXOXO";
        String s3 = "OXOOOXO";
        ArrayList<String> a = new ArrayList<>(Arrays.asList(s1,s2,s3));
        return a;
    }
}
