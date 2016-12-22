package arrays;

/**
 * Created by Rachana Rao on 9/4/2016.
 */
public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        MaximumSumSubArray maximumSumSubArray = new MaximumSumSubArray();
        maximumSumSubArray.maxSumSubArray(a);
    }

    private void maxSumSubArray(int[] a) {
            int maxSumCurrent;
            int maxSumGlobal = maxSumCurrent = a[0];
            int start =0,end=0,count=0;
            for (int i = 1; i < a.length; i++) {
                maxSumCurrent = Math.max(a[i],maxSumCurrent+a[i]);
                if(maxSumCurrent == a[i]){
                    start = i+1;
                }
                if(maxSumCurrent> maxSumGlobal){
                    maxSumGlobal = maxSumCurrent;
                    end = i+1;
                }
              //  maxSumGlobal = maxSumCurrent > maxSumGlobal? maxSumCurrent:maxSumGlobal;
            }
            System.out.println(maxSumGlobal+"\t"+start+"\t"+end);

    }
}
