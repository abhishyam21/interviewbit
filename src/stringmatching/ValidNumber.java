package stringmatching;

/**
 * Created by Rachana Rao on 10/25/2016.
 */
public class ValidNumber {
    public static void main(String[] args) {
        String a = "00";
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.validNumber(a));
    }

    private int validNumber(final String a) {
            String string = removeSpaces(a);
        boolean isExponentEncountered = false;
        if(string.length() == 0){
            return 0;
        }
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(!(isNumber(c) || isNegativeNumber(c))){
                if(c == 'e'){
                    char c1 = string.charAt(i+1);
                    if(!(isNumber(c1) || isNegativeNumber(c1))){
                        return 0;
                    }
                    isExponentEncountered = true;
            }else if(isDot(c)){
                    if(isExponentEncountered){
                        return 0;
                    }else {
                        String numberAfterDot = removeSpaces(string.substring(i+1));
                        if(numberAfterDot.length() == 0) {
                            return 0;
                        }else {
                            char c1 = string.charAt(i+1);
                            if(!isNumber(c1)){
                                return 0;
                            }
                        }
                    }
                }else {
                return 0;
                }
                }
        }
        return 1;
    }
        private boolean isNumber(char c){
            int n = c-'0';
            return n>=0 && n<=9;
        }
        private boolean isNegativeNumber(char c){
            return c=='-';
        }
        private boolean isDot(char c){
            return c=='.';
        }
    private String removeSpaces(String a) {
        String result = a;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == ' ' || a.charAt(i) == '+')
                result = a.substring(i+1);
            else
                break;
        }
        String result1 = result;
        for (int i = result.length()-1; i >=0 ; i--) {
            if(result.charAt(i) == ' '){
                result1 = result.substring(0,i-1);
            }else return result1;
        }
        return result1;
    }
}
