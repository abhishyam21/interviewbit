package hashing;

import java.util.*;

/**
 * Created by Rachana Rao on 2/23/2017.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        String[] temp = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        List<String> a = new ArrayList<>(Arrays.asList(temp));
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(a));
    }

    private int isValidSudoku(List<String> a) {
        List<Character> rowCache = new ArrayList<>(9);
        List<Character> columnCache = new ArrayList<>(9);
        List<Character> blockCache = new ArrayList<>(9);
        fill(rowCache);
        fill(columnCache);
        fill(blockCache);
        for (int i=0;i< 9; i++) {
            for (int j = 0; j < 9; j++) {
                //get the row position
                char c = a.get(i).charAt(j);
                if(rowCache.get(i) ==c || columnCache.get(j) ==c || blockCache.get((i/3)*3+(j/3)) ==c) return 0;
                rowCache.set(i,c);
                columnCache.set(j,c);
                blockCache.set((i/3)*3+(j/3),c);
            }
        }
        return 1;
    }

    private void fill(List<Character> rowCache) {
        for (int i = 0; i < 9; i++) {
            rowCache.add(i,'0');
        }
    }
}
