package linkedlist;
public class AddTwoNumbersAsLists {
    public static void main(String[] args) {
        int[] temp1 = {2,4,3};
        int[] temp2 = {5,6,4};
        ListNode a  = ListNode.getListFromArray(temp1);
        ListNode b = ListNode.getListFromArray(temp2);
        AddTwoNumbersAsLists addTwoNumbersAsLists = new AddTwoNumbersAsLists();
        ListNode listNode = addTwoNumbersAsLists.addTwoNumbers(a, b);
        ListNode.printNode(listNode);
    }

    private ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode temp1 = a;
        ListNode temp2 = b;
        ListNode resultTemp = new ListNode(-1);
        ListNode result = resultTemp;
        int carry = 0;
                while (temp1 != null && temp2 != null){
                    int val = temp1.val;
                    val+=temp2.val+carry;
                    ListNode newNode = new ListNode(val%10);
                    resultTemp.next = newNode;
                    resultTemp = resultTemp.next;
                    carry = val>9 ? val/10 : 0;
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
            while (temp1 != null){
                int val = temp1.val+carry;
                ListNode newNode = new ListNode(val%10);
                carry = val>9 ? val/10 : 0;
                newNode.next = resultTemp;
                resultTemp = newNode;
                temp1 = temp1.next;
            }
        while (temp2 != null){
            int val = temp2.val+carry;
            ListNode newNode = new ListNode(val%10);
            carry = val>9 ? val/10 : 0;
            newNode.next = resultTemp;
            resultTemp = newNode;
            temp2 = temp2.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            newNode.next = resultTemp;
            resultTemp = newNode;
        }
        return result;
    }

    private ListNode reverseList(ListNode resultTemp) {
        ListNode temp = resultTemp;
        ListNode prev = null;
        ListNode next;
        while (temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
