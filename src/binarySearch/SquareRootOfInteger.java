package binarySearch;
public class SquareRootOfInteger {
    public static void main(String[] args) {
        int a = 2147483647;
        SquareRootOfInteger squareRootOfInteger = new SquareRootOfInteger();
        System.out.println(squareRootOfInteger.sqrt(a));
    }

    private int sqrt(int a) {
        if(a == 0 || a==1)
            return a;
            long start = 0;
        long end = a;
        while (start <= end){
            Long mid ;
            mid =  (start + end)/2;
        if(mid ==  a/mid){
                return mid.intValue();
            }else {
                if((mid * mid) < a && ((mid+1) *(mid+1)) >a)
                    return mid.intValue();
                if((mid*mid) < a) start = mid+1;
                else if((mid * mid) > a) end = mid-1;
            }
        }
        return -1;
    }
}
