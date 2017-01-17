package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 1/15/2017.
 */
public class MaxContinuousSeriesof1s {
    public static void main(String[] args) {
        //Integer[] temp = {1,0,1,1,0,1,1,1,0,0,1,0};
        Integer[] temp = {1, 1, 0 };
        int b=2;
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        MaxContinuousSeriesof1s maxContinuousSeriesof1s = new MaxContinuousSeriesof1s();
        ArrayList<Integer> maxone = maxContinuousSeriesof1s.maxone(a, b);
        System.out.println(maxone.toString());
    }

    private ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {

        int wl = 0,wr = 0;
        int zeroCount=0,oneCount=0;
        int maxOnes = Integer.MIN_VALUE;
        int startIndex = 0,endIndex =0;
        for (int i=0; i < a.size(); i++) {
            if(a.get(i) == 1){
                wr++;
                oneCount++;
                //maxOnes = Math.max(oneCount,maxOnes);
            }if(a.get(i) == 0){
                zeroCount++;
                if(zeroCount <= b ){
                    wr++;
                }else {
                    while (zeroCount != b){
                        if(a.get(wl) == 0){
                            zeroCount--;
                        }else {
                            oneCount--;
                        }
                        wl++;
                    }
                    wr = i;
                }
            }
            if(maxOnes <= oneCount || (endIndex-startIndex) <= (wr-wl)){
                maxOnes = oneCount;
                startIndex = wl;
                endIndex = wr;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (startIndex<=(oneCount+zeroCount)){
            result.add(startIndex++);
        }
        return result;
    }
}
