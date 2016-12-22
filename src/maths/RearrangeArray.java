package maths;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 8/28/2016.
 */
public class RearrangeArray {
    public static void main(String[] args) {

        Integer arr[] = {4,0,2,1,3};
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(arr));
        RearrangeArray rearrangeArray = new RearrangeArray();
        rearrangeArray.arrange(a);

    }

    private void arrange(ArrayList<Integer> a) {
        int n= a.size();
        for(int i=0;i<n;i++){
            int current = a.get(i);
            int ref = a.get(a.get(i));
            a.add(current+((ref%n)*n));
        }
        for (int i = 0; i < n; i++) {
            a.remove(0);
        }

        for(int i=0;i<n;i++){
            a.add(a.get(i)/n);
        }
        for (int i = 0; i < n; i++) {
            a.remove(0);
        }
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }
}
