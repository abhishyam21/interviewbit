package test.com.hashing;

import java.util.*;

/**
 * Created by abhishyam.c on 3/7/2017.
 */
public class Anagrams {
    public static void main(String[] args) {
        String[] temp ={"cat", "dog", "god", "tca"};
        ArrayList<String> a = new ArrayList<>(Arrays.asList(temp));
        Anagrams anagrams = new Anagrams();
        ArrayList<ArrayList<Integer>> anagrams1 = anagrams.getAnagrams(a);
        for (ArrayList<Integer> arrayList : anagrams1) {
            System.out.println(arrayList.toString());
        }
    }

    private ArrayList<ArrayList<Integer>> getAnagrams(ArrayList<String> a) {
        Map<String,List<Integer>> cache = new TreeMap<>();
        int i=1;
        for (String entity : a) {
            String hasCode = getHasCode(entity);
            List<Integer> integers = cache.get(hasCode);
            if(integers == null){
                integers = new ArrayList<>();
                integers.add(i);
            }else {
                integers.add(i);
            }
            cache.put(hasCode,integers);
            i++;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for ( Map.Entry<String, List<Integer>> entry:cache.entrySet()){
            ArrayList<Integer> temp  = new ArrayList<>();
            temp.addAll(entry.getValue());
            Collections.sort(temp);
            result.add(temp);
        }
        return result;
    }

    private String getHasCode(String entity) {
        char[] chars = entity.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

  /*  private long getHasCode(String entity){
        long hasCode  =1L;
        for (int i = 0; i < entity.length(); i++) {
                int num = entity.charAt(i)-96;
                hasCode*=num;
        }
        return hasCode;
    }*/
}
