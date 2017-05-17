package hashing;

import java.util.*;

/**
 * Created by abhishyam.c on 2/22/2017.
 */
public class Equal {
    public static void main(String[] args) {
        Integer[] temp = {3, 4, 7, 1, 2, 9, 8};
        //Integer[] temp = {0, 0, 1, 0, 2, 1};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(temp));
        Equal equal = new Equal();
        ArrayList<Integer> result = equal.navyApproach(a);
        System.out.println(result.toString());
        ArrayList<Integer> result1 = equal.equal(a);
        System.out.println(result1.toString());
        ArrayList<Integer> integers = equal.finalMethod(a);
        System.out.println(integers.toString());
    }

    private ArrayList<Integer> finalMethod(ArrayList<Integer> a) {
        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                List<Node> node = map.get(sum);
                if (node == null) {
                    node = new LinkedList<>();
                }
                node.add(new Node(sum, i, j));
                map.put(sum, node);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(Integer.MAX_VALUE);
        result.add(Integer.MAX_VALUE);
        result.add(Integer.MAX_VALUE);
        result.add(Integer.MAX_VALUE);
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                Node current = new Node(sum, i, j);
                List<Node> nodes = map.get(sum);
                for (Node node : nodes) {
                    if (overlaps(current, node)) continue;
                    result.set(0, current.i);
                    result.set(1, current.j);
                    result.set(2, node.i);
                    result.set(3, node.j);
                    return result;
                }
            }
        }
        return result;
    }

    public boolean overlaps(Node n1, Node n2) {

        if (n1.i == n2.i || n1.i == n2.j || n1.j == n2.i || n1.j == n2.j)
            return true;

        return false;
    }

    private ArrayList<Integer> equal(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>(4);
        Integer[] positions = new Integer[4];
        Arrays.fill(positions,Integer.MAX_VALUE);
        int sum = Integer.MAX_VALUE;
        HashMap<Integer,Integer> cache = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            Integer pos = cache.get(a.get(i));
            if(pos == null){
                cache.put(a.get(i),i);
            }
        }

        int n = a.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currentSum = a.get(i)+a.get(j);
                for (int k = 0; k < n; k++) {
                        Integer l = cache.get(currentSum-a.get(k));
                        //if (currentSum == a.get(k) + a.get(l)) {
                    if(l != null){
                            if(i<j && k<l && i < k && j!=l && j!=k && (sum > (a.get(i)+a.get(j)))){
                                if(positions[0] > i && positions[1] >j && positions[2] >k && positions[3] > l) {
                                    positions[0] = i;
                                    positions[1] = j;
                                    positions[2] = k;
                                    positions[3] = l;
                                    sum = a.get(i) + a.get(j);
                                }
                            }
                        }
                }
            }
        }
        result.addAll(Arrays.asList(positions));
        return result;
    }

    private ArrayList<Integer> navyApproach(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>(4);
        Integer[] positions = new Integer[4];
        Arrays.fill(positions,Integer.MAX_VALUE);
        int sum = Integer.MAX_VALUE;
        int n = a.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (a.get(i) + a.get(j) == a.get(k) + a.get(l)) {
                                if(i<j && k<l && i < k && j!=l && j!=k && (sum > (a.get(i)+a.get(j)))){
                                    if(positions[0] > i && positions[1] >j && positions[2] >k && positions[3] > l) {
                                        positions[0] = i;
                                        positions[1] = j;
                                        positions[2] = k;
                                        positions[3] = l;
                                        sum = a.get(i) + a.get(j);
                                    }
                                }
                        }
                    }
                }
            }
        }
        result.addAll(Arrays.asList(positions));
        return result;
    }

    private static class Node {
        int data, i, j;

        public Node(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return this.data + "-->" + i + "," + j;
        }
    }
}
