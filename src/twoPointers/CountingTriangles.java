package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rachana Rao on 1/10/2017.
 */
public class CountingTriangles {
    public static void main(String[] args) {
        CountingTriangles countingTriangles = new CountingTriangles();
        Integer[] temp = {1, 1, 1, 2, 2};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        int i = countingTriangles.approach1(a);
        System.out.println(i);
    }

    public int approach1(ArrayList<Integer> A) {
        ArrayList<Integer> a = A;
        Collections.sort(a);
        int counter = 0;
        int n = a.size();
        for (int i = 0; i < n; i++) {
            int k=i+2;
            for (int j = i+1; j < n; j++) {
                int sum = a.get(i)+a.get(j);
                while (k< n && sum>a.get(k)){
                    k++;
                    counter+=(k-1-j);
                    if(counter > 1000000007)
                    counter = counter % (1000000007);
                }

            }
        }
        return counter;
    }
}
