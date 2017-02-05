package dynamicProgramming;

/**
 * Created by abhishyam.c on 1/31/2017.
 */
public class WaysToDecode {
    private int result = 0;
    public static void main(String[] args) {
        String a = "1234";
        WaysToDecode waysToDecode = new WaysToDecode();
        System.out.println(waysToDecode.decode(a));
    }

    private int decode(String a) {
        int n = a.length();
        if (n <= 0)
            return 0;
        if (1 == n)
            return a.charAt(0) <= '9' && a.charAt(0) >= '1' ? 1 : 0;
//        char[] str = a.toCharArray();
        return decodeUtil(a);
    }

    private int decodeUtil(String a) {
        //base case
            if(a.length() == 0) return 1;
            
            int sum = 0;
        for (int i = 1; i <= a.length(); i++) {
            String head = a.substring(0,i);
            String tail = a.substring(i);
            if(!isValid(head))
                break;
            sum+= decodeUtil(tail);
        }
        return sum;
    }

    private boolean isValid(String s) {
        int num = Integer.parseInt(s);
        return num>0 && num<27;
    }
}