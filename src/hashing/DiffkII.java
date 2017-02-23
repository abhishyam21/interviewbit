package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Rachana Rao on 2/22/2017.
 */
public class DiffkII {
    public static void main(String[] args) {
       // Integer[] temp = {7, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0 };
       // Integer[] temp = {34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29};
        Integer[] temp = {90, 85, 74, 25, 34, 63, 43, 91, 30};
        ArrayList<Integer> a =new ArrayList<>(Arrays.asList(temp));
        DiffkII diffkII = new DiffkII();
        System.out.println(diffkII.diffPossible(a,55));
        diffkII.nativeMethod(a,55);
    }

            private int diffPossible(ArrayList<Integer> a, int b) {
                if(a.size() ==1) return 0;
                HashMap<Integer,Integer> cache = new HashMap<>();

                for (int i = 0; i < a.size(); i++) {
                       int diff1 = a.get(i)-b ;
                        int diff2 = a.get(i)+b;
                        if(cache.containsKey(diff1)) return 1;
                        if(cache.containsKey(diff2)) return 1;
                        cache.put(a.get(i),i);
                }
                return 0;
            }

        private void nativeMethod(ArrayList<Integer> a , int b){
        int n = a.size();
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if((a.get(i) - a.get(j)) == b){
                        System.out.println(a.get(i)+"=="+a.get(j));
                    }
                }
            }
        }
}
