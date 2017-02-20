import java.util.*;

/**
 * Created by Rachana Rao on 2/20/2017.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Integer[] temp = {100, 4, 200, 1, 3, 2};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(a));
    }

    private int longestConsecutive(final List<Integer> a) {
        TreeSet<Integer> temp = new TreeSet<>();
        for (int  integer : a) {
            temp.add(integer);
        }
        int result = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        Iterator<Integer> iterator = temp.iterator();
        int prev = temp.first();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(next == prev+1)
                max++;
            else
                max = 0;
            result = Math.max(result,max);
            prev = next;
        }
        return result+1;
    }
}
