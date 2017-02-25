package hashing;

import java.text.DecimalFormat;

/**
 * Created by Rachana Rao on 2/24/2017.
 */
public class Fraction {
    public static void main(String[] args) {
        Fraction fraction = new Fraction();
        System.out.println(fraction.fractionToDecimal(2,3));
    }

    private String fractionToDecimal(int a, int b) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        double result = (double) a/b;
        return String.valueOf(decimalFormat.format(result));
    }
}
