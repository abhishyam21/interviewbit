package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhishyam.c on 12/15/2016.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String a = "nitin";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<String> palindromStrings = palindromePartitioning.getPalindromStrings(a);
        System.out.println(palindromStrings.toString());
    }

    private List<String> getPalindromStrings(String a) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            String substr = a.substring(i,a.length());
            for (int j = 0; j <= substr.length() ; j++) {
                String pal = substr.substring(0,j);
                if(isPalindrom(pal) && !pal.isEmpty()){
                    result.add(pal);
                }
            }
        }
      /*  Collections.sort(subsetsList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int c = Integer.compare(o1.length(),o2.length());
                if(c==0)
                    c = o1.compareTo(o2);
                return c;
            }
        });*/
        return result;
    }

    private boolean isPalindrom(String palindrom) {
        int len = palindrom.length()-1;
        for (int i = 0; i < (palindrom.length()/2); i++) {
            if(palindrom.charAt(i) != palindrom.charAt(len-i))
                return false;
        }
        return true;
    }
}
