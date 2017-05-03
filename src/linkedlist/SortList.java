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
       
        if (head == null || head.next == null)
            return head;

        // count total number of elements
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        // break up to two list
        int middle = count / 2;

        ListNode left = head, right = null;
        ListNode temp = head;
        int countHalf = 0;
        while (temp != null ){
            countHalf++;
            ListNode prev = temp;
            temp = temp.next;
            if(countHalf == middle){
                right = temp;
                prev.next = null;
            }
        }
        // now we have two parts l and r, recursively sort them
        ListNode h1 = sortList(left);
        ListNode h2 = sortList(right);
        // merge together
        ListNode merged = merge(h1, h2);

        return merged;
    }
    
    
     private ListNode merge(ListNode left, ListNode right) {
        ListNode fakeNode = new ListNode(Integer.MIN_VALUE);
        ListNode i = left;
        ListNode j = right;
        ListNode temp = fakeNode;
        while ( i != null && j != null) {
            if(i.val <= j.val){
                temp.next = new ListNode(i.val);
                i = i.next;
                temp = temp.next;
            }else {
                temp.next = new ListNode(j.val);
                j = j.next;
                temp = temp.next;
            }
        }
        temp.next = (j!= null) ? j : i;
        return fakeNode.next;
    }
}
