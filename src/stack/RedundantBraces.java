package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abhishyam.c on 11/30/2016.
 */
public class RedundantBraces {
    public static void main(String[] args) {
        String a = "(a)";
        RedundantBraces redundantBraces = new RedundantBraces();
        System.out.println(redundantBraces.braces(a));
    }

    private int braces(String a) {
        List<Character> operators = new LinkedList<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        Stack<Character> stack = new Stack<>();
        int i=0;
        while (i<a.length()){
            char c = a.charAt(i);
            if(c == ')'){
                if(!popElements(stack,operators))
                    return 1;
            }else {
                stack.push(c);
            }
            i++;
        }
        return 0;
    }

    private boolean popElements(Stack<Character> stack, List<Character> operators) {
        boolean hasOperator = false;
        if(stack.peek() == '(')
            return false;
        while (stack.peek() != '(') {
            if(operators.contains(stack.pop()))
                    hasOperator = true;
        }
        stack.pop();
        return hasOperator;
    }
}
