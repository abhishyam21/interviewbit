package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rachana Rao on 2/26/2017.
 */
public class BestTimeToBuyAndSellStocksI {
    public static void main(String[] args) {
        Integer[] temp = {100, 180, 260, 310, 40, 535, 695};
        BestTimeToBuyAndSellStocksI sellStocksI = new BestTimeToBuyAndSellStocksI();
        ArrayList<Integer> a= new ArrayList<>(Arrays.asList(temp));
        System.out.println(sellStocksI.navyApproach(a));
        System.out.println(sellStocksI.profit(a));
    }
    private int profit(ArrayList<Integer> a ){
        if(a.size() == 0) return 0;
        int profit = 0;
        int minEle = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            minEle = Math.min(minEle,a.get(i));
                profit = Math.max(profit,a.get(i)-minEle);
        }
        return profit;
    }

    private int navyApproach(ArrayList<Integer> a) {
        if(a.size() == 0) return 0;
        int profit = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                profit = Math.max(profit,a.get(j)-a.get(i));
            }
        }
        return profit;
    }
}
