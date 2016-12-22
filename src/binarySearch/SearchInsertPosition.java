package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 10/28/2016.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        Integer[] temp = {1,3,5,6};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        int b=6;
        System.out.println(searchInsertPosition.searchInsert(a,b));
    }

    private int searchInsert(ArrayList<Integer> a, int b) {
        return binarySearch(a,b,0,a.size()-1);
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
                }else return mid;
            }
        }
        return start;
    }
}
