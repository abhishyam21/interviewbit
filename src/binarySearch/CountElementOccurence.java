package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountElementOccurence {
    public static void main(String[] args) {
        Integer[] temp = {1, 1, 2, 2, 2, 2};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        int b = 1;
        CountElementOccurence countElementOccurence = new CountElementOccurence();
        System.out.println(countElementOccurence.findCount(a,b));
    }

    private int findCount(List<Integer> a, int b) {
        int start = 0, end = a.size()-1;

        int startPosition =  binarySearch(a,b,start,end,true);
        if(startPosition == -1)
            return 0;
        int endPosition = binarySearch(a,b,start,end,false);
        System.out.println(startPosition+"====="+endPosition);
        return endPosition - startPosition+1;
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
}
