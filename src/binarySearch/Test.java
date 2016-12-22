package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Rachana Rao on 11/11/2016.
 */
public class Test {
    public static void main(String[] args) {
        Integer[] temp1 = {-50, -41, -40, -19, 5, 21, 28};
        Integer[] temp2 = {-50, -21, -10};

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(temp2));
        Test test = new Test();
        System.out.println(test.median(a,b));
    }

    private double median(ArrayList<Integer> a, ArrayList<Integer> b) {
        int m = a.size();
        int n = b.size();
        int sum = (m+n)/2;
        if(((m+n) & 1) == 1){
            return getMedian(sum,a,b);
        }else return (getMedian(sum,a,b)+getMedian((sum+1),a,b))/2.0;
    }

    private int getMedian(int median, List<Integer> a, List<Integer> b) {
        int start = 0;
        int end = a.size()-1;
        while (start<=end){
            int mid = (start+end)/2;
            int lessnumbers = binarySearch(a.get(mid),a);
            lessnumbers+=binarySearch(a.get(mid),b);
            if(lessnumbers == median)
                return a.get(mid);
            else {
                if(lessnumbers < median){
                    start = mid+1;
                }else if(lessnumbers > median)
                    end = mid-1;
            }
        }
        return -1;
    }

    private int binarySearch(int b, List<Integer> a) {
        int start = 0;
        int end = a.size()-1;
        while (start <=end){
            int mid = (start+end)/2;
            if(Objects.equals(a.get(mid), b))
                return mid+1;
            else {
                if(a.get(mid) < b){
                    start=mid+1;
                }else if(a.get(mid) > b){
                 //   start= 0;
                    end = mid-1;
                }else return mid;
            }
        }
        return start;
    }
}
