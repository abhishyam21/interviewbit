package stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by abhishyam.c on 12/5/2016.
 *
 * This rat in a maze problem
 * problem link; http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 */
public class PathInMaze {
    private int[][] sol;
    private int n;
    //which keep tracks of nodes visited
    private Set<String> paths = new HashSet<>();
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> array= getArray(5);
        PathInMaze pathInMaze = new PathInMaze();
        pathInMaze.findMazePath(array);
    }

    private void findMazePath(ArrayList<ArrayList<Integer>> array) {
        this.n = array.size();
         sol = new int[this.n][this.n];
        if(isPathValid(array,0,0)){
                print();
        }
        else System.out.println("No Solution");
    }

    private boolean isPathValid(ArrayList<ArrayList<Integer>> array, int m, int n) {
            if(m == (this.n-1) && n== (this.n-1) && array.get(m).get(n) ==1) {
                sol[m][n] = 1;
                String path = getPathAsString(m,n);
                paths.add(path);
                return true;
            }
            if(canMoveNext(array,m,n)){
                sol[m][n] = 1;
                paths.add(getPathAsString(m,n));
                //check East
                if(isPathValid(array,m,1+n))
                    return true;
                //check South
                if(isPathValid(array,1+m,n))
                    return true;
                //check North
                if(isPathValid(array,Math.abs(m-1),n))
                    return true;

                //check West
                if(isPathValid(array,m,Math.abs(n-1)))
                    return true;

                sol[m][n] = 0;
                String path = getPathAsString(m,n);
                paths.remove(path);
                return false;
            }
            return false;
    }

    private String getPathAsString(int m, int n) {
        return "["+m+","+n+"]";
    }

    private boolean canMoveNext(ArrayList<ArrayList<Integer>> array, int m, int n) {
        return (m>=0 && m<this.n) && (n>=0 && n< this.n) && (array.get(m).get(n) == 1) &&
                !paths.contains(getPathAsString(m,n));
    }

    private static ArrayList<ArrayList<Integer>> getArray(int m) {
        Integer[] a1 = {1,1,0,1,0,1};
        Integer[] a2 = {1,0,1,1,1,1};
        Integer[] a3 = {1,0,1,1,0,1};
        Integer[] a4 = {1,0,1,0,1,1};
        Integer[] a5 = {1,0,1,1,0,1};
        Integer[] a6 = {1,1,1,1,0,1};
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        array.add(new ArrayList<>(Arrays.asList(a1)));
        array.add(new ArrayList<>(Arrays.asList(a2)));
        array.add(new ArrayList<>(Arrays.asList(a3)));
        array.add(new ArrayList<>(Arrays.asList(a4)));
        array.add(new ArrayList<>(Arrays.asList(a5)));
        array.add(new ArrayList<>(Arrays.asList(a6)));
        return array;
    }

    private void print(){
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.print(sol[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }
}
