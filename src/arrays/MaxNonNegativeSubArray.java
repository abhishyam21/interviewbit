package arrays;

import java.util.ArrayList;

/**
 * Created by Rachana Rao on 7/24/2016.
 */
public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        /*a.add(-1);
        a.add(-1);
        a.add(5);
        a.add(0);*/
       /* a.add(1);
        a.add(2);
        a.add(5);
        a.add(-7);
        a.add(2);
        a.add(3);
        a.add(5);*/
       a.add(1967513926);
        a.add(1540383426);
        a.add(-1303455736);
        a.add(-521595368 );
        MaxNonNegativeSubArray maxNonNegativeSubArray = new MaxNonNegativeSubArray();
        System.out.println(maxNonNegativeSubArray.maxset(a));
    }

    private ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int startIndex = 0, endIndex = 0, tempStartIndex = -1;
        long count = 0, maxCount = 0;
        int negCount =0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < 0) {
                negCount++;
                count = 0;
                tempStartIndex =-1;
            } else {
                count += a.get(i);
                tempStartIndex++;
                if(maxCount < count){
                    maxCount = count;
                    startIndex = i-tempStartIndex;
                    endIndex = i;
                }else if(maxCount == count){
                    if((endIndex-startIndex) < tempStartIndex){
                        startIndex = i-tempStartIndex;
                        endIndex = i;
                    }
                }
            }
        }
        return createList(a, startIndex, endIndex,negCount);
    }

    private ArrayList<Integer> createList(ArrayList<Integer> a, int startIndex, int endIndex, int negCount) {
        if(negCount == a.size())
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            result.add(a.get(i));
        }
        return result;
    }
}
