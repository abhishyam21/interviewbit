package bitmanipulations;

/**
 * Created by Rachana Rao on 9/13/2016.
 */
public class DivideNumbers {
    public static void main(String[] args) {
        int a = -2147483648, b = -1;
        DivideNumbers divideNumbers = new DivideNumbers();
        System.out.println(divideNumbers.divide(a, b));
    }

    private int divide(int dividend, int divisor) {
        if(divisor == 1){
            return dividend;
        }else if(divisor == -1){
            if(dividend  == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }else
            return -dividend;
        }
        long one,two;
        if(dividend == Integer.MIN_VALUE){
            one = Integer.MAX_VALUE;
            one++;
        }else {
            one = isNegitive(dividend) ? -dividend : dividend;
        }
         two = isNegitive(divisor) ? -divisor : divisor;
        Long count = new Long(0);
        while (one >= two) {
            one = one - two;
            count++;
           /* if(count > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }*/
        }
        count = one == 0 ? count : count + 1;
        if (isNegitive(dividend) && isNegitive(divisor)) {
            return count.intValue();
        } else if (isNegitive(dividend) || isNegitive(divisor)) {
            return -count.intValue();
        } else
            return count.intValue();
    }

    /*private int subtractTwoNumbers(int a, int b){
        if(b==0)
            return a;
        a = a^b;
        b=a&b;
        b<<= 1;
        return subtractTwoNumbers(a,b);
    }*/

    private boolean isNegitive(int a) {
        return ((a & (1 << 31)) == (1 << 31));
    }
}
