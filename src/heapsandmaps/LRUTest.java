package heapsandmaps;

import java.util.Objects;

/**
 * Created by Rachana Rao on 1/15/2017.
 */
public class LRUTest {
    public static void main(String[] args) {
        /*LeastRecentlyUsedCache leastRecentlyUsedCache = new LeastRecentlyUsedCache();
        LeastRecentlyUsedCache.Solution solution = leastRecentlyUsedCache.new Solution(2);
        solution.set(2,1);
        solution.set(1,1);
        solution.set(2,3);
        solution.set(4,1);
     //   solution.printLRU();
     //   System.out.println("---------------------------------------");
        System.out.println(solution.get(1));
       // solution.printLRU();
     //   System.out.println("------------------------------------------");
        System.out.println(solution.get(2));
        solution.printLRU();*/
    input();
    }

    public static void input(){
        String input = "59 7 S 2 1 S 1 10 S 8 13 G 12 S 2 8 G 11 G 7 S 14 7 S 12 9 S 7 10 G 11 S 9 3 S 14 15 G 15 G 9 S 4 13 G 3 S 13 7 G 2 S 5 9 G 6 G 13 S 4 5 S 3 2 S 4 12 G 13 G 7 S 9 7 G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G 13 G 6 S 3 8 G 14 G 4 S 5 6 S 10 15 G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S 10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8";
        String[] inputs = input.split(" ");
        LeastRecentlyUsedCache leastRecentlyUsedCache = new LeastRecentlyUsedCache();
        LeastRecentlyUsedCache.Solution solution = leastRecentlyUsedCache.new Solution(Integer.parseInt(inputs[1]));
        for (int i = 2; i < inputs.length; i++) {
                if(Objects.equals(inputs[i], "S")){
                    int key = Integer.parseInt(inputs[++i]);
                    int value = Integer.parseInt(inputs[++i]);
                    solution.set(key,value);
                }else {
                    int key = Integer.parseInt(inputs[++i]);
                    System.out.print(solution.get(key)+"\t");
                }
        }
    }
}
