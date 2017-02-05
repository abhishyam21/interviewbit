package dynamicProgramming;

import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/4/2017.
 */
public class IntersectingChordsInACircle {
    private long sum;

    public static void main(String[] args) {
        IntersectingChordsInACircle chordsInACircle = new IntersectingChordsInACircle();
        System.out.println(chordsInACircle.chordCnt(4));
      // System.out.println(chordsInACircle.chords(41));
    }

    private int chordCnt(int num) {
        long[] cache = new long[(2*num)+1];
        Arrays.fill(cache,-1);
        return (int) chordCntUtil(num,cache);
    }

    private long chordCntUtil(int num, long[] cache) {
        if(num==0) return 1;
        long res = cache[num];
        if(res != -1) return res;
        res = 0;
        for (int i = 0; i < num; i++) {
            res += (chordCntUtil(i,cache)*chordCntUtil(num-i-1,cache))%1000000007;
            if(res>=1000000007) res%=1000000007;
            cache[num] = res;
        }
        return cache[num];
    }

}

/*
{
        if(num<=1) return num;
        if(cache[num] != -1) return cache[num];
        int count =  1+chordCnt(num-1)*chordCnt(num-2);
        if(count >=1000000007){
            count%=1000000007;
        }
        cache[num] = count;
        return cache[num];
    }
 */