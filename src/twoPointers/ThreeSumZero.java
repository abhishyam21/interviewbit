package twoPointers;

import java.util.*;

/**
 * Created by Rachana Rao on 1/6/2017.
 */
public class ThreeSumZero {
    public static void main(String[] args) {
        ThreeSumZero threeSumZero = new ThreeSumZero();
        Integer[] temp = {-1,0,1,2,-1,-4};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        ArrayList<ArrayList<Integer>> arrayLists = threeSumZero.threeSum(a);
        arrayLists.forEach(node -> System.out.println(node.toString()));
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(a);
        int n=a.size();
        for (int i = 0; i < n-2; i++) {
            int l=i+1, r= n-1;
            if(i>0 && (Objects.equals(a.get(i), a.get(i - 1)))) continue;
            while (l<r){

                int sum = a.get(i)+a.get(l)+a.get(r);
                if(sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(a.get(i), a.get(l), a.get(r))));
                    int prev = l;
                    while (l<=r && Objects.equals(a.get(l), a.get(prev))) l++;
                }else if(sum < 0)l++;
                else r--;
            }
        }
        return result;

    }
}

/*

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<ArrayList<Integer>> temp = new HashSet<>();
        Collections.sort(a);
        int n=a.size();
        for (int i = 0; i < n-2; i++) {
            int l=i+1, r= n-1;
            while (l<r){

                int sum = a.get(i)+a.get(l)+a.get(r);
                if(sum == 0) {
                    temp.add(new ArrayList<>(Arrays.asList(a.get(i), a.get(l), a.get(r))));
                    l++;r--;
                }else if(sum < 0)l++;
                else r--;
            }
        }
        temp.forEach(node ->
                result.add(new ArrayList<>(node))
        );
        return result;


 */