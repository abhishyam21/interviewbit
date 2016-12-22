package maths;

/**
 * Created by Rachana Rao on 8/28/2016.
 */
public class ExcelColumnNumber {
    public static void main(String[] args) {
        String a = "BA";
        ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();
        System.out.println(excelColumnNumber.titleToNumber(a));
    }

    private int titleToNumber(String a) {
        int len = a.length();
        int count =0;
        int j=0;
        for (int i = len-1; i >= 0; i--,j++) {
            count= (int) (count+ Math.pow(26,j)*(a.charAt(i)-64));
        }
        return count;
    }
}
