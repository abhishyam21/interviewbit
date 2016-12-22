package maths;

/**
 * Created by Rachana Rao on 8/28/2016.
 */
public class PalindromeInteger {
    public static void main(String[] args) {
        int a=123321;
        PalindromeInteger palindromeInteger = new PalindromeInteger();
        System.out.println(palindromeInteger.isPalindrome(a));
    }

    private boolean isPalindrome(int a) {

            int reverseNumber = 0;
            int temp = a;
            while (temp>0){
                reverseNumber=reverseNumber*10+temp%10;
                temp/=10;
            }
            return reverseNumber == a;

    }
}
