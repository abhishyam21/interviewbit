package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 11/1/2016.
 */
public class MedianOfArray {
    public static void main(String[] args) {
        Integer[] temp1 = {-50, -41, -40, -19, 5, 21, 28 };
        Integer[] temp2 = {-50, -21, -10};

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(temp2));
        MedianOfArray medianOfArray = new MedianOfArray();
        System.out.println(medianOfArray.findMedianSortedArrays(a,b));
    }

    private double findMedianSortedArrays(List<Integer> a, List<Integer> b) {
        int sum = (a.size()+b.size());
        int medianPosition = (sum)/2;
        if((sum & 1) ==1){
            return fun(a,b,medianPosition,true);
        }else return fun(a,b,medianPosition,false);
        /*if((sum&1) ==1)
           return fun(a,b,medianPosition);
        else {
            int oddSum = fun(a,b,medianPosition);
            int evenSum = fun(a,b,1+medianPosition);
            return (double) (oddSum+evenSum)/2;
        }*/
    }

    private double fun(List<Integer> a, List<Integer> b, int median, boolean isOdd){
        int start1 = 0;
        int start2 = 0;
        int end1 = a.size();
        int end2 = b.size();
        while (true) {
            int mid1 = (start1 + end1) / 2;
            int mid2 = (start2 + end2) / 2;
            int sum = (mid1 + mid2);
            if (sum == median) {
                if(isOdd)
                return mid1 > mid2 ? a.get(mid1 - mid2) : b.get(mid2 - mid1);
                else {
                    double res = 0;
                    if(mid1 > mid2){
                        res = a.get(mid1 - mid2);
                        res+=b.get(mid2+1);
                        return res/2;
                    }else {
                        res = b.get(mid1-mid2);
                        res+=a.get(mid1);
                        return res/2;
                    }
                }
            }
            else {
                if (sum < median) {
                    start1 = mid1 + 1;
                    start2 = mid2 + 1;
                } else if (sum > median) {
                    end1 = mid1 - 1;
                    end2 = mid2 - 1;
                }
            }
        }
    }

    private int binarySearch(List<Integer> a, List<Integer> b, int medianPosition) {

        while (true){
            int start  = 0;
            int end = a.size();
            int mid = (start+end) /2;
            int midval = a.get(mid);
            int bArrayPosition = binarySearch(b,midval);
            if(midval+bArrayPosition == medianPosition)
              //  return getMedianPosition(a,b,medianPosition);
            return -1;
        }
    }


    private int binarySearch(List<Integer> b, int midval) {
        int start = 0;
        int end = b.size()-1;
        int n = b.size();
        int mid = 0;
        while (start <= end){
            mid = (start+end)/2;
            if(b.get(mid) == midval)
                return mid;
            int next = (mid+1) % n;
            int prev = (mid+n-1) % n;
            if(midval > b.get(prev) && midval< b.get(mid) )
                return mid;
            else if(b.get(mid) > midval && b.get(next)< midval)
                return next;
            else {
                if(b.get(mid) <= midval){
                    start=mid+1;
                }
                else if(b.get(mid) >= mid)
                    end = mid-1;
            }
        }
        return mid;
    }

    private int getPositionOfPivot(List<Integer> a, List<Integer> b, int mid, int medianPosition) {
        int left = 0, right = 0;
        int midValue = a.get(mid);
        for (Integer anA : a) {
            if (midValue <= anA)
                left++;
                else right++;
        }
        for (Integer aB : b) {
            if (midValue <= aB)
                left++;
            else right++;
        }
       return medianPosition >= left? left:right;
    }
}
