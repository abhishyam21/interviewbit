package heapsandmaps;

/**
 * Created by Rachana Rao on 1/15/2017.
 */
public class DoubleLinkedList {
    //Base structure of DLL
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;

    public void add(int key, int val){
        Node node = new Node(key,val);
        if(head == null ) {
            head = node;
        }else {
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            node.prev = temp;
            temp.next = node;
        }
    }

    public void print(){
        Node temp = head;
    }
}
