package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 9/4/2016.
 */
public class NextPermutation {
    public static void main(String[] args) {
        String a = "010";
        NextPermutation nextPermutation = new NextPermutation();
        ArrayList<Integer> result = nextPermutation.nextPermutation(a);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private ArrayList<Integer> nextPermutation(String A) {
          char[] array = A.toCharArray();
            int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = array[i]=='0'?1:0;
        }
        int start = 0,end=0;
        int currentMax=intArray[0],summaryMax=intArray[0];
        for (int i = 1; i < intArray.length; i++) {
                currentMax = Math.max(intArray[i],currentMax+intArray[i]);
                if(currentMax == intArray[i]){
                    start=i+1;
                }
                if(summaryMax<currentMax){
                    summaryMax = currentMax;
                    end=i+1;
                }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(start!=0 && end!=0) {
            result.add(start);
            result.add(end);
        }
        return result;
    }
}
