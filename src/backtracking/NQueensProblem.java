package backtracking;

/**
 * This Solution will take Space complexity as O(N*N)
 * Created by abhishyam.c on 1/17/2017.
 */
public class NQueensProblem {

    public static void main(String[] args) {
        NQueensProblem nQueensProblem = new NQueensProblem();

        NQueensWithNbyNSpace nQueensWithNbyNSpace = nQueensProblem. new NQueensWithNbyNSpace(6);
        nQueensWithNbyNSpace.findPositions();
        System.out.println("------------------------------------------------------");
        NQueensWithNSpace nQueensWithNSpace = nQueensProblem. new NQueensWithNSpace(6);
        nQueensWithNSpace.findPositions();
    }

    class NQueensWithNbyNSpace {
        int[][] matrix;
        int N;

        public NQueensWithNbyNSpace(int n) {
            N = n;
            matrix = new int[N][N];
        }

        private void findPositions() {
            if (setQueen(0)) {
                printMatrix();
            } else System.out.println("NO ANSWER");
            // printMatrix();
        }

        private boolean setQueen(int row) {
            if (row == N) return true;
            for (int i = 0; i < N; i++) {
                if (isValidPosition(i, row)) {
                    matrix[row][i] = 1;
                    if (setQueen(1 + row)) return true;
                    else
                        matrix[row][i] = 0;
                }
            }
            return false;
        }

        private boolean isValidPosition(int column, int row) {
            return (column < N && column >= 0) &&
                    (row < N && row >= 0) &&
                    (isColumnIsSet(column) && isRowIsSet(row) && isDiagonalIsSet(row, column));
        }

        private boolean isColumnIsSet(int column) {
            for (int i = 0; i < N; i++)
                if (matrix[i][column] == 1) return false;
            return true;
        }

        private boolean isRowIsSet(int row) {
            for (int i = 0; i < N; i++)
                if (matrix[row][i] == 1) return false;
            return true;
        }

        private boolean isDiagonalIsSet(int row, int column) {
            int i = row, j = column;
            while (i < N && j < N) {
                if (matrix[i++][j++] == 1) return false;
            }
            i = row;
            j = column;
            while (i >= 0 && j >= 0) {
                if (matrix[i--][j--] == 1) return false;
            }

            i = row;
            j = column;
            while (i < N && j > 0) {
                if (matrix[i++][j--] == 1) return false;
            }

            i = row;
            j = column;
            while (i >= 0 && j < N) {
                if (matrix[i--][j++] == 1) return false;
            }
            return true;
        }

        private void printMatrix() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    class NQueensWithNSpace{
        int[] result;
        int N;

        public NQueensWithNSpace(int n) {
            N = n;
            result = new int[N];
        }

        private void findPositions() {
            if (setQueen(0)) {
                for (int aResult : result)
                    System.out.print(aResult + "\t");
                System.out.println();
            } else System.out.println("NO ANSWER");
        }

        private boolean setQueen(int position){
            if(position == N) return true;
            for (int i = 0; i < N; i++) {
                if(isValidPosition(i,position)){
                    result[position] = i;
                    if(setQueen(1+position)) return true;
                    else result[position] =0;
                }
            }
            return false;
        }

        private boolean isValidPosition(int column,int row) {
            return checkNextPosition(column,row);
        }

        //check if the any row is having same column already assigned to the queen
        //and check if  any queen is there in the diagonal of the current element
        private boolean checkNextPosition(int column, int row) {
            for (int i = 0; i < row; i++) {
                    if(result[i] == column || (Math.abs(i-row) == Math.abs(column-result[i]))) return false;
            }
            return true;
        }
    }
    }

    /*
    int prevCol = column-1;
            int nextCol = column+1;
            int prevRow = row-1;
            int nextRow = row+1;

            return //(prevCol>=0 && result[prevCol]!=1) &&
                    (nextCol < N && result[nextCol] != 1) &&
                    //(prevRow>=0 && result[prevRow]!=1) &&
                    (nextRow < N && result[nextRow] != 1) ;
     */
