package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 1/21/2017.
 */
public class GenerateAllParenthesesIi {
    private static String OPEN_PARENTHESIS = "(";
    private static String CLOSED_PARENTHESIS = ")";
    private ArrayList<String> result;
    public static void main(String[] args) {
        GenerateAllParenthesesIi generateAllParenthesesIi = new GenerateAllParenthesesIi();
        int n = 3;
        ArrayList<String> arrayLists = generateAllParenthesesIi.GenerateAllParentheses(n);
        for (String str : arrayLists) {
            System.out.println(str);
        }
    }

    private ArrayList<String> GenerateAllParentheses(int a) {
        result = new ArrayList<>();
        subset("", a, a);
        return result;
    }

    private void subset(String par,  int openCount, int closedCount) {
        if (closedCount == 0 && openCount ==0) {
            result.add(par);
            return;
        }
        if(openCount > closedCount)  return;
            if (openCount > 0) {
                subset(par+OPEN_PARENTHESIS, openCount - 1, closedCount);
            }
            if (closedCount > 0) {
                subset(par+CLOSED_PARENTHESIS, openCount, closedCount - 1);
            }

    }

    /*   private void subset(int pos, int n, int openCount, int closedCount) {

        if (closedCount == n) {
            result.add(Arrays.toString(par));
            return;
        }
        if (openCount > closedCount) {
            par[pos] = ')';
            subset(1+pos, n, openCount, 1 + closedCount);
        }
        if (openCount < n) {
            par[pos] = '(';
            subset(1+pos, n, 1 + openCount, closedCount);
        }

    }*/
}