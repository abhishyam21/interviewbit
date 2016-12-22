package linkedlist;
public class ListCycle {
    public static void main(String[] args) {
        int[] temp = {1,2,3,4,5,6,7,8,9,10};
        ListNode a = ListNode.getListFromArray(temp);
        ListNode prev = null;
        ListNode temp1= a;
        while (temp1 != null){
            prev = temp1;
            temp1 = temp1.next;
        }
        prev.next = a.next.next.next;
  //      a.next.next = a;
        ListCycle listCycle = new ListCycle();
        ListNode listNode = listCycle.detectCycle(a);
        ListNode.printNode(listNode);
    }

    private ListNode detectCycle(ListNode a) {
        ListNode doublePointer = a.next.next;
        ListNode singlePointer = a.next;
        while (doublePointer != null && doublePointer.next != null){
            if(doublePointer.equals(singlePointer)){
                ListNode newPointer = a;
                while (!singlePointer.equals(newPointer)){
                    singlePointer = singlePointer.next;
                    newPointer = newPointer.next;
                }
                ListNode result  = singlePointer;
                result.next = null;
                return result;
            }
            doublePointer = doublePointer.next.next;
            singlePointer = singlePointer.next;
        }
            return null;
    }
}
