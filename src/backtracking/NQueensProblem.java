package backtracking;

/**
 * Created by abhishyam.c on 1/17/2017.
 */
public class NQueensProblem {
    int[][] matrix;
    int N;

    public NQueensProblem(int n) {
        N = n;
        matrix = new int[N][N];
    }

    public static void main(String[] args) {
        NQueensProblem nQueensProblem = new NQueensProblem(6);
        nQueensProblem.findPositions();
    }

    private void findPositions() {
        if(setQueen(0,0)) {
            printMatrix();
        }
        else System.out.println("NO ANSWER");
       // printMatrix();
    }

    private boolean setQueen(int column, int row) {
        if(row == N) return true;
        for (int i = 0; i < N; i++) {
            if (isValidPosition(i, row)) {
                matrix[row][i] = 1;
                if (setQueen(i, 1 + row)) return true;
                else
                    matrix[row][i] = 0;
            }
        }
        return false;
    }

    private boolean isValidPosition(int column, int row) {
        return (column < N && column>=0) &&
                (row <N && row>=0) &&
                (isColumnIsSet(column) && isRowIsSet(row) && isDiagonalIsSet(row,column));
    }

    private boolean isColumnIsSet(int column){
        for (int i = 0; i < N; i++)
            if(matrix[i][column] ==1) return false;
        return true;
    }

    private boolean isRowIsSet(int row) {
        for (int i = 0; i < N; i++)
            if(matrix[row][i] ==1) return false;
        return true;
    }

    private boolean isDiagonalIsSet(int row,int column){
        int i = row,j=column;
        while (i <N && j<N) {
            if(matrix[i++][j++] == 1) return false;
        }
        i=row;j=column;
        while (i >=0 && j>=0) {
            if(matrix[i--][j--] == 1) return false;
        }

        i =row;j=column;
        while (i<N && j>0){
            if(matrix[i++][j--] == 1) return false;
        }

        i =row;j=column;
        while (i>=0 && j<N){
            if(matrix[i--][j++] == 1) return false;
        }
        return true;
    }
    private void printMatrix(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    }
