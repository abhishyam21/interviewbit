package maths;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 8/28/2016.
 */
public class ReorderArrayAccordingtoGivenIndexes {
    public static void main(String[] args) {
        Integer arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
        Integer index[] = {1, 0, 2};
        ReorderArrayAccordingtoGivenIndexes reorderArrayAccordingtoGivenIndexes =
                new ReorderArrayAccordingtoGivenIndexes();
        reorderArrayAccordingtoGivenIndexes.reorder(arr,index);
    }

    private void reorder(Integer[] arr, Integer[] index) {
        int n = arr.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            arr[arr[i]%n] = arr[arr[i]%n]+n;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

}
