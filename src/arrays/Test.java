package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Integer[] temp = {-2,-3,4,-1,-2,1,5,-3};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        test.test(a);
    }

    private void test(ArrayList<Integer> a) {
        int count = 0;
        int start = 0,end = 0;
        int i=0;
        while (i<a.size()){
            count+=a.get(i);
            if(count > (count-a.get(i))){
                end=i;
            }else if(count <= 0){
                count=0;
                start = i+1;end=i+1;
            }
            i++;
        }
        System.out.println("start="+ start+"\t end="+end+"\t count="+count);
    }
}
