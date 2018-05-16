package Heap.IndexHeapAdvance;

//ʹ����������ѽ��ж�����, ����֤���ǵ���������ѵ���ȷ��
//��������ѵ���Ҫ���ò�����������, ����������ʹ������ֻ��Ϊ����֤���ǵ����������ʵ�ֵ���ȷ��
//�ں�����ͼ����, ��������С�������㷨, �������·���㷨, ���Ƕ���Ҫʹ�������ѽ����Ż�:)
public class IndexHeapSort {

 // ���ǵ��㷨�಻��������κ�ʵ��
 private IndexHeapSort(){}

 public static void sort(Comparable[] arr){

     int n = arr.length;

     IndexMaxHeap<Comparable> indexMaxHeap = new IndexMaxHeap<Comparable>(n);
     for( int i = 0 ; i < n ; i ++ )
         indexMaxHeap.insert( i , arr[i] );

     for( int i = n-1 ; i >= 0 ; i -- )
         arr[i] = indexMaxHeap.extractMax();
 }

 // ���� Index Heap Sort
 public static void main(String[] args) {

     int N = 1000000;
     Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
     SortTestHelper.testSort("Heap.IndexHeapAdvance.IndexHeapSort", arr);

     return;
 }
}