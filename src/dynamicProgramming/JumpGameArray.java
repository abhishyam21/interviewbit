package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/5/2017.
 */
public class JumpGameArray {
    public static void main(String[] args) {
        Integer arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));
        JumpGameArray jumpGameArray = new JumpGameArray();
        jumpGameArray.canJump(a);
    }

    private int canJump(ArrayList<Integer> a) {
        return canJumpUtil(a,0);
    }

    private int canJumpUtil(ArrayList<Integer> a, int position) {
        if(a.get(position) == 0){
            return Integer.MAX_VALUE;
        }
        if(position== a.size()-1){
            return 0;
        }
        int sum=0;
        for (int i = 0; i < a.size(); i++) {
                sum+=canJumpUtil(a,i);

        }
    }
}
