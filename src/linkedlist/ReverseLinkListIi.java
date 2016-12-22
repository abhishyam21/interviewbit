package linkedlist;
public class ReverseLinkListIi {
    public static void main(String[] args) {
        int[] temp = {1,2,3,4,5,6,7,8};
        ListNode a = ListNode.getListFromArray(temp);
        ReverseLinkListIi reverseLinkListIi = new ReverseLinkListIi();
        int m = 3, n=5;
        ListNode listNode = reverseLinkListIi.reverseBetween(a, m, n);
        ListNode.printNode(listNode);
    }

    private ListNode reverseBetween(ListNode a, int m, int n) {
        if (a == null)
            return null;
        if (a.next == null)
            return a;
        int count = 1;
        ListNode temp = a;
        ListNode beforeStrtPoint = null;
        while (count < m) {
            beforeStrtPoint = temp;
            temp = temp.next;
            count++;
        }
        count = m;
        ListNode prev = null;
        ListNode next;
        while (count != (n + 1) && temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count++;
        }
        if(beforeStrtPoint != null){
            beforeStrtPoint.next = prev;
            ListNode start = prev;
            while (start.next != null){
                start =start.next;
            }
            start.next = temp;
        }else {
            beforeStrtPoint = prev;
            while (beforeStrtPoint.next != null){
                beforeStrtPoint = beforeStrtPoint.next;
            }
            beforeStrtPoint.next = temp;
            return prev;
        }
        return a;
    }
}
