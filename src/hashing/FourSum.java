package test.com.hashing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by abhishyam.c on 2/22/2017.
 */
public class FourSum {
    public static void main(String[] args) {
        Integer[] temp = {31, 7, -3, 28, -16, 39, 0, -16, 20, -10, 38, -16, 19, 12, 39, -3, 25, 4};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        FourSum fourSum = new FourSum();
        ArrayList<ArrayList<Integer>> result = fourSum.navyMethod(a, 18);
        result.forEach(val -> System.out.println(val.toString()));
    }

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
                            Collections.sort(temp);
                            result.add(temp);
                        }
                    }
                }
            }
        }
        List<ArrayList<Integer>> collect = result.stream().distinct().collect(Collectors.toList());
        result.clear();
        result.addAll(collect);
        return result;
    }
}
