package bitmanipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 10/9/2016.
 */
public class SingleNumberII {
    public static void main(String[] args) {
        Integer[] temp = {16,16,16,22,22,22,95};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        SingleNumberII singleNumberII = new SingleNumberII();
        System.out.println(singleNumberII.singleNumber(a));
    }

    private int singleNumber(final List<Integer> a) {

        if(a==null || a.size() == 0){
            return 0;
        }
        long one=0,two=0,three=0;
        for (Integer integer : a) {
            if((one & (1<< integer)) == 0){
                one|= (1<<integer);
            }else if((two & (1<<integer)) == 0){
                two|= (1<<integer);
            }else {
                three|= (1<<integer);
            }
        }
        int count=0;
        while (((two&(1<<count)) == (one&(1<<count)))){
            count++;
        }
        return count;
    }
}
