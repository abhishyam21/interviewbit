package backtracking;

import java.util.ArrayList;

/**
 * Created by Rachana Rao on 1/27/2017.
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        int n=2;
        ArrayList<Integer> result = grayCode.grayCode(n);
        for (Integer aResult : result) {
            System.out.println(aResult);
        }
    }

    private ArrayList<Integer> grayCode(int a) {
        if (a == 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0);
            return temp;
        }

        ArrayList<Integer> gray = grayCode(a - 1);
        int num;

        for (int i = gray.size() - 1; i >= 0; i--) {
            num = gray.get(i);
            num |= (1 << (a - 1));
            gray.add(num);
        }

        return gray;
    }
}
