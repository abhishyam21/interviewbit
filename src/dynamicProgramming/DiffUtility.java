package dynamicProgramming;

import java.util.Arrays;

import static dynamicProgramming.LongestCommonSubSequence.dp1;
import static dynamicProgramming.LongestCommonSubSequence.sol;

/**
 * Problem Link:
 * https://www.techiedelight.com/implement-diff-utility/
 * Created by Rachana Rao on 4/1/2017.
 */
public class DiffUtility {
    public static void main(String[] args) {
        String X = "ABCDFGHJQZ";
        String Y = "ABCDEFGIJKRXYZ";
        dp1(X, Y);
        System.out.println("    " + Arrays.toString(Y.toCharArray()));
        int i = -1;
        for (int[] ints : sol) {
            if (i >= 0)
                System.out.print(X.charAt(i));
            else
                System.out.print(" ");
            System.out.println(Arrays.toString(ints));
            i++;
        }
        int m = sol.length - 1;
        int n = sol[0].length - 1;
        printList(X, Y, m, n);
    }

    private static void printList(String x, String y, int m, int n) {
        if (m == 0 && n == 0) return;
        if (x.charAt(m - 1) == y.charAt(n - 1)) {//if both the characters are matching
            printList(x, y, m - 1, n - 1);
            System.out.print(" " + x.charAt(m - 1));
        } else if (sol[m][n - 1] >= sol[m - 1][n]) { //Y character is missing from x
            printList(x, y, m, n - 1);
            System.out.print(" +" + y.charAt(n - 1));
        } else if (sol[m][n - 1] <= sol[m - 1][n]) {//X character is missing from y
            printList(x, y, m - 1, n);
            System.out.print(" -" + x.charAt(m - 1));
        }
    }

}
