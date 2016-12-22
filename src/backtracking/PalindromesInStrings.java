package backtracking;

import java.util.ArrayList;

public class PalindromesInStrings {
    public static void main(String[] args) {
        String a = "nitin";
        PalindromesInStrings palindromesInStrings = new PalindromesInStrings();
     //   ArrayList<ArrayList<String>> allPalindromes = palindromesInStrings.getAllPalindroms(a);
        ArrayList<ArrayList<String>> allPalindromes = palindromesInStrings.partition(a);
        for (ArrayList<String> allPalindrome : allPalindromes) {
            System.out.println(allPalindrome.toString());
        }
    }

    private ArrayList<ArrayList<String>> getAllPalindroms(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            int window = i+1;
            ArrayList<String> perMutation = getPerMutation(window, a);
            if(perMutation != null)
            result.add(perMutation);
        }
        return result;
    }

    private ArrayList<String> getPerMutation(int window, String a) {
        boolean hasPalindrom = false;
        ArrayList<String> result = new ArrayList<>();
        int j=0;
        int size = a.length()-window+1;
        while (j < size){
            String pre = a.substring(j,(j+window));
            if(isPalindrome(pre)){
                result.add(pre);
                hasPalindrom = true;
            }else {
                result.add(a.substring(j,j+1));
            }
            j++;
        }
        if(j < a.length()){
            result.add(a.substring(j,a.length()));
        }
        return hasPalindrom ? result:null;
    }

    private boolean isPalindrome(String pre) {
        int size = pre.length()-1;
        for (int i = 0; i < pre.length(); i++) {
            if(pre.charAt(i) != pre.charAt(size-i))
                return false;
        }
        return true;
    }

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        ArrayList<String> partition = new ArrayList<>();//track each possible partition
        addPalindrome(s, 0, partition, result);

        return result;
    }

    private void addPalindrome(String s, int start, ArrayList<String> partition,
                               ArrayList<ArrayList<String>> result) {
        //stop condition
        if (start == s.length()) {
            ArrayList<String> temp = new ArrayList<>(partition);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }
}
