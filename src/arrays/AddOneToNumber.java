package arrays;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Rachana Rao on 7/24/2016.
 */
public class AddOneToNumber {
    public static void main(String[] args) {
        Integer[] temp = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
            ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(temp));
        AddOneToNumber addOneToNumber = new AddOneToNumber();
        System.out.println(addOneToNumber.plusOne(a));
    }

    private ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        BigDecimal sum = new BigDecimal("0");
        for (Integer num : a) {
            sum = sum.multiply(new BigDecimal("10")).add(new BigDecimal(String.valueOf(num)));
        }
        sum = sum.add(new BigDecimal("1"));
        String temp = String.valueOf(sum);
        a= new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            a.add(i, temp.charAt(i) - 48);
        }
        return a;
    }
}
