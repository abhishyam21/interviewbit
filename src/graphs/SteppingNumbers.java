package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Rachana Rao on 7/2/2017.
 */
public class SteppingNumbers {
    ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        SteppingNumbers steppingNumbers = new SteppingNumbers();
        ArrayList<Integer> stepnum = steppingNumbers.stepnum(1, 10000);
        for (Integer integer : stepnum) {
            System.out.println(integer);
        }
    }

    private ArrayList<Integer> stepnum(int m, int n) {
        for (int i = 0; i <= 9; i++)
            bfs(m, n, i);
        Collections.sort(result);
        return result;
    }

    private void bfs(int m, int n, int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        while (!queue.isEmpty()) {
            Integer steppingNumber = queue.poll();
            //if number with in range, print it
            if (steppingNumber >= m && steppingNumber <= n) {
                result.add(steppingNumber);
            }

            if (steppingNumber == 0 || steppingNumber > n) {
                continue;
            }
            int lastDigit = steppingNumber % 10;

            int stepNumberA = steppingNumber * 10 + lastDigit + 1;
            int stepNumberB = steppingNumber * 10 + lastDigit - 1;
            if (lastDigit == 0) {
                queue.add(stepNumberA);
            } else if (lastDigit == 9) {
                queue.add(stepNumberB);
            } else {
                queue.add(stepNumberA);
                queue.add(stepNumberB);
            }
        }
    }
}
