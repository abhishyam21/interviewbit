package backtracking;

import java.util.*;

public class LetterPhone {
    Map<Integer,String> digitMap = new HashMap<>();
    public static void main(String[] args) {
        String a = "2";
        LetterPhone letterPhone = new LetterPhone();
            letterPhone.populateMap();
        ArrayList<String> strings = letterPhone.letterCombinations(a);
        strings.forEach(System.out::println);
    }

    private ArrayList<String> letterCombinations(String a) {
        int[] num = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            num[i] = a.charAt(i)-48;
        }
        StringBuilder str = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        getStrings(num,str,0,result);
        return result;
    }

    private void getStrings(int[] a, StringBuilder str, int position, ArrayList<String> result) {
        if(a.length ==str.length()){
            result.add(str.toString());
            return;
        }
        for (int j = 0; j < digitMap.get(a[position]).length(); j++) {
            str.append(digitMap.get(a[position]).charAt(j));
                getStrings(a,str,position+1,result);
                str.deleteCharAt(str.length()-1);
            }
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
