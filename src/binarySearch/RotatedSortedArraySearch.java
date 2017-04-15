package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
      //  Integer[] temp = {194, 195, 196, 197, 198, 199, 201, 203, 204, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 39, 40, 42, 43, 44, 45, 47, 48, 49, 50, 51, 52, 53, 54, 55, 57, 58, 59, 60, 61, 63, 65, 66, 68, 69, 70, 71, 73, 74, 76, 77, 79, 80, 81, 82, 83, 84, 86, 87, 88, 89, 91, 92, 93, 94, 95, 97, 98, 99, 101, 103, 104, 105, 106, 107, 108, 109, 110, 113, 114, 115, 117, 118, 120, 121, 122, 123, 124, 127, 128, 130, 131, 133, 134, 135, 136, 137, 139, 140, 141, 142, 143, 144, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 158, 159, 160, 161, 162, 163, 164, 166, 167, 169, 170, 171, 172, 174, 175, 177, 178, 179, 181, 182, 184, 185, 187, 189, 190, 192, 193};
       // Integer[] temp = {101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        Integer[] temp = {1, 7, 67, 133, 178};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        int b = 1;
        RotatedSortedArraySearch rotatedSortedArraySearch = new RotatedSortedArraySearch();
        System.out.println(rotatedSortedArraySearch.search(a,b));
        System.out.println(approach2(a,b));
    }

    /**
     * This is different approach for same problem
     * @param a
     * @param b
     * @return
     */
    private static int approach2(ArrayList<Integer> a, int b) {
        int l = 0, h = a.size()-1;
        while ( l <= h) {
            int mid = (l+h)/2;
            if(a.get(mid) == b) return mid;
            //if left array is sorted
            if(a.get(l) <= a.get(mid)) {
                //element is present in the right side of the array
                if(a.get(mid) >= b && a.get(l) <= b )
                    h = mid-1;
                //element in left side of the array
                else l = mid+1;
            }else//right array is sorted
            if( b >= a.get(mid) && b <= a.get(h))
                l=mid+1;
             else h = mid-1;
        }
        return -1;
    }

    private int search(List<Integer> a, int b) {
        int getLeastNumber = getLeastNumberInArray(a);
        if(a.get(getLeastNumber) == b) return getLeastNumber;
        int position = binarySearch(a,b,getLeastNumber,a.size()-1);
        if(position != -1)
            return position;
        return binarySearch(a,b,0,getLeastNumber);

    }

    private int binarySearch(List<Integer> a, int b, int start, int end) {
        while (start <= end){
            int mid = (start+end)/2;
            if(a.get(mid) == b)
                return mid;
            else {
                if(a.get(mid) < b)
                    start= mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }

    private int getLeastNumberInArray(List<Integer> a) {
        int mid = -1;
        int start = 0, end = a.size()-1;
        int n = a.size();
        while (start <= end){
            mid = (start+end) /2;
            if(a.get(start) <= a.get(end)) return start;
            int next = (mid+1)%n;
            int prev = (mid+n-1) % n;
            if(a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev))
                return mid;
            else {
                if(a.get(mid) <= a.get(start)) {
                    end = mid - 1;
                }else
                    if(a.get(mid) >= a.get(start)){
                        start = mid+1;
                    }
                }
            }
        return mid;
    }
}
