package bitmanipulations;

import java.math.BigDecimal;
import java.util.BitSet;

/**
 * Created by Rachana Rao on 9/11/2016.
 */
public class Numberof1Bits {
    public static void main(String[] args) {
        long a = 6;
        Numberof1Bits numberof1Bits = new Numberof1Bits();
        System.out.println(numberof1Bits.numSetBits(a));
    }

    private long numSetBits(long a) {
        long rev = 0;
        for (int i = 0; i < 32;  i++) {
            rev <<= 1;
            if ((a & (1 << i)) != 0)
                rev |= 1;
        }

        return rev;
    }
}
