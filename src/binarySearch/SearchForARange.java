package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForARange {
    public static void main(String[] args) {
        Integer[] temp = {1};
        int b = 1;
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        SearchForARange searchForARange = new SearchForARange();
        System.out.println(searchForARange.searchRange(a,b));
    }

    private ArrayList<Integer> searchRange(final List<Integer> a,int b) {
        ArrayList<Integer> list = new ArrayList<>();
            int leftPosition = binarySearch(a,b,0,a.size()-1,true);
        if(leftPosition == -1) {
            list.add(-1);
            list.add(-1);
            return list;
        }
        int rightPosition = binarySearch(a,b,0,a.size()-1,false);
            list.add(leftPosition);
            list.add(rightPosition);
        return list;
    }

    private int binarySearch(List<Integer> a, int b, int start, int end, boolean isStart) {
        int position = -1;
        while (start <= end){
            int mid = (start+end)/2;
            if(a.get(mid) == b) {
                if (isStart)
                    end = mid - 1;
                else
                    start = mid + 1;
                position = mid;
            }
            else {
                if(a.get(mid) < b){
                    start=mid+1;
                }else if(a.get(mid) > b){
                    start= 0;
                    end = mid-1;
                }else return -1;
            }
        }
        return position;
    }

/*
    private ArrayList<Integer> binarySearch(List<Integer> a, int b, int start,int end){
        ArrayList<Integer>  result = new ArrayList<>();
        int mid = (start+end)/2;
        if(a.get(mid) == b){
            result.add(getLeftPosition(a,mid,b));
            result.add(getRightPosition(a,mid,b));
            return result;
        }else {
            if(a.get(mid) < b){
                return binarySearch(a,b,mid+1,end);
            }else if(a.get(mid) > b){
                return binarySearch(a,b,0,mid-1);
            }else {
                result.add(-1);
                result.add(-1);
                return result;
            }
        }
    }*/

    private Integer getRightPosition(List<Integer> a, int mid, int b) {
        for (int i = mid; i <a.size() ; i++) {
            if(a.get(i) != b)
                return i-1;
        }
        return a.size()-1;
    }

    private Integer getLeftPosition(List<Integer> a, int mid, int b) {
        for (int i = mid; i >=0 ; i--) {
            if(a.get(i) != b)
                return i+1;
        }
        return 0;
    }

}
