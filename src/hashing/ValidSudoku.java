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
        //Check Each row
        for (int i=0;i< 9; i++) {
            String row= a.get(i);
            HashSet<Character> rowCache = new HashSet<>();
            HashSet<Character> columnCache = new HashSet<>();
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                if(c!= '.') {
                    if (rowCache.contains(c)) return 0;
                    rowCache.add(c);
                }
                //get the column position
                c = a.get(i).charAt(j);
                if(c!= '.'){
                    if(columnCache.contains(c)) return 0;
                    columnCache.add(c);
                }
            }
        }
        return 1;
    }
}
