package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/5/2017.
 */
public class MinJumpsArray {
    public static void main(String[] args) {
        //Integer arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        Integer arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));
        MinJumpsArray minJumpsArray = new MinJumpsArray();
        System.out.println(minJumpsArray.jump(a));
    }

    private int jump(ArrayList<Integer> a) {
        if (a == null || (a.size() > 1 && a.get(0) == 0))
            return -1;
        if (a.size() == 1)
            return 0;
        int ladders = a.get(0);
        int steps = a.get(0);
        int jumps = 1;
        for (int i = 1; i <a.size()-1 ; i++) {
            if(i == a.size()-1) return jumps;
                //check the size of ladder and update it
            if(ladders < (a.get(i)+i)){
                ladders = a.get(i)+i;
            }
            steps--;
            if(steps == 0){
                jumps++;
                steps = ladders-i;
            }
        }
        return jumps;
    }

}
