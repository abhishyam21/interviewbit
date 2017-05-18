package linkedlist;

/**
 * Created by Rachana Rao on 11/12/2016.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static void  printNode(ListNode a){
        ListNode temp = a;
        while (temp != null){
            System.out.print(temp.val+"\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode getListFromArray(int[] array) {
        ListNode a = new ListNode(array[0]);
        ListNode temp = a;
        for (int i = 1; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return a;
    }

    //Get the length of the list
    private int getLength(ListNode a) {
        ListNode temp = a;
        int count = 0;
        while (temp!= null){
            if(temp.next == null) {
                return ++count;
            }
            temp =temp.next.next;
            count+=2;
        }
        return count;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
