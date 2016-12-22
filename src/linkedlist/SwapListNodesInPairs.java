package linkedlist;
public class SwapListNodesInPairs {
    public static void main(String[] args) {
        int[] temp = {1};
        ListNode a = ListNode.getListFromArray(temp);
        SwapListNodesInPairs swapListNodesInPairs = new SwapListNodesInPairs();
        ListNode listNode = swapListNodesInPairs.swapPairs(a);
        ListNode.printNode(listNode);
    }

    private ListNode swapPairs(ListNode node) {  // If linked list is empty or there is only one node in list
        if (node == null || node.next == null) {
            return node;
        }

        // Initialize previous and current pointers
        ListNode prev = node;
        ListNode curr = node.next;

        node = curr;  // Change head before proceeeding

        // Traverse the list
        while (true) {
            ListNode next = curr.next;
            curr.next = prev; // Change next of current as previous node

            // If next NULL or next is the last node
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }

            // Change next of previous to next next
            prev.next = next.next;

            // Update previous and curr
            prev = next;
            curr = prev.next;
        }
        return node;
    }
}
