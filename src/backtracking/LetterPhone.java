package backtracking;

import java.util.*;

public class LetterPhone {
    Map<Integer,String> digitMap = new HashMap<>();
    public static void main(String[] args) {
        String a = "23";
        LetterPhone letterPhone = new LetterPhone();
        letterPhone.letterCombinations(a);
    }

    private ArrayList<String> letterCombinations(String a) {
        Set<String> result = new HashSet<>();
        populateMap();

        return null;
    }

    private void populateMap() {
        digitMap.put(0,"0");
        digitMap.put(1,"1");
        digitMap.put(2,"abc");
        digitMap.put(3,"def");
        digitMap.put(4,"ghi");
        digitMap.put(5,"jkl");
        digitMap.put(6,"mno");
        digitMap.put(7,"pqrs");
        digitMap.put(8,"tuv");
        digitMap.put(9,"wxyz");
    }
}
