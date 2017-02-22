package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Rachana Rao on 2/22/2017.
 */
public class DiffkII {
    public static void main(String[] args) {
       /*// Integer[] temp = {7, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0 };
       // Integer[] temp = {34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29};
        Integer[] temp = {90, 85, 74, 25, 34, 63, 43, 91, 30};
        ArrayList<Integer> a =new ArrayList<>(Arrays.asList(temp));
        DiffkII diffkII = new DiffkII();
        System.out.println(diffkII.diffPossible(a,97));
        diffkII.nativeMethod(a,97);*/
       TestDiffII testDiffII = new TestDiffII();
       testDiffII.test();
    }

            private int diffPossible(ArrayList<Integer> a, int b) {
                if(a.size() ==1) return 0;
                HashMap<Integer,Integer> cache = new HashMap<>();
                for (int i = 0; i < a.size(); i++) {
                    int diff = 0;
                    if(b < a.get(i)){
                        diff = a.get(i) - b;
                    }else{
                        diff = b+a.get(i);
                    }
                    Integer val = cache.get(diff);
                    if(val == null){
                        cache.put(diff,i);
                    }else {
                        if(a.get(i) - diff ==b) return 1;
                    }
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

        static class TestDiffII{
            private void  test(){
                Integer[] temp1 = {90, 85, 74, 25, 34, 63, 43, 91, 30};
                  validate(temp1,55,1);
            }
            private void validate(Integer[] temp, int b, int expected){
                DiffkII diffkII = new DiffkII();
                ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
                int actual = diffkII.diffPossible(a, b);
                if(actual == expected){
                    System.out.println("passed");
                }else {
                    System.out.println("failed");
                    System.out.println("Expected:"+expected+"\tActual:"+actual);
                }
            }
        }
}
