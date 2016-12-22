package stack;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by abhishyam.c on 12/2/2016.
 */
public class MinStack {
   // private int minVal = Integer.MAX_VALUE;
  //  private LinkedList<Integer> stack  = new LinkedList<>();
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void  push(int x){
        stack.add(x);
        if(minStack.isEmpty())
            minStack.add(x);
        else if(minStack.peek() >=x )
            minStack.push(x);
    }

    public void pop(){
        if(!stack.isEmpty()) {
            Integer topElement = stack.pop();
            if (Objects.equals(topElement, minStack.peek()))
                minStack.pop();
        }
    }

    public int top(){
        return stack.isEmpty() ? -1: stack.peek();
    }

    public int getMin(){
        return stack.isEmpty() ? -1: minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(19);
        minStack.push(10);
        minStack.push(9);
        System.out.println(minStack.getMin());
        minStack.push(8);
        System.out.println(minStack.getMin());
        minStack.push(7);
        System.out.println(minStack.getMin());
        minStack.push(6);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
