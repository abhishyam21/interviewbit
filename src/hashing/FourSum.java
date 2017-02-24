package hashing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by abhishyam.c on 2/22/2017.
 */
public class FourSum {
    public static void main(String[] args) {
        //Integer[] temp = {31, 7, -3, 28, -16, 39, 0, -16, 20, -10, 38, -16, 19, 12, 39, -3, 25, 4};
        Integer[] temp = {29, 10, -16, -7, 21, 17, 6, -8, 36, 23, -15 };
        int b= 52;
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        FourSum fourSum = new FourSum();
        ArrayList<ArrayList<Integer>> result = fourSum.navyMethod(a, b);
        result.forEach(val -> System.out.println(val.toString()));
        System.out.println("-----------------------------------------------------------");
        ArrayList<ArrayList<Integer>> result1 = fourSum.fourSum(a, b);
        result1.forEach(val -> System.out.println(val.toString()));

    }

    /**
     * This is optimized way with time complexity O(N^2)
     * @param a array of numbers
     * @param b target
     * @return list of numbers which forms required sum
     */
    private ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n= a.size();
        Collections.sort(a);
        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                int sum = a.get(i)+a.get(j);
                int k =n-1, l=j+1;
                while (l<k) {
                    int sumCount = sum+a.get(k)+a.get(l);
                        if(sumCount == b){
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(a.get(i));
                            temp.add(a.get(j));
                            temp.add(a.get(k));
                            temp.add(a.get(l));
                            //sort internally the list
                            Collections.sort(temp);
                            l++;k--;
                            result.add(temp);
                    }else {
                            if(sumCount < b){
                                l++;
                            }else {
                                k--;
                            }
                        }
                }
            }
        }
        // remove all the duplicates
        List<ArrayList<Integer>> collect = result.stream().distinct().collect(Collectors.toList());
        result.clear();
        result.addAll(collect);
        return result;
    }

    /**
     * This is navy method with Time complexity of
     * O(N^4)
     * @param a array of numbers
     * @param b target
     * @return list of numbers which forms required sum
     */
    private ArrayList<ArrayList<Integer>> navyMethod(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n= a.size();
        Collections.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        if((a.get(i)+a.get(j)+a.get(k)+a.get(l)) == b){
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(a.get(i));
                            temp.add(a.get(j));
                            temp.add(a.get(k));
                            temp.add(a.get(l));
                            //sort internally the list
                            Collections.sort(temp);
                            result.add(temp);
                        }
                    }
                }
            }
        }
        // remove all the duplicates
        List<ArrayList<Integer>> collect = result.stream().distinct().collect(Collectors.toList());
        result.clear();
        result.addAll(collect);
        return result;
    }
}
