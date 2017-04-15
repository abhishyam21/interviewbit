package binarySearch;
public class ImplementPowerFunction {
    public static void main(String[] args) {
        int x = 2, n = 8, d = 1234567;
        System.out.println("Expected "+Math.pow(x,n));
        ImplementPowerFunction implementPowerFunction = new ImplementPowerFunction();
        System.out.println(implementPowerFunction.pow(x,n,d));
    }

    private int pow(int x, int n, int d) {
     long a = x;
        long result = 1L;
        while ( n >0){
            if((n&1) == 1)//odd
                result= (result*a)%d;
                a=(a*a) %d;
            n>>=1;
        }
        result=(result+d)%d;
        return (int) result;
    }

    private long getPower(int x, int n, int d) {
        if(n==0)
            return 1;
        long temp = getPower(x,(n/2), d);
            if((n&1) == 1){//odd
                return (temp*x*temp) %d;
            }else {
                return (temp * temp) % d;
            }
    }
}
