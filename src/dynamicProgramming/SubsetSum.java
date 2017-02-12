package dynamicProgramming;

/**
 * problem link: http://www.techiedelight.com/subset-sum-problem/
 * Created by Rachana Rao on 2/12/2017.
 */
public class SubsetSum {
    public static void main(String[] args) {
        int[] a = {7,3,2,5,8};
        int sum = 14;
        System.out.println(subsetSumUtil(a,sum,0));
    }

    private static boolean subsetSumUtil(int[] a, int sum, int pos) {
        //return true is sum == 0
        if(sum == 0) return true;
        //return false if sum is less than zero or pos is less than 0
        if(pos <0 || sum<0 ) return false;
            sum-=a[pos];
          subsetSumUtil(a,sum,pos+1);
        return false;
    }
}
