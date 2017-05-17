package codeninja;

import java.util.*;

/**
 * Created by Rachana Rao on 5/16/2017.
 */
public class GetModeArrayUpdates {
    public static void main(String[] args) {
        Integer[] temp = {1, 3, 2, 2, 1};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        b.add(new ArrayList<>(Arrays.asList(new Integer[]{1, 3})));
        b.add(new ArrayList<>(Arrays.asList(new Integer[]{5, 1})));
        b.add(new ArrayList<>(Arrays.asList(new Integer[]{2, 1})));
        b.add(new ArrayList<>(Arrays.asList(new Integer[]{2, 2})));
        b.add(new ArrayList<>(Arrays.asList(new Integer[]{2, 2})));
        GetModeArrayUpdates updates = new GetModeArrayUpdates();
        ArrayList<Integer> mode = updates.getMode(a, b);
        System.out.println(mode.toString());
    }

    private ArrayList<Integer> getMode(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> b) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(o -> o));
        Map<Integer, List<Integer>> maxMap = new HashMap<>();
        Map<Integer, Integer> array = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            array.put(i, a.get(i));
        }
        for (int i = 0; i < a.size(); i++) {
            Integer count = map.get(a.get(i));
            if (count == null) count = 0;
            map.put(a.get(i), ++count);
            List<Integer> list = maxMap.get(count);
            if (list == null) list = new LinkedList<>();
            list.add(a.get(i));
            maxMap.put(count, list);
            maxCount = Math.max(count, maxCount);
        }
        List prev = Arrays.asList(new Integer[]{0, 0});
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < b.size(); i++) {
            ArrayList<Integer> updateList = b.get(i);
            if (prev.get(0) != updateList.get(0) || prev.get(1) != updateList.get(1)) {
                Integer firstIndex = array.get(updateList.get(0) - 1);
                Integer count = map.get(firstIndex);
                if (count == null) count = 0;
                map.put(firstIndex, --count);
                count = map.get(updateList.get(1));
                if (count == null) count = 0;
                map.put(updateList.get(1), ++count);
                array.put(updateList.get(0) - 1, updateList.get(1));
                maxCount = Math.max(maxCount, count);
            }
            result.add(getMax(map, maxCount));
            prev = updateList;
        }

        return result;
    }

    private Integer getMax(Map<Integer, Integer> map, int maxCount) {
        int max = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;

        return result;
    }
}
