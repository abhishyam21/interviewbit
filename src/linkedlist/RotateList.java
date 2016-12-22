package linkedlist;
public class RotateList {
    public static void main(String[] args) {
        int[] temp = {91 , 34 , 18 , 83 , 38 , 82 , 21 , 69};
        ListNode a = ListNode.getListFromArray(temp);
        int b = 89;
        ListNode.printNode(a);
        RotateList rotateList = new RotateList();
        ListNode listNode = rotateList.rotateRight(a,b);
        //ListNode listNode = rotateList.rotateRightOld(a, b);
        ListNode.printNode(listNode);
    }

    private ListNode rotateRight(ListNode a, int b) {
        if(a==null)
            return null;
        if(a.next == null)
            return a;

        int totalLen = getLen(a);
        //if the given number is more than total length use mod operator
        if(b> totalLen){
            int div = b/totalLen;
            int rem = b%totalLen;
         /*   if((div & 1) == 0){
                a = reverseList(a);
            }*/
            if(rem == 0)
                return a;
            b= rem;
        }
        ListNode singlePointer = a;
        while ((totalLen-b) != 1) {
            singlePointer = singlePointer.next;
            totalLen--;
        }
        ListNode result = singlePointer.next;
        singlePointer.next = null;
        ListNode prev = result;
        while (prev.next != null){
            prev = prev.next;
        }
        prev.next = a;
        return result;
    }

    private int getLen(ListNode a) {
        int len = 0;
        ListNode doubleNode = a;
        while (doubleNode != null && doubleNode.next != null){
            doubleNode = doubleNode.next.next;
            len = len+2;
        }
        if(doubleNode != null){
            len++;
        }
        return len;
    }

























    private ListNode rotateRightOld(ListNode a, int b) {
        if(a==null)
            return null;
        if(a.next == null)
            return a;
        ListNode doubleNode = a;
        ListNode singleNode = a;
        ListNode prev = a;
        ListNode right;
        int len = 0;
        //make sure the single node pointer is in the middle of the list
        while (doubleNode != null && doubleNode.next != null){
            doubleNode = doubleNode.next.next;
            singleNode = singleNode.next;
            len++;
        }
        //cal total len of the list
        int totalLen = len+len;
        //for odd len add one extra
        if(doubleNode != null){
            len++;
            totalLen++;
        }
        //if the given number is more than total length use mod operator
        if(b> totalLen){
          int div = b/totalLen;
            int rem = b%totalLen;
            if((div & 1) != 0){
                a = reverseList(a);
            }
            if(rem == 0)
                return a;
            b= rem;
        }
            if(b < len){
                while ((len-b) != 1){
                    singleNode = singleNode.next;
                    len--;
                }
            }
            else if(b > len){
                singleNode = a;
                len = 1;
                while ((totalLen-b) != len){
                    singleNode = singleNode.next;
                    len++;
                }
            }
        right = singleNode.next;
        singleNode.next = null;
        ListNode temp = right;
        while (temp != null){
            prev =temp;
            temp =temp.next;
        }
        prev.next = a;
        return right;
    }

    private ListNode reverseList(ListNode a) {
        ListNode temp =a;
        ListNode prev =null;
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
