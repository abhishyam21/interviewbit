package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rachana Rao on 9/5/2016.
 */
public class NebHighestNumber {
    public static void main(String[] args) {
        Integer[] temp = {7,3,6,5};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        System.out.println(a.toString());
        System.out.println("-------------------------");
        NebHighestNumber nexHighestNumber = new NebHighestNumber();
        nexHighestNumber.nextNumber(a);
        System.out.println(a);
    }

    private void nextNumber(ArrayList<Integer> a) {
        boolean hasGraterNumber =false;
        int min = Integer.MAX_VALUE;
        for (int i = a.size()-1; i >0 ; --i) {
            if(a.get(i) > a.get(i-1)){
               int temp = a.get(i);
                a.add(i,a.get(i-1));
                a.remove(i+1);
                a.add(i-1,temp);
                a.remove(i);
                if(min != Integer.MAX_VALUE){
                    a.add(i,a.get(min));
                    a.remove(i+1);
                    a.add(min,temp);
                    a.remove(min+1);
                }
                hasGraterNumber = true;
                break;
            }else {
                if(a.get(i) < min){
                    min = i;
                }
            }
        }
        if(!hasGraterNumber){
            Collections.sort(a);
        }
    }

    private int swap(int[] array, int i, int i1) {
        int temp = array[i];
        array[i] = array[i1];
        array[i1] = temp;
        int num=0;
        for (int j = 0; j <array.length ; j++) {
                num =num*10+array[j];
        }
        return num;
    }

    private int[] getNumbersFromStringArray(String a) {
        int[] numberArray = new int[a.length()];
        char[] c = a.toCharArray();
        for (int i=0;i<c.length;i++) {
                numberArray[i] = c[i]-48;
        }
        return numberArray;
    }
}
