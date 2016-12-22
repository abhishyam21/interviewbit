package linkedlist;

public class PalindromeList {
    private ListNode left;
    public static void main(String[] args) {
        ListNode a = ReverseLinkedList.getList();
        ListNode.printNode(a);
        PalindromeList palindromeList = new PalindromeList();
        System.out.println(palindromeList.lPalin(a));
    }

    public int lPalin(ListNode a) {
        left = a;
        ListNode singlePointer = a;
        return checkBothHalfsEqual(singlePointer);
    }

    private int checkBothHalfsEqual(ListNode singlePointer) {
        int result = 1;
        if(singlePointer != null){
            result = checkBothHalfsEqual(singlePointer.next);
            System.out.println(singlePointer.val+"==="+left.val);
            if(left.val != singlePointer.val)
                return 0;
            left = left.next;
        }
        return result;
    }
}
