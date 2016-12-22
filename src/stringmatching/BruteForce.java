package stringmatching;

/**
 * Created by Rachana Rao on 9/29/2016.
 */
public class BruteForce {
    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();

        String hairstack = "abcdaba";
        String needle = "aba";

        System.out.println(bruteForce.matchString(hairstack,needle));
    }

    private int matchString(String hairstack, String needle) {
        int m = hairstack.length();
        int n = needle.length();
        for (int i = 0; i <= (m -n); i++) {
            for (int j = 0; j < n; j++) {
                if(hairstack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if(j==(n-1))
                    return i;
            }
        }
        return -1;
    }
}
