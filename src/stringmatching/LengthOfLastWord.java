package stringmatching;

/**
 * Created by Rachana Rao on 4/15/2017.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String a = "  ";
        System.out.println(lengthOfLastWord.approach2(a));
    }

    private int approach2(String a) {
        int i= a.length()-1;
        while (i >=0 && a.charAt(i) == ' ') i--;
        int j=i;
        for (; j >=0 ; j--) {
            if(a.charAt(j) == ' '){
                return i-j;
            }
        }
        return i-j;
    }

    public int lengthOfLastWord(final String a){
        int tempCount =0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(i>0 && (c != ' ') && a.charAt(i-1) == ' ' ){
                tempCount=0;
                tempCount++;
            }else if(c != ' '){
                tempCount++;
            }
        }
        return tempCount;
    }
}
