package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rachana Rao on 1/30/2017.
 */
public class SortList {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        int[] temp = {91 , 34 , 18 , 83 , 38 , 82 , 21 , 69};
        ListNode a = ListNode.getListFromArray(temp);
        ListNode listNode = sortList.sortList(a);
        ListNode.printNode(listNode);
    }

    private ListNode sortList(ListNode a) {
        List<Integer> list = new ArrayList<>();
        while (a != null){
            list.add(a.val);
            a = a.next;
        }
        Collections.sort(list);
        ListNode result = new ListNode(list.get(0));
        ListNode temp = result;
        for (int i = 1; i < list.size(); i++) {
            ListNode newNode = new ListNode(list.get(i));
            temp.next = newNode;
            temp = newNode;
        }
        return result;
    }
}
