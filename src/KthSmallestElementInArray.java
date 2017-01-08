import trees.KthSmallestElementInTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rachana Rao on 1/1/2017.
 */
public class KthSmallestElementInArray {
    public static void main(String[] args) {
        Integer[] temp = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
           //Integer[] temp = {5,3,7,10,19,6,22,9};
   //     Integer[] temp = {19,10,22};
        List<Integer> a = new ArrayList<>(Arrays.asList(temp));
        KthSmallestElementInArray kthSmallestElementInArray = new KthSmallestElementInArray();
        Arrays.sort(temp);
        for (Integer aTemp : temp) {
            System.out.print(aTemp + "\t");
        }
        System.out.println();
        for (int i = 1; i <= temp.length; i++) {
            int kthsmallest = kthSmallestElementInArray.kthsmallest(a, i);
            System.out.print(kthsmallest+"\t");
        }
        System.out.println();
        int kthsmallest = kthSmallestElementInArray.kthsmallest(a, 9);
        System.out.print(kthsmallest+"\t");

    }

    private int kthsmallest(final List<Integer> a, int k) {
        Heap heap = new Heap(a.size());
        a.forEach(heap::insertNode);
        heap.heapify();
        int minElement = 0;
        for (int i = 0; i < k; i++) {
            minElement = heap.remove();
        }
        return minElement;
    }

        class Heap {
            int[] array;
            int size;

            //constructor to initialize size to Zero and
            //initialize the array with max capacity
            public Heap(int capacity) {
                array = new int[capacity];
                size = -1;
            }
            //add element to heap
            public void insertNode(int num) {
                array[++size] = num;
            }


            private int getLeftNode(int root){
                return (root<<1)+1;
            }

            private int getRightNode(int root){
                return (root<<1)+2;
            }

            private int getRoot(int child){
                return (child-1>>1);
            }

            private void swap(int a, int b){
                int temp = array[a];
                array[a] = array[b];
                array[b] = temp;
            }
            //remove the minimum element in heap
            int remove(){
                int deletedElement = array[0];
                //array[1] = array[size];
                swap(0,size--);
                heapify();
                //array[size--] = deletedElement;
                return deletedElement;
            }

            private void heapify(){
                int root = getRoot(size);
                while (root>=0){
                    int leftChildPosition = getLeftNode(root);
                    int rightChildPosition = getRightNode(root);
                    if( (rightChildPosition <= size) && array[leftChildPosition] < array[rightChildPosition]){
                        if(array[root] > array[leftChildPosition]){
                                swap(root,leftChildPosition);
                        }
                    }else {
                        if( (rightChildPosition <= size) && array[root] > array[rightChildPosition] )
                            swap(root,rightChildPosition);
                        else if(array[root] > array[leftChildPosition])
                            swap(root,leftChildPosition);
                    }
                    root--;
                }
            }
        }
}
