package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by abhishyam.c on 1/9/2017.
 */
public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        Integer[] temp1 = {1,2,3,3,4,5,6};
        Integer[] temp2 = {3,3,5};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(temp2));
         IntersectionOfSortedArrays intersectionOfSortedArrays = new IntersectionOfSortedArrays();
        ArrayList<Integer> arrayList = intersectionOfSortedArrays.intersectionOfSortedArrays(a, b);
        System.out.println(arrayList.toString());
    }

    private ArrayList<Integer> intersectionOfSortedArrays(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i=0,j=0;
        int m=a.size(),n=b.size();
        ArrayList<Integer> result = new ArrayList<>();
        while (i<m && j<n){
            if(a.get(i) < b.get(j))
                i++;
            else if(a.get(i) > b.get(j))
                j++;
            else if(Objects.equals(a.get(i), b.get(j))){
                result.add(a.get(i));
                i++;j++;
            }
        }
        return result;
    }
}
