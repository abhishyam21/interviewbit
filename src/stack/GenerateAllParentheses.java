package stack;

import java.util.Stack;

/**
 * Created by abhishyam.c on 11/27/2016.
 */
public class GenerateAllParentheses {
    public static void main(String[] args) {
        String a = "()]{}";
        GenerateAllParentheses generateAllParentheses = new GenerateAllParentheses();
        System.out.println(generateAllParentheses.isValid(a));
    }

    private int isValid(String a) {
        Stack<Character> closingBrackets = new Stack<>();
        Stack<Character> curlyBraces = new Stack<>();
        Stack<Character> squareBraces = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            switch (c){
                case '{': curlyBraces.push(c);break;
                case '[': squareBraces.push(c);break;
                case '(': closingBrackets.push(c);break;
                case ')': if(closingBrackets.isEmpty()) return 0;closingBrackets.pop();break;
                case ']': if(squareBraces.isEmpty()) return 0;squareBraces.pop();break;
                case '}': if(curlyBraces.isEmpty()) return 0;curlyBraces.pop();break;
            }
        }
        return closingBrackets.isEmpty() ? curlyBraces.isEmpty() ? squareBraces.isEmpty() ? 1 :0 :0: 0;
    }


}
