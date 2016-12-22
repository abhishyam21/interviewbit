package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abhishyam.c on 12/15/2016.
 */
public class PhoneNumber {
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        List<String> stringList = phoneNumber.letterCombinations("234");
        System.out.println("Actual Result");
        System.out.println(stringList.toString());
        System.out.println("My Result");
        List<String> myResult = phoneNumber.getNumbers("234");
        System.out.println(myResult.toString());
    }

    private List<String> getNumbers(String a) {
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        for (int i = 0; i < a.length(); i++) {
            int x = Character.getNumericValue(a.charAt(i));
            String digits = mapping[x];
            while (i == result.peek().length()) {
                String s = result.poll();
                for (char c : digits.toCharArray()) {
                    result.add(s+c);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();

        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
