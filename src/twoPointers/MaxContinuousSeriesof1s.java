package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 1/15/2017.
 */
public class MaxContinuousSeriesof1s {
    ArrayList<Integer> result=  new ArrayList<>();
    public static void main(String[] args) {
        Integer[] temp = {1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0};
        //Integer[] temp = {1, 1, 0 };
        int b=4;
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        MaxContinuousSeriesof1s maxContinuousSeriesof1s = new MaxContinuousSeriesof1s();
        ArrayList<Integer> maxone = maxContinuousSeriesof1s.maxone(a, b);
        System.out.println(maxone.toString());
        System.out.println(maxContinuousSeriesof1s.result.toString());
    }

    private ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        int i=0;
        int wl=i,onesCount = i,zerosCount=i,maxOnes = Integer.MIN_VALUE;
        //This arraylist will hold all the start end end indexes of the window
            result.add(wl);
            result.add(wl);
        for(;i<a.size();i++){
            if(a.get(i) == 1)
                onesCount++;
            else {
                zerosCount++;
                //if the zeros count more than given value
                if(zerosCount>b){
                    boolean isZeroDeleted = false;
                    //move the left window until one zero is deleted from the window
                    //decrement the counts according based on 1's and 0's
                    while (!isZeroDeleted){
                        int num = a.get(wl++);
                        if(num ==1) --onesCount;
                        else {
                            isZeroDeleted = true;
                            --zerosCount;
                            result.add(wl);
                            result.add(i);
                        }
                    }
                }
            }
            //update the window sizes if the number of 1's more than expected
            int tempval = (onesCount+zerosCount);
            if(maxOnes < tempval){
                maxOnes = tempval;
                result.set(result.size()-1,i);
            }
        }
        //now find the size of the maximum window
        int left = 0,right=0;
        maxOnes = Integer.MIN_VALUE;
        for (int j = 0; j < result.size(); j=j+2) {
            left = result.get(j);
            right = result.get(j+1);
            if((right-left) > maxOnes){
                    onesCount = right;
                    zerosCount =left;
                    maxOnes = (right -left);
            }
        }
        ArrayList<Integer> ans= new ArrayList<>();
        for (int j = zerosCount; j <=onesCount ; j++) {
            ans.add(j);
        }
        return ans;
    }
}

/*
{

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
 */