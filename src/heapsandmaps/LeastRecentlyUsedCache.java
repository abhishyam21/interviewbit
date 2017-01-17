package heapsandmaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Rachana Rao on 1/15/2017.
 */
public class LeastRecentlyUsedCache {
    class Solution{

        int capacity;
        Map<Integer,KeyValPair> map = new HashMap<>();
        LinkedList<KeyValPair> list = new LinkedList<>();
        public Solution(int capacity){
            this.capacity = capacity;
        }

        public int get(int key){
            KeyValPair nodes = map.get(key);
            if(nodes == null) return -1;
            list.remove(nodes);
            list.addLast(nodes);
            return nodes.val;
        }

        public void  set(int key, int value){
            if(map.size() == capacity ){
                KeyValPair keyValPair = map.get(key);
                if(keyValPair != null){
                    list.remove(keyValPair);
                }else {
                    KeyValPair removedNode = list.removeFirst();
                    map.remove(removedNode.key);
                }
            }
            KeyValPair keyValPair = new KeyValPair(key,value);
            KeyValPair oldKeyValuePair = map.get(key);
            map.put(key,keyValPair);
            list.remove(oldKeyValuePair);
            list.addLast(keyValPair);
        }
        public void printLRU(){
            map.entrySet().forEach( entity -> System.out.println(entity.getValue()));
        }
    }

    class KeyValPair {
        int key;
        int val;

        public KeyValPair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return (key+"\t"+val);
        }
    }
}
