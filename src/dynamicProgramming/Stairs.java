package dynamicProgramming;

import java.util.Arrays;

/**
 * Created by abhishyam.c on 2/3/2017.
 */
public class Stairs {
    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        System.out.println(stairs.climbStairs(4));
    }

    private int climbStairs(int count) {
        int[] numbers = new int[count+1];
        Arrays.fill(numbers,-1);
        return climbStairsUtil(count,numbers);
    }
    private int climbStairsUtil(int count, int[] numbers){
        if(count<=1){
            return 1;
        }
        if(numbers[count] != -1) return numbers[count];
        numbers[count] = climbStairs(count-1)+climbStairs(count-2);
        return numbers[count];
    }

}
