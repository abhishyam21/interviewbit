package arrays;

import java.util.ArrayList;

/**
 * Created by Rachana Rao on 7/23/2016.
 */
public class MinStepsinInfiniteGrid {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(2);
        list2.add(1);
        list1.add(5);
        list2.add(5);
        MinStepsinInfiniteGrid minStepsinInfiniteGrid = new MinStepsinInfiniteGrid();
        System.out.println(minStepsinInfiniteGrid.process(list1,list2));
    }

    private int process(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if(X.size() ==0 || Y.size() ==0 || (X.size() != Y.size())){
            throw new IllegalArgumentException();
        }else {
            int dist = 0;
            for (int i = 1; i < X.size(); i++) {
                    dist+= calDistanceBWPoints(X.get(i-1),Y.get(i-1),X.get(i),Y.get(i));
            }

            return dist;
        }
    }

    private int calDistanceBWPoints(int x1, int y1, int x2, int y2) {
        int diffOfXCoOrdinates = Math.abs(x1 - x2);
        int diffOfYCoOrdinates = Math.abs(y1 - y2);
        return Math.max(diffOfXCoOrdinates, diffOfYCoOrdinates);
    }
}
