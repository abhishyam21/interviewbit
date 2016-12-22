package maths;

/**
 * Created by Rachana Rao on 8/28/2016.
 */
public class Reverseinteger {
    public static void main(String[] args) {
        int a = 001;
        Reverseinteger reverseinteger = new Reverseinteger();
        System.out.println(reverseinteger.reverse(a));
    }

    private int reverse(int a) {
        int reverseNumber = 0;
        int temp;
        if(a<0)
        temp = -a;
            else temp = a;
        while (temp>0){
            int digit = temp%10;
            reverseNumber=reverseNumber*10+digit;
            if((reverseNumber>Integer.MAX_VALUE/10) || ((reverseNumber == Integer.MAX_VALUE / 10) && digit > Integer.MAX_VALUE % 10 ) )
                return 0;
            temp/=10;
        }
        return  a>0?reverseNumber:-reverseNumber;
    }
}
