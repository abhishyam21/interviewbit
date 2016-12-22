package stack;

import java.util.Stack;

/**
 * Created by abhishyam.c on 11/27/2016.
 */
public class SimplifyDirectoryPath {
    public static void main(String[] args) {
     //   String a = "/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/..";
        String a = "/home/abhi/kiran/";
        SimplifyDirectoryPath simplifyDirectoryPath = new SimplifyDirectoryPath();
        System.out.println(simplifyDirectoryPath.simplifyPath(a));
    }

    private String simplifyPath(String a) {
        Stack<String> stack = new Stack<>();
        String tempString = "";
        for (int i = 1; i < a.length(); i++) {
            char c = a.charAt(i);
            if(c == '/'){
                addToStack(stack,tempString);
                tempString="";
            }else {
                tempString+=c+"";
            }
        }
        addToStack(stack,tempString);
        StringBuilder stringBuilder = new StringBuilder();
        getAsString(stack,stringBuilder);
        return stringBuilder.length()==0 ? "/": stringBuilder.toString();
    }

    private void getAsString(Stack<String> stack, StringBuilder stringBuilder) {
       Stack<String> temp = new Stack<>();
        while (!stack.isEmpty())
        temp.push(stack.pop());
        while (!temp.isEmpty())
            stringBuilder.append("/").append(temp.pop());
    }

    private void addToStack(Stack<String> stack, String tempString) {
        if(tempString.contains("..")){
            if (!stack.isEmpty())
                stack.pop();
        }else if(!tempString.isEmpty() && !tempString.equals("."))
            stack.push(tempString);
    }
}
