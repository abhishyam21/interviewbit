package stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by abhishyam.c on 11/30/2016.
 */
public class EvaluateExpression {
    public static void main(String[] args) {
        ArrayList<String> a = getExpression();
        EvaluateExpression evaluateExpression = new EvaluateExpression();
        System.out.println(evaluateExpression.evalRPN(a));
    }

    private static ArrayList<String> getExpression() {
        ArrayList<String> exp = new ArrayList<>();
        exp.add("2");
        exp.add("1");
        exp.add("3");
        exp.add("*");
        exp.add("+");
        exp.add("9");
        exp.add("-");
        return exp;
    }

    private int evalRPN(ArrayList<String> a) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < a.size()) {
            String val = a.get(i);
            switch (val) {
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y + x);
                    break;
                case "-":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y - x);
                    break;
                case "*":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y * x);
                    break;
                case "/":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y / x);
                    break;
                default:
                    stack.add(Integer.parseInt(val));
            }
            i++;
        }
        return stack.pop();
    }
}
