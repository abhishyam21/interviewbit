package test.com.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhishyam.c on 1/30/2017.
 */
public class Array3Pointers {
    public static void main(String[] args) {
        Integer[] temp1 = {1, 4, 10};
        Integer[] temp2 = {2, 15, 20};
        Integer[] temp3 = {10, 12};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp1));
        List<Integer> b = new ArrayList<>(Arrays.asList(temp2));
        List<Integer> c = new ArrayList<>(Arrays.asList(temp3));
        Array3Pointers array3Pointers = new Array3Pointers();
        System.out.println(array3Pointers.minimize(a,b,c));
    }

    private int minimize(List<Integer> a, List<Integer> b, List<Integer> c) {
        int x=0,y=0,z=0;
        int result = Integer.MAX_VALUE;
        while (x < a.size() && y < b.size() && z < c.size()){
            int maximum = Math.max(Math.max(a.get(x),b.get(y)),c.get(z));
            int minimum = Math.min(Math.min(a.get(x),b.get(y)),c.get(z));
            result = Math.min(result,(maximum-minimum));
            if(result == 0) break;
            if(a.get(x) == minimum) x++;
            else if(b.get(y) ==minimum) y++;
            else z++;
        }
        return result;
    }
}

/*
{
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            Integer anA = a.get(i);
            for (int j = 0; j < b.size(); j++) {
                Integer aB = b.get(j);
                for (int k = 0; k < c.size(); k++) {
                    Integer aC = c.get(k);
                    int rs1 = Math.abs(anA - aB);
                    int rs2 = Math.abs(aB - aC);
                    int rs3 = Math.abs(aC - anA);
                    min = Math.min(min, Math.max(rs1, Math.max(rs2, rs3)));
                }
            }
        }
        return min;
    }
 */