package Heap.IndexMinHeap;

//ʹ����С�����ѽ��ж�����, ����֤���ǵ���������ѵ���ȷ��
public class IndexMinHeapSort {

 // ���ǵ��㷨�಻��������κ�ʵ��
 private IndexMinHeapSort(){}

 public static void sort(Comparable[] arr){

     int n = arr.length;

     IndexMinHeap<Comparable> indexMinHeap = new IndexMinHeap<Comparable>(n);
     for( int i = 0 ; i < n ; i ++ )
         indexMinHeap.insert( i , arr[i] );

     for( int i = 0 ; i < n ; i ++ )
         arr[i] = indexMinHeap.extractMin();
 }

 // ���� Index Min Heap Sort
 public static void main(String[] args) {

     int N = 1000000;
     Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
     SortTestHelper.testSort("Heap.IndexMinHeap.IndexMinHeapSort", arr);

     return;
 }
}