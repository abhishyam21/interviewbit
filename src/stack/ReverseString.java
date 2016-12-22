package stack;

import java.util.Stack;

/**
 * Created by abhishyam.c on 11/27/2016.
 */
public class ReverseString {
    public static void main(String[] args) {
        String a = "abcd";
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString(a));
    }

    private String reverseString(String a) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            stack.push(a.charAt(i));
        }
        String result = "";
        while (!stack.isEmpty()){
                result+=stack.pop()+"";
        }
        return result;
    }
}
