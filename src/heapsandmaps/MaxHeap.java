package heapsandmaps;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rachana Rao on 1/15/2017.
 */
public class MaxHeap {
    private LinkedList<Integer> heap;
     int size = 0;

    public MaxHeap() {
        heap = new LinkedList<>();
    }
    public void addElement(int num){
        heap.add(num);
        size++;
      //  heapify();
    }
    public void addElement(List<Integer> num){
        heap.addAll(num);
        size += num.size();
        heapify();
    }
    public int poll(){
        int num = heap.pollFirst();
        size--;
        heapify();
        return num;
    }

    public void heapify(){
        if(size >1){
            int curentSize = size-1;
            while (curentSize>0){
                int rootPos = getRoot(curentSize);
                int leftChild = getLeftChild(rootPos);
                int rightPos = getRightChild(rootPos);
                if(rightPos < size){
                    if(heap.get(leftChild) < heap.get(rightPos)){
                        if(heap.get(rightPos) > heap.get(rootPos)){
                            swap(rightPos,rootPos);
                        }
                    }else if(heap.get(leftChild) >= heap.get(rightPos)){
                        if(heap.get(leftChild) > heap.get(rootPos)){
                            swap(leftChild,rootPos);
                        }
                    }
                }else {
                    if(heap.get(leftChild) > heap.get(rootPos)){
                        swap(leftChild,rootPos);
                    }
                }
                curentSize =curentSize-2;
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);
    }

    public int getLeftChild(int root){
        return (root*2)+1;
    }
    public int getRightChild(int root){
        return (root*2)+2;
    }
    public int getRoot(int child){
        return ((child-1)/2);
    }
}
