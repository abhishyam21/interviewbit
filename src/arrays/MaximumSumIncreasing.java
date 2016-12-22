package arrays;

/**
 * Created by Rachana Rao on 8/4/2016.
 */
public class MaximumSumIncreasing {
    public static void main(String[] args) {
        int[] a = {3,1,4,2,1,8,9};
        System.out.println(printMaxSum(a));
    }

    private static int printMaxSum(int[] a) {
        int size = a.length;
        if(size == 0){
            return 0;
        }
        int max = a[0],sum=a[0];
        for (int i = 1; i < size; i++) {
            if(a[i] >= a[i-1]){
                sum += a[i];
            }else {
                sum = a[i];
            }
            max = sum>max?sum:max;
        }
        return max;
    }
}
