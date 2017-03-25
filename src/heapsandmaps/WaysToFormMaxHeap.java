package heapsandmaps;

/**
 * Created by Rachana Rao on 3/12/2017.
 */
public class WaysToFormMaxHeap {
    public static void main(String[] args) {
        WaysToFormMaxHeap waysToFormMaxHeap = new WaysToFormMaxHeap();
        System.out.println(waysToFormMaxHeap.solve(20));
    }

    private int solve(int A) {
        if(A == 0) return 0;
        if(A ==1) return 1;
        if(A >4)
            A++;
        int[] cache = new int[A+1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
        for (int i = 3; i <= A; i++) {
            cache[i] = (cache[i-1]+cache[i-2]);
        }
        return cache[A];
    }
}
