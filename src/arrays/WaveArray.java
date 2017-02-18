package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rachana Rao on 8/19/2016.
 */
public class WaveArray {
    public static void main(String[] args) {
        Integer[] temp = {5, 1, 3, 2, 4};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        WaveArray waveArray = new WaveArray();
        System.out.println(waveArray.wave(a).toString());
    }

    private ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        for (; i < a.size()-1; i=i+2) {
            int temp = a.get(i);
            ans.add(i,a.get(i+1));
            ans.add(i+1,temp);
        }
        ans.addAll(a.subList(i,a.size()));
        return ans;
    }
}
