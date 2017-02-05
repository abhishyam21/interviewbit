package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/5/2017.
 */
public class JumpGameArray {
    public static void main(String[] args) {
        Integer arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        //Integer arr[] = {29, 0, 22, 30, 0, 7, 6, 0, 0, 0, 0, 7, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 9, 17, 7, 3, 27, 1, 17, 0, 0, 0, 0, 4, 0, 0, 0, 6, 17, 0, 0, 0, 0, 2, 0, 0, 0, 8, 0, 0, 0, 1, 13, 0, 19, 0, 0, 13, 0, 26, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 18, 0, 0, 7, 0, 6, 26, 3, 15, 0, 0, 6, 0, 25, 0, 0, 8, 0, 19, 0, 0, 0, 0, 1, 0, 26, 0, 0, 0, 26, 28, 14, 0, 0, 0, 14, 0, 0, 0, 0, 26, 0, 0, 0, 1, 0, 19, 0, 29, 9, 16, 14, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 23, 6, 0, 0, 8, 24, 0, 0, 0, 0, 11, 0, 26, 0, 19, 0, 5, 0, 29, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 10, 0, 4, 16, 29, 0, 0, 0, 0, 0, 0, 0, 21, 18, 17, 0, 0, 0, 0, 1, 0, 0, 10, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 12, 0, 0, 0, 0, 0, 0, 23, 0, 0, 14, 7, 24, 0, 0, 0, 0, 0, 0, 0, 29, 0, 8, 27, 0, 0, 0, 4, 0, 0, 0, 25, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 7, 29, 0, 0, 0, 1, 0, 4, 4, 17, 15, 0, 11, 15, 27, 23, 0, 0, 0, 2, 0, 15, 30, 26, 0, 0, 4, 0, 0, 21, 23, 0, 0, 0, 0, 19, 0, 0, 0, 0, 27, 14, 16, 0, 28, 0, 0, 0, 15, 0, 0, 7, 0, 0, 1, 0, 0, 30, 28, 0, 0, 2, 22, 20, 0, 0, 17, 8, 0, 0, 0, 11, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 27, 27, 9, 0, 7, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0, 19, 0, 4, 6, 2, 0, 0, 27, 19, 0, 14, 0, 0, 6, 0, 0, 0, 0, 0, 18, 0, 0, 0, 27, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 22, 5, 27, 24, 25, 0, 12, 0, 0, 26, 17, 5, 0, 0, 29, 21, 0, 0, 6, 3, 14, 0, 0, 0, 0, 0, 0, 11, 15, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 22, 0, 17, 22, 0, 0, 0, 1, 5, 20, 0, 0, 0, 22, 6, 21, 18, 0, 6, 7, 0, 1, 0, 0, 0, 18, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0 };
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));
        JumpGameArray jumpGameArray = new JumpGameArray();
        System.out.println(jumpGameArray.canJump(a));
    }

    private int canJump(ArrayList<Integer> a) {
        int lastIndex = a.size()-1;
        for (int i = a.size() - 1; i >= 0; i--) {
            if((i+a.get(i)) >= lastIndex){
                lastIndex = i;
            }
        }
        return lastIndex==0? 1:0;
    }
}

/*
Basic backtracking
    private boolean canJumpUtil(ArrayList<Integer> a, int position) {
        if(position == a.size()-1)
            return true;
        int lastIndex = Math.min(a.size()-1, (position+a.get(position)));
        for (int i = position+1; i <= lastIndex; i++) {
                if(canJumpUtil(a,i)) return true;
        }
        return false;
    }
 */