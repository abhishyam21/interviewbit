package maths;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rachana Rao on 8/28/2016.
 */
public class ExcelColumnTitle {
    public static void main(String[] args) {
        int a = 943566;
        ExcelColumnTitle excelColumnTitle = new ExcelColumnTitle();
        System.out.println(excelColumnTitle.convertToTitle(a));
    }

    private String convertToTitle(int a) {
        char[] array = new char[26];
        for (int i = 0; i < 26; i++) {
            array[i] = (char) ('A' + i);
        }

        String result = "";
        while (a > 0) {
            int diff = (a - 1) % 26;
            a = (a - 1) / 26;
            result = array[diff] + result;
        }

        return result;
    }


}
