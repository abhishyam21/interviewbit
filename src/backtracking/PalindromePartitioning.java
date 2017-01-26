package backtracking;

import java.util.ArrayList;

/**
 * Created by abhishyam.c on 12/15/2016.
 */
public class PalindromePartitioning {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    public static void main(String[] args) {
        String a = "aab";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        ArrayList<ArrayList<String>> palindromeStrings = palindromePartitioning.getPalindromStrings(a);
        for (ArrayList<String> palindromeString : palindromeStrings)
            System.out.println(palindromeString.toString());
    }

    private ArrayList<ArrayList<String>> getPalindromStrings(String a) {
        allPalindromes(a,new ArrayList<>(),0,a.length());
        return result;
    }

    private void allPalindromes(String a, ArrayList<String> subset, int position, int n) {
        if(position >= n){
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = position; i < n; i++) {
            String subStr = a.substring(position,i+1);
            if(isPalindrome(subStr)) {
                subset.add(subStr);
                allPalindromes(a, subset, i+1, n);
                subset.remove(subset.size()-1);
            }
        }
    }


    private boolean isPalindrome(String palindrome) {
        if(palindrome == null || palindrome.isEmpty()) return false;
        int len = palindrome.length()-1;
        for (int i = 0; i < (palindrome.length()/2); i++) {
            if(palindrome.charAt(i) != palindrome.charAt(len-i))
                return false;
        }
        return true;
    }

}



/*
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
      /*  Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int c = Integer.compare(o1.length(),o2.length());
                if(c==0)
                    c = o1.compareTo(o2);
                return c;
            }
        });*/
   /*     return result;
                }
 */