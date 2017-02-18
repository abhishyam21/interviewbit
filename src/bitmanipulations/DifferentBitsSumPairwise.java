package bitmanipulations;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentBitsSumPairwise {
    public static void main(String[] args) {
        Integer[] temp = {5,10,15};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        DifferentBitsSumPairwise differentBitsSumPairwise = new DifferentBitsSumPairwise();
        System.out.println(differentBitsSumPairwise.cntBits(a));
        System.out.println("----------------------------------------------------------------------");
        System.out.println(differentBitsSumPairwise.cntBits2(a));
    }

    private int cntBits(ArrayList<Integer> a) {
        int diff = 0;
        int n = a.size();
        long mod = 1000000007L;
        for (int i = 0; i < 31; i++) {
            int ones = 0;
            for (Integer integer : a)
                if((integer & (1 << i)) !=0)
                    ones++;
            diff += (2 * ones * (n-ones)) % mod;
            if(diff>=mod)diff-=mod;
        }
        return diff;
    }


    private int cntBits2(ArrayList<Integer> a) {
        int count = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            int difCount = calBitDiff(a.get(i), a.get(i + 1)) * 2;
            count += difCount;
            count %= 1000000000;
        }
        return count;
    }

    private int calBitDiff(Integer a, Integer b) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & (1 << i)) != (b & (1 << i))) {
                count++;
            }
        }
        return count;
    }
}
