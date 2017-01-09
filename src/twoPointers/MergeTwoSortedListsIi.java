package test.com.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhishyam.c on 1/9/2017.
 */
public class MergeTwoSortedListsIi {
    public static void main(String[] args) {
        Integer[] temp1 = { 3};
        Integer[] temp2 = {-2, -2};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(temp2));
        MergeTwoSortedListsIi mergeTwoSortedListsIi = new MergeTwoSortedListsIi();
        mergeTwoSortedListsIi.mergeTwoSortedListsIi(a, b);
        System.out.println(a.toString());
    }

    private void mergeTwoSortedListsIi(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i=0,j=0;
        int n=b.size();
        while (i < a.size() && j < n) {
            if(a.get(i) >= b.get(j)){
                int temp = a.get(i);
                a.set(i,b.get(j));
                a.add(i+1,temp);
                j++;
            }else
            i++;
        }
        if( j!=n){
            a.addAll(b.subList(j,n));
        }
    }
}

/*
{
            if(a.get(i) <= b.get(j) && a.get(i+1)>=b.get(j)){
                a.add(i+1,b.get(j));
                j++;i++;
            }else {
                i++;
            }
        }
 */