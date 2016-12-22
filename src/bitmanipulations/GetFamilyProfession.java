package bitmanipulations;

/**
 * Created by Rachana Rao on 9/13/2016.
 */
public class GetFamilyProfession {
    public static void main(String[] args) {
        int line = 4,position = 8;
        GetFamilyProfession getFamilyProfession = new GetFamilyProfession();
        System.out.println(getFamilyProfession.getProfession(line,position) ==true ? "E":"D");
    }

    private boolean getProfession(int line, int position) {
        if(position==1)
        return true;
        if( (position&1) == 1){
            return getProfession(line,(position+1)/2);
        }else {
            return !getProfession(line,(position)/2);
        }
    }
}
