package trees;

import java.util.*;

/**
 * Created by Rachana Rao on 12/28/2016.
 */
public class ShortestUniquePrefix {
    public static void main(String[] args) {
          List<String> strings = Arrays.asList("zebra","dog","duck","dove");
       // List<String> strings = Arrays.asList("bearcat", "bert");
        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        ArrayList<String> result = shortestUniquePrefix.shortestUniquePrefix(strings);
        result.forEach(System.out::println);


    }

    private ArrayList<String> shortestUniquePrefix(List<String> a) {
        TrieUtil trieNode = new TrieUtil();
        a.forEach(trieNode::insert);

        ArrayList<String> result = new ArrayList<>();
        a.forEach(node -> {
                    Map<Character, TrieNode> root = trieNode.getRoot().childs;
                    int pos = 0;
                    for (int i = 0; i < node.length(); i++) {
                                Character c  =node.charAt(i);
                                if(root.containsKey(c)){
                                    if(root.size()>1)
                                        pos = i;
                                }
                                root = root.get(c).childs;
                    }
                    result.add(node.substring(0,pos+1));
                }
        );
        return result;

    }


    class TrieNode {

        Map<Character, TrieNode> childs;
        boolean isEndOfString;

        public TrieNode() {
            this.childs = new HashMap<>();
            this.isEndOfString = false;
        }

    }

    class TrieUtil {

        private TrieNode root;

        public TrieUtil() {
            root = new TrieNode();
        }

        public void insert(String string) {
            Map<Character, TrieNode> trieNodeMap = this.root.childs;
            int i = 0;
            for (; i < string.length(); i++) {
                Character c = string.charAt(i);
                //Need to insert the element
                TrieNode trieNode = trieNodeMap.computeIfAbsent(c, k -> new TrieNode());
                trieNodeMap = trieNode.childs;
                if (string.length() - 1 == i)
                    trieNode.isEndOfString = true;
            }
        }

        public boolean search(String string) {
            Map<Character, TrieNode> childNode = this.root.childs;
            TrieNode trieNode = null;
            for (int j = 0; j < string.length(); j++) {
                Character c = string.charAt(j);
                trieNode = childNode.get(c);
                if (trieNode == null) return false;
                childNode = trieNode.childs;
            }
            return trieNode.isEndOfString;
        }

        public TrieNode getRoot() {
            return root;
        }
    }
}
