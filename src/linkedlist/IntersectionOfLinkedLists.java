package linkedlist;

/**
 * Created by Rachana Rao on 11/12/2016.
 */
public class IntersectionOfLinkedLists {
    private ListNode a = new ListNode(1);
    private ListNode b= new ListNode(2);
    public static void main(String[] args) {
        IntersectionOfLinkedLists intersectionOfLinkedLists = new IntersectionOfLinkedLists();
        intersectionOfLinkedLists.cratecyclicList();
        ListNode intersectionNode = intersectionOfLinkedLists.getIntersectionNode(intersectionOfLinkedLists.a, intersectionOfLinkedLists.b);
        System.out.println(intersectionNode.val);
    }

    private ListNode getIntersectionNode(ListNode a, ListNode b) {
        //get the length of the list
        int m = getLength(a);
        int n = getLength(b);
       if(m>n)
           return getMatchedNode(m,n,a,b);
        else return getMatchedNode(n,m,b,a);
    }

    private ListNode getMatchedNode(int m, int n, ListNode a, ListNode b) {
        //iterate the large list till the both list will be of same size
        for (int i = 0; i <(m - n); i++) {
            a = a.next;
        }
        //Now start from common point i.e both the lists are of same length
        //iterate through them and find the same pointer
        for (int i = (m - n); i <=m  ; i++) {
            if(a==b)
                return a;
            a = a.next;b=b.next;
        }
        return null;
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

    private void cratecyclicList(){
        ListNode atemp =new ListNode(3);
        ListNode atemp1 = new ListNode(5);

        ListNode btemp =new ListNode(4);
        ListNode btemp1 = new ListNode(6);
        ListNode btemp2 =new ListNode(8);
        ListNode btemp3 = new ListNode(10);

        a.next = atemp;
        a.next.next = atemp1;

        b.next = btemp;
        b.next.next = btemp1;
        b.next.next.next = btemp2;
        b.next.next.next.next = btemp3;

        ListNode temp3 = new ListNode(11);
        ListNode temp4 = new ListNode(12);
        ListNode temp5 = new ListNode(13);
        ListNode temp6 = new ListNode(14);

        a.next.next.next = temp3;
        a.next.next.next.next = temp4;
        a.next.next.next.next.next = temp5;
        a.next.next.next.next.next.next = temp6;
        b.next.next.next.next.next = a.next.next.next;
    }

}
