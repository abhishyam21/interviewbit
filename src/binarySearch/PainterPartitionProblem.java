package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 4/14/2017.
 */
public class PainterPartitionProblem  {
    public static void main(String[] args) {
        int a =3;
        int b = 10;
        Integer[] temp = {1,3,6,8,9,10};
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(temp));
        PainterPartitionProblem painterPartitionProblem = new PainterPartitionProblem();
        System.out.println(painterPartitionProblem.paint(a,b,c));
    }

    public int paint(int a, int b, ArrayList<Integer> c) {
        int n = c.size();
        int sum = 0;
        for (int i = 0; i <n ; i++)  sum+=c.get(i);

        int low = 1, hi = sum;
        while (low < hi){
            int t=1;
            int mid = (low+hi)/2;
            sum = 0;
            for (int i = 0; i < n; i++) {
                sum+=c.get(i);
                if(sum > mid){
                    t++;
                    i--; sum=0;
                }
            }
            if( t > a){
                low = mid+1;
            }else hi = mid;
        }
        return (hi*b)%10000003;
    }
}
