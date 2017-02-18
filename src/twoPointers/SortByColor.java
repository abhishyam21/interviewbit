package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 1/7/2017.
 */
public class SortByColor {
    public static void main(String[] args) {
        Integer[] temp = {1,2,0,2,2,2,2,0,1,1,0,0};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        SortByColor sortByColor = new SortByColor();
        sortByColor.sortColors(a);
        System.out.println(a.toString());
    }

    private void sortColors(ArrayList<Integer> a) {
        int zero = 0;
        int two = a.size()-1;
        int i=0;
        while (i <= two){
            if(a.get(i) == 0){
                swap(a,i,zero);
                zero++;
            }if(a.get(i) ==2){
                swap(a,(i),two);
                two--;
                i--;
            }
            i++;
        }
    }


    private void swap(ArrayList<Integer> a, int i, int zeroPos) {
        int temp = a.get(i);
        a.set(i,a.get(zeroPos));
        a.set(zeroPos,temp);
    }
    /* approach 1
    private void sortColors(ArrayList<Integer> a) {
        if(a.size()>1){
            int i=0,size =a.size();
            //bring all the zeros to start
            int position = sortValues(a, i, size, 0);
            //bring all the 1s next to zeros
            position = sortValues(a,position,size,1);
            //finally all the twos will be sorted in order
        }
    }

    private int sortValues(ArrayList<Integer> a, int i, int size, int val) {
        while (i<size && a.get(i) == val)
            i++;
        int zeroPos = i;
        while (i<size){
            if(a.get(i) == val){
                swap(a,i,zeroPos);
                zeroPos++;
            }
            i++;
        }
        return zeroPos;
    }
*/
}
