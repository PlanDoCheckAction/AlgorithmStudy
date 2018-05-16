package Heap.OptimizedShiftUpAndShiftDown;

//ʹ�ý�n��Ԫ�ز���������, �ٽ���n��Ԫ�ش�������ȡ���ķ�ʽ, ����n��Ԫ�ؽ�������
//�Դ������� MaxHeap ����ShiftUp��ShiftDown�Ż�ǰ��Ч�ʵĲ�ͬ
public class MaxHeapSort {

 // ���ǵ��㷨�಻��������κ�ʵ��
 private MaxHeapSort(){}

 // ������arr����ʹ��MaxHeapSort����
 // MaxHeapSort, �����е�Ԫ��������ӵ�����, �ڽ�����Ԫ�شӶ�������ȡ����, �����������
 public static void sort(Comparable[] arr){

     int n = arr.length;
     MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);
     for( int i = 0 ; i < n ; i ++ )
         maxHeap.insert(arr[i]);

     for( int i = n-1 ; i >= 0 ; i -- )
         arr[i] = maxHeap.extractMax();
 }

 // ���� MaxHeapSort
 public static void main(String[] args) {

     int N = 1000000;
     Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
     SortTestHelper.testSort("Heap.OptimizedShiftUpAndShiftDown.MaxHeapSort", arr);

     return;
 }
}
