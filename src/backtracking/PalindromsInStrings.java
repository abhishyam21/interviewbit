package backtracking;

import java.util.ArrayList;

public class PalindromsInStrings {
    public static void main(String[] args) {
        String a = "nitin";
        PalindromsInStrings palindromsInStrings = new PalindromsInStrings();
        palindromsInStrings.getAllPalindroms(a);
    }

    private ArrayList<ArrayList<String>> getAllPalindroms(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            int window = i+1;
            result.add(getPerMutation(window,a));
        }
        return null;
    }

    private ArrayList<String> getPerMutation(int window, String a) {
        ArrayList<String> result = new ArrayList<>();
        int j=0;
        while (j < a.length()){
            String pre = a.substring(j,(j+window));
            if(isPalindrom(pre)){
                result.add(pre);
                j+= window;
            }else {
                result.add(a.substring(j,j+1));
                j++;
            }
        }
        return result;
    }

    private boolean isPalindrom(String pre) {
        return false;
    }
}
