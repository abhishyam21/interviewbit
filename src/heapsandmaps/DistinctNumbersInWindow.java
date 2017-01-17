package heapsandmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by Rachana Rao on 1/15/2017.
 */
public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        Integer[] temp = {1, 2, 1, 3, 4, 3};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        DistinctNumbersInWindow distinctNumbersInWindow = new DistinctNumbersInWindow();
        int b = 3;
        ArrayList<Integer> result = distinctNumbersInWindow.dNums(a, b);
        result.forEach(System.out::println);
    }

    private ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int i = 0;
        for (; i < B; i++) {
            addToMap(A.get(i), map);
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(map.size());
        int removePos = 0;
        for (; i < A.size(); i++) {
            removeElement(A.get(removePos++), map);
            int val = A.get(i);
            if (map.containsKey(val)) {
                addToMap(val, map);
                result.add(map.size());
            } else {
                map.put(val, 1);
                result.add(map.size());
            }
        }
        return result;
    }

    private void removeElement(Integer val, LinkedHashMap<Integer, Integer> map) {
        Integer count = map.get(val);
        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, --count);
        }
    }

    private void addToMap(Integer val, LinkedHashMap<Integer, Integer> map) {
        Integer count = map.get(val);
        if (count == null)
            map.put(val, 1);
        else {
            map.put(val, ++count);
        }
    }
}
