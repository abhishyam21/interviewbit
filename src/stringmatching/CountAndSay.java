package stringmatching;

/**
 * Created by Rachana Rao on 4/15/2017.
 */
public class CountAndSay {
    public static void main(String[] args) {
        int a = 5;
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(a));
    }

    private String countAndSay(int a) {
        String result = "1";
        for (int i = 1; i < a; i++) {
            result = getPatter(result);
        }
        return result;
    }

    private String getPatter(String num) {
        StringBuilder result = new StringBuilder();
        char prev = num.charAt(0);
        int count = 0;
        char current = 0;
        for (int i = 0; i < num.length(); i++) {
            current = num.charAt(i);
            if(prev == current) count++;
            else {
                result.append(count).append(prev);
                count = 1;
            }
            prev = current;
        }
        result.append(count).append(current);
        return result.toString();
    }
}
