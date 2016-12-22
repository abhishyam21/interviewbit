package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedArray {
    public static void main(String[] args) {
        Integer[] temp = { 9, 10, 12, 13, 24, 26, 27, 28, 29, 43, 48, 51, 54, 56, 57, 59, 62, 66, 70, 71, 72, 74, 75, 77, 78, 81, 83, 85, 87, 88, 89, 90, 91, 92, 93, 97, 98, 99, 101, 102, 104, 105, 107, 112, 113, 115, 123, 126, 127, 132, 133, 134, 135, 136, 143, 144, 148, 150, 151, 152, 154, 159, 160, 161, 163, 167, 169, 170, 174, 176, 177, 179, 180, 181, 183, 185, 186, 187, 188, 193, 194, 196, 197, 198, 199, 200, 203, 1, 6, 7, 8 };
        RotatedArray rotatedArray = new RotatedArray();
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        System.out.println(rotatedArray.findMin(a));
    }

    private int findMin(List<Integer> a) {
        int position=  binarySearch(a,0,a.size()-1);
        return a.get(position);
    }

    private int binarySearch(List<Integer> a, int start, int end) {
        int mid = 0;
        int n = a.size();
        while (start <= end) {
            if(a.get(start) <= a.get(end)) return start;
             mid = (start + end) / 2;
            int next = (mid+1) % n;
            int prev = (mid+n-1) % n;
            if(a.get(mid) <= a.get(prev) && a.get(mid) <= a.get(next))
                return mid;
            else {
                if(a.get(mid) >= a.get(start)){
                    start = mid+1;
                }else if(a.get(mid) <= a.get(end)){
                    end = mid-1;
                }
            }
        }
        return mid;
    }
}
