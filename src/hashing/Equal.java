package hashing;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhishyam.c on 2/22/2017.
 */
public class Equal {
    public static void main(String[] args) {
       // Integer[] temp = {3, 4, 7, 1, 2, 9, 8};
        Integer[] temp = {0, 0, 1, 0, 2, 1};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        Equal equal = new Equal();
        ArrayList<Integer> result = equal.equal(a);
        System.out.println(result.toString());
    }

    private ArrayList<Integer> equal(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>(4);
        Integer[] positions = new Integer[4];
        Arrays.fill(positions,Integer.MAX_VALUE);
        int sum = Integer.MAX_VALUE;
        int n = a.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (a.get(i) + a.get(j) == a.get(k) + a.get(l)) {
                                if(i<j && k<l && i < k && j!=l && j!=k && (sum > (a.get(i)+a.get(j)))){
                                    if(positions[0] > i && positions[1] >j && positions[2] >k && positions[3] > l) {
                                        positions[0] = i;
                                        positions[1] = j;
                                        positions[2] = k;
                                        positions[3] = l;
                                        sum = a.get(i) + a.get(j);
                                    }
                                }
                        }
                    }
                }
            }
        }
        result.addAll(Arrays.asList(positions));
        return result;
    }
}
