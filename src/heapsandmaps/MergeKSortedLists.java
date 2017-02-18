package heapsandmaps;

import java.util.*;

/**
 * Created by Rachana Rao on 1/15/2017.
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        Integer[] temp1 = {1, 10, 20};
        Integer[] temp2 = {4, 11, 13};
        Integer[] temp3 = {3, 8, 9};
        ArrayList<ListNode> a = new ArrayList<>();
        ListNode linkedList1 = getList(temp1);
        ListNode linkedList2 = getList(temp2);
        ListNode linkedList3 = getList(temp3);
        a.add(linkedList1);
        a.add(linkedList2);
        a.add(linkedList3);
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode linkedList = mergeKSortedLists.mergeKLists(a);
        while (linkedList != null) {
            System.out.print(linkedList.val + "\t");
            linkedList = linkedList.next;
        }
    }


    private ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode result = null;
        LinkedList<Integer> temp = new LinkedList<>();
        int i = 0;
        a.forEach(list -> {
            while (list != null) {
                temp.add(list.val);
                list = list.next;
            }
        });
        Collections.sort(temp);
        int n = temp.size();
        for (int j = 0; j < n; j++) {
            ListNode node = new ListNode(temp.pollLast());
            if (result == null) {
                result = node;
            } else {
                node.next = result;
                result = node;
            }
        }
        return result;
    }
    private static ListNode getList(Integer[] temp1) {
        ListNode result =null;
        for (int i = temp1.length - 1; i >= 0; i--) {
            ListNode temp = new ListNode(temp1[i]);
            if(result == null){
                result = temp;
            }else {
                temp.next = result;
                result = temp;
            }
        }
        return result;
    }
}
class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

  /*
{
        ListNode result = null;
        MaxHeap heap = new MaxHeap();
        a.forEach( listNode -> {
            while (listNode != null){
                heap.addElement(listNode.val);
                listNode = listNode.next;
            }
        });
        heap.heapify();
        while ( heap.size >0){
            ListNode node = new ListNode(heap.poll());
            if(result == null){
                result = node;
            }else {
                node.next = result;
                result = node;
            }
        }
        return result;
    }
   */

  /*

   */