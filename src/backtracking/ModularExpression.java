package backtracking;
public class ModularExpression {
    public static void main(String[] args) {
        int a=71045970;
        int b=41535484;
        int c=64735492;
        ModularExpression modularExpression = new ModularExpression();
        System.out.println(modularExpression.Mod(a,b,c));
    }

    private int Mod(int a, int b, int c) {
        if(b ==0)
            return 1%c;
        long temp = 0;
        if((b&1)==1) { //odd
            temp = a%c;
            temp = (temp * Mod(a, b - 1, c)) % c;
        }
        else {
            temp = Mod(a,b/2,c);
            temp = (temp * temp) % c;
        }
        return(int) ((temp+c)%c);
    }
}
