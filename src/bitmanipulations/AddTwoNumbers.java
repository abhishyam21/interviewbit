package bitmanipulations;

/**
 * Created by Rachana Rao on 9/13/2016.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int a=15,b=5;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(addTwoNumbers.isNegitive(a));
        System.out.println(addTwoNumbers.sumofTwoNumbers(a,b));
        System.out.println(addTwoNumbers.subtractTwoNumbers(a,b));
    }

    private boolean isNegitive(int a) {
        return ((a&(1<<31) )==  (1<<31));
    }

    private int sumofTwoNumbers(int a, int b) {
        if(b==0)
            return a;
        int carry = a&b;
        a = a^b;
        b= carry<<1;
        return sumofTwoNumbers(a,b);
    }
    private int subtractTwoNumbers(int a, int b){
        if(b==0)
            return a;
        a = a^b;
        b=a&b;
        b<<= 1;
        return subtractTwoNumbers(a,b);
    }
}
