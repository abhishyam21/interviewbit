package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 10/28/2016.
 */
public class BinarySearch {
    public static void main(String[] args) {
        Integer[] temp = {1,2,13,44,55,78,86};
        int b = 62;
        List<Integer> list = new ArrayList<>(Arrays.asList(temp));
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(list,b,0, list.size()-1));
        System.out.println(binarySearch.getPositionOfPivot(list,54));
    }

    private int binarySearch(List<Integer> a, int b, int start, int end) {
        while (start <=end){
            int mid = (start+end)/2;
            if(a.get(mid) == b)
                return mid;
            else {
                if(a.get(mid) < b){
                    start=mid+1;
                }else if(a.get(mid) > b){
                    start= 0;
                    end = mid-1;
                }else return -1;
            }
        }
        return -1;
    }


    private int getPositionOfPivot(List<Integer> b, int midval) {
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
}
