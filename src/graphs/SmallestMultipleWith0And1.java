package graphs;

import java.math.BigInteger;

/**
 * Created by Rachana Rao on 3/25/2017.
 */
public class SmallestMultipleWith0And1 {
    public static void main(String[] args) {
        int a = 55;
        SmallestMultipleWith0And1 smallestMultipleWith0And1  = new SmallestMultipleWith0And1();
        System.out.println(smallestMultipleWith0And1.multiple(a));
    }

    private String multiple(int a) {
        BigInteger bigInteger = new BigInteger(String.valueOf(a));
        while (!isValid(bigInteger)){
            bigInteger = bigInteger.add(new BigInteger(String.valueOf(a)));
        }
        return bigInteger.toString();
    }

    private boolean isValid(BigInteger bigInteger) {
        String number = bigInteger.toString();
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) != '0' && number.charAt(i) !='1') return false;
        }
        return true;
    }
}
