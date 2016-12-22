package maths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rachana Rao on 8/24/2016.
 */
public class MultiplesOfNumber {
    public static void main(String[] args) {
        int a = 10240000;
        MultiplesOfNumber multiplesOfNumber = new MultiplesOfNumber();
        List<Integer> result =  multiplesOfNumber.getMultiples(a);
        for (Integer integer : result) {
            System.out.print(integer+"\t");
        }
    }

    private List<Integer> getMultiples(int a) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <=(a/2); i++) {
                if(a%i==0){
                    result.add(i);
                }
        }
        int count =1;
        ArrayList<Integer> temp  = new ArrayList<>();
        if(result.size()>0) {
            for (int j=0;j<result.size();j++) {
                Integer leastMultiple = result.get(j);
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i) % leastMultiple == 0) {
                        count++;
                    }
                    if (count == (result.size()+1)) {
                        temp.add(leastMultiple);
                        temp.add(result.size() + 1);
                        return temp;
                    }
                }
            }

        }
        return temp;
    }
}
