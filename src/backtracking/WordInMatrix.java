package test.com.backtracking;

/**
 * problem link http://algorithms.tutorialhorizon.com/backtracking-search-a-word-in-a-matrix/
 * Created by abhishyam.c on 1/23/2017.
 */
public class WordInMatrix {
    private static int[][] sol;
    private static int N;
    public static void main(String[] args) {
        char[][] matrix = { { 't', 'z', 'x', 'c', 'd' },
                { 'a', 'h', 'n', 'z', 'x' }, { 'h', 'w', 'o', 'i', 'o' },
                { 'o', 'r', 'n', 'r', 'n' }, { 'a', 'b', 'r', 'i', 'n' } };
        N= matrix.length;
        sol = new int[N][N];
        String searchString = "horizon";
        if(findWord(matrix,searchString))
        print();
        else System.out.println("No Word found");
    }

    private static boolean findWord(char[][] matrix, String searchString) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                    if(findSol(matrix,searchString,i,j,0)) return true;
            }
        }
        return false;
    }

    private static boolean findSol(char[][] matrix, String searchString, int row, int col,int wordPos) {
        if(wordPos >= searchString.length()){
            return true;
        }
        //if solution matrix is already set then return false
        if(sol[row][col] != 0) return false;
        //if searchString position is not equal to matrix current position return false;
        if(matrix[row][col] != searchString.charAt(wordPos)) return false;

            sol[row][col] = wordPos+1;
            //down
            if((row+1) < N && findSol(matrix,searchString,row+1,col,wordPos+1)) return true;
            //up
            if((row-1) >= 0 && findSol(matrix,searchString,row-1,col,wordPos+1)) return true;
            //forward
            if((col+1) < N && findSol(matrix,searchString,row,col+1,wordPos+1)) return true;
            //diagonal
            if((row+1) < N && (col+1) < N && findSol(matrix,searchString,row+1,col+1,wordPos+1)) return true;
            //back
            if((col-1) >= 0 && findSol(matrix,searchString,row,col-1,wordPos+1)) return true;
            sol[row][col] = 0;
            return false;
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
}
