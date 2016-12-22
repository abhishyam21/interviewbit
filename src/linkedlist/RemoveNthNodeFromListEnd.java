package linkedlist;
public class RemoveNthNodeFromListEnd {
    public static void main(String[] args) {
     //   int[] temp = {558 , 162 , 89 , 253 , 153 , 478 , 423 , 976 , 945 , 267 , 781 , 964 , 117 , 403 , 815 , 358 , 15 , 581 , 338 , 417 , 890 , 989 , 754 , 957 , 243 , 310 , 911 , 724 , 462 , 7 , 437 , 101 , 812 , 483 , 450 , 547 , 316 , 929 , 583 , 1 , 132 , 167 , 266 , 590 , 328 , 23 , 591 , 904 , 274 , 534 , 677 , 574 , 184 , 606 , 926 , 863 , 832 , 626 , 972 , 307 , 174 , 940 , 952 , 703 , 699 , 404 , 150 , 636 , 782 , 442 , 560 , 613 , 158 , 743 , 970 , 917 , 322 , 220 , 578 , 829 , 33 , 439 , 428 , 551 , 376 , 985};
            int[] temp = {1,2,3,4,5,6,7};
        ListNode a = ListNode.getListFromArray(temp);
        int b= 1;
        RemoveNthNodeFromListEnd removeNthNodeFromListEnd = new RemoveNthNodeFromListEnd();
        ListNode listNode = removeNthNodeFromListEnd.removeNthFromEnd(a,b);
        ListNode.printNode(listNode);
    }

    private ListNode removeNthFromEnd(ListNode a, int b) {
        ListNode doublePointer = a;
        ListNode singlePointer = a;
        ListNode prev = singlePointer;
        int len = 0;
        while (doublePointer != null && doublePointer.next != null){
            doublePointer = doublePointer.next.next;
            prev = singlePointer;
            singlePointer = singlePointer.next;
            len++;
        }
        int totalLen = (len+len);
        if(doublePointer != null){
            len++;
            totalLen++;
        }

        if(totalLen <=b){
            a = a.next;
            return a;
        } else {
            if(b < len){
                while ((len-b)!=0){
                    prev = singlePointer;
                    singlePointer = singlePointer.next;
                    len--;
                }
            }else if(b>len){
                    singlePointer = a;
                    prev =a;
                     len = totalLen-b;
                    while (len != 0){
                        prev = singlePointer;
                        singlePointer = singlePointer.next;
                        len--;
                    }
            }
        }
            prev.next = singlePointer.next;
        return a;
    }
}
