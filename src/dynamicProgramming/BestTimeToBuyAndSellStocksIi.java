package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rachana Rao on 2/28/2017.
 */
public class BestTimeToBuyAndSellStocksIi {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStocksIi stocksIi = new BestTimeToBuyAndSellStocksIi();
        //Integer[] temp = {100, 180, 260, 310, 40, 535, 695};
        Integer[] temp = {1,2,3};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        System.out.println(stocksIi.maxProfit(a));
    }

    private int maxProfit(List<Integer> a) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.size()-1; i++) {
            Integer val = a.get(i);
            min = Math.min(val,min);
            if(val >a.get(i+1)){
                max+=val -min;
                min = Integer.MAX_VALUE;
            }else if((i+1) == a.size()-1){
                max+=a.get(i+1) -min;
            }
        }
        return max;
    }
}
