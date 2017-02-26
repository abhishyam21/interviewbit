package dynamicProgramming;

/**
 * for detail explanation
 * http://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
 * Created by Rachana Rao on 2/26/2017.
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        UniqueBinarySearchTreesII searchTreesII = new UniqueBinarySearchTreesII();
        System.out.println(searchTreesII.countTrees(3));
    }

    private int countTrees(int a) {

        int[] cache= new int[a+1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= a; i++) {
            for (int j = 0; j < i; j++) {
                cache[i]=cache[i]+cache[j]*cache[i-j-1];
            }
        }
        return cache[a];
    }
}
