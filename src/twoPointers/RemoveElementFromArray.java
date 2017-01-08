package twoPointers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Rachana Rao on 1/7/2017.
 */
public class RemoveElementFromArray {
    public static void main(String[] args) {
        RemoveElementFromArray removeElementFromArray = new RemoveElementFromArray();
        Integer[] temp = {4,1,1,2,1,3};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        int b=1;
        removeElementFromArray.removeElement(a,b);
        System.out.println(a.toString());
    }

    private int removeElement(ArrayList<Integer> a, int b) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i) == b){
                count++;
            }else {
                a.set((i-count),a.get(i));
            }
        }
        int n=a.size()-1;
        for (int i = 0; i < count; i++) {
            a.remove(n-i);
        }
        return a.size();
    }
}

/*
approach 1

{
        ListIterator<Integer> iterator = a.listIterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(next == b) {
                iterator.remove();
            }
        }
        return a.size();
    }
 */
