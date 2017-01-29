package backtracking;

import java.util.ArrayList;

/**
 * problem link: https://www.interviewbit.com/problems/nqueens/
 *
 * In this problem we will generate all the solutions of the N*N matrix
 * Created by Rachana Rao on 1/29/2017.
 */
public class NQueens {
    public static void main(String[] args) {
            NQueens nQueens = new NQueens();
        ArrayList<ArrayList<String>> result = nQueens.solveNQueens(1);
        for (ArrayList<String> strings : result) {
            System.out.println(strings.toString());
        }
    }

    private ArrayList<ArrayList<String>> solveNQueens(int a) {
        char[][] mat = fillMatrix(a);
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        nQueen(mat, 0, 0,a,result);
        return result;
    }


    private void nQueen(char[][] mat, int row, int col, int n, ArrayList<ArrayList<String>> result) {
        if(row == n && col == 0){
            addResult(result,mat,n);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(row,i,n,mat)){
                mat[row][i] = 'Q';
                nQueen(mat,row+1,0,n, result);
                mat[row][i] = '.';
            }
        }
    }

    private void addResult(ArrayList<ArrayList<String>> result, char[][] mat, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(builder.length()>0)
                builder.append(" ");
            for (int j = 0; j < n; j++) {
                builder.append(mat[i][j]);
            }
        }
            ArrayList<String> temp = new ArrayList<>();
            temp.add(builder.toString());
            result.add(temp);
    }

    private char[][] fillMatrix(int a) {
        char[][] mat = new char[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                mat[i][j] = '.';
            }
        }
        return mat;
    }
    private boolean isValid(int row, int col, int n, char[][] mat) {
        // return false if two queens share the same column
        for (int i = 0; i < row; i++)
            if (mat[i][col] == 'Q')
                return false;

        // return false if two queens share the same \ diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (mat[i][j] == 'Q')
                return false;

        // return false if two queens share the same / diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++)
            if (mat[i][j] == 'Q')
                return false;

        return true;
    }
}
