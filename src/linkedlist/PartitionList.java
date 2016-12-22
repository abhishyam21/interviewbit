package linkedlist;
public class PartitionList {
    public static void main(String[] args) {
        int[] temp = {9};
        int b = 9;
        ListNode a = ListNode.getListFromArray(temp);
        PartitionList partitionList = new PartitionList();
        ListNode listNode = partitionList.partition(a, b);
        ListNode.printNode(listNode);
    }

    private ListNode partition(ListNode a, int b){
        if(a == null)
            return a;

        ListNode small = null, greater = null,  temp = a,next = a;
        while (temp != null){
            next= temp.next;
            if(temp.val < b){
             small =  addNode(small,temp);
            }else {
                greater = addNode(greater,temp);
            }
            temp = next;
        }
        small = reverseList(small);
        greater = reverseList(greater);
        if(small == null) return greater;
        combine(small,greater);
        return small;
    }

    private void combine(ListNode small, ListNode greater) {
        ListNode temp = small;
        while ( temp.next != null){
            temp = temp.next;
        }
        temp.next = greater;
    }

    private ListNode addNode(ListNode node, ListNode temp) {
            if(node == null){
                node = temp;
                node.next = null;
            }else {
                temp.next = node;
                node = temp;
            }
            return node;
    }

    private ListNode reverseList(ListNode a) {
        ListNode prev = null;
        ListNode current = a;
        ListNode next = a;
        while (next != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

