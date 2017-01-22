package backtracking;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Rachana Rao on 1/22/2017.
 */

public class Sudoku{
    final int RADIX = 10;
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        ArrayList<ArrayList<Character>> a = SudokuGenerater.getSudoku();
        sudoku.solveSudoku(a);
         for (ArrayList<Character> characters : a) {
            System.out.println(characters.toString());
        }
    }

    private void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solve(a);
    }

    private boolean solve(ArrayList<ArrayList<Character>> a) {
        int row;
        int col;
        int[] blankColumn = getBlankCells(a);
        row = blankColumn[0];
        col = blankColumn[1];
        if(row ==-1) return true;

        for (int i = 1; i < 10; i++) {
            if(isValidVal(row,col,i,a)){
                char c = Character.forDigit(i, RADIX);
                a.get(row).set(col,c);
                if(solve(a)) return true;
                a.get(row).set(col,'.');
            }
        }
        return false;
    }

    private boolean isValidVal(int row, int col, int val, ArrayList<ArrayList<Character>> a) {
        return isRowValid(row,val,a) && isColumnVal(col,val,a) && isGridValid(row,col,val,a);
    }

    private boolean isGridValid(int row, int col, int val,ArrayList<ArrayList<Character>> a) {
        row/=3;col/=3;
        row*=3;col*=3;
        char res = Character.forDigit(val, RADIX);
        for (int i = row; i <(row+3) ; i++) {
            for (int j = col; j <(col+3) ; j++) {
                if(a.get(i).get(j) == res) return false;
            }
        }
        return true;
    }

    private boolean isColumnVal(int col, int val, ArrayList<ArrayList<Character>> a) {
        char res = Character.forDigit(val, RADIX);
        for (int i = 0; i < 9; i++) {
            if(a.get(i).get(col) == res) return false;
        }
        return true;
    }

    private boolean isRowValid(int row, int val, ArrayList<ArrayList<Character>> a) {
        char res = Character.forDigit(val, RADIX);
        for (int i = 0; i < 9; i++) {
            if(a.get(row).get(i) == res) return false;
        }
        return true;
    }

    private int[] getBlankCells(ArrayList<ArrayList<Character>> a) {
        int[] blankCell = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(a.get(i).get(j) == '.'){
                    blankCell[0] = i;
                    blankCell[1] = j;
                    return blankCell;
                }
            }
        }
        blankCell[0] = -1;
        blankCell[1] = -1;
        return blankCell;
    }
}

class SudokuGenerater {

    public static ArrayList<ArrayList<Character>> getSudoku() {
        String[] sudokuString = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        for (String aSudokuString : sudokuString) {
            a.add(getAsCharArray(aSudokuString));
        }
        return a;
    }

    private static ArrayList<Character> getAsCharArray(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt).collect(Collectors.toCollection(ArrayList::new));
    }
}

/*

This code is for input is of type matrix
public class Sudoku {
    private static int[][] grid;

    public static void main(String[] args) {
        */
/*grid = new int[][] { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };*//*

        grid= new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        Sudoku sudoku = new Sudoku();
        if(sudoku.solveSudoku())
            print();
        else
            System.out.println("No Answer");

    }

    private boolean solveSudoku() {
        int row,col;
        int[] blankColumn = getBlankCells();
        row = blankColumn[0];
        col = blankColumn[1];
        if(row ==-1) return true;

        for (int i = 1; i <= 9; i++) {
            if(isValid(row,col,i)){
                grid[row][col] = i;
                if(solveSudoku()) return true;
                 grid[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int val) {
        return isRowValid(row,val) && isColumnVal(col,val) && isGridValid(row,col,val);
    }

    private boolean isGridValid(int row, int col, int val) {
        row/=3;col/=3;
        row*=3;col*=3;
     */
/* row = row-row%3;
      col = col-col%3;*//*

        for (int i = row; i <(row+3) ; i++) {
            for (int j = col; j <(col+3) ; j++) {
                if(grid[i][j] == val) return false;
            }
        }
        return true;
    }

    private boolean isColumnVal(int col, int val) {
        for (int i = 0; i < 9; i++) {
            if(grid[i][col] == val) return false;
        }
        return true;
    }

    private boolean isRowValid(int row, int val) {
        for (int i = 0; i < 9; i++) {
            if(grid[row][i] == val) return false;
        }
        return true;
    }

    private int[] getBlankCells() {
        int[] blankCell = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(grid[i][j] == 0){
                    blankCell[0] = i;
                    blankCell[1] = j;
                    return blankCell;
                }
            }
        }
        blankCell[0] = -1;
        blankCell[1] = -1;
        return blankCell;
    }

    private static void print() {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) {
                System.out.println(); // for more readability
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) {
                    System.out.print(" "); // for more readability
                }
                System.out.print(grid[row][col] + " ");

            }
            System.out.println();
        }
    }
}
*/
