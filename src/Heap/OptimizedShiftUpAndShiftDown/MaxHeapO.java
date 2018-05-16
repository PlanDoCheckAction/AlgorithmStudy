package Heap.OptimizedShiftUpAndShiftDown;

//�� ShiftUp �� ShiftDown ����ʹ�����Ʋ��������㷨�ķ�ʽ�����Ż�������
public class MaxHeapO<T extends Comparable> {

 protected T[] data;
 protected int count;
 protected int capacity;

 // ���캯��, ����һ���ն�, ������capacity��Ԫ��
 public MaxHeapO(int capacity){
     data = (T[])new Comparable[capacity+1];
     count = 0;
     this.capacity = capacity;
 }

 // ���캯��, ͨ��һ���������鴴��һ������
 // �ù���ѵĹ���, ʱ�临�Ӷ�ΪO(n)
 public MaxHeapO(T arr[]){

     int n = arr.length;

     data = (T[])new Comparable[n+1];
     capacity = n;

     for( int i = 0 ; i < n ; i ++ )
         data[i+1] = arr[i];
     count = n;

     for( int i = count/2 ; i >= 1 ; i -- )
         shiftDown(i);
 }

 // ���ض��е�Ԫ�ظ���
 public int size(){
     return count;
 }

 // ����һ������ֵ, ��ʾ�����Ƿ�Ϊ��
 public boolean isEmpty(){
     return count == 0;
 }

 // �������в���һ���µ�Ԫ�� item
 public void insert(T item){

     assert count + 1 <= capacity;
     data[count+1] = item;
     count ++;
     shiftUp(count);
 }

 // ��������ȡ���Ѷ�Ԫ��, ���������洢���������
 public T extractMax(){
     assert count > 0;
     T ret = data[1];

     swap( 1 , count );
     count --;
     shiftDown(1);

     return ret;
 }

 // ��ȡ�����еĶѶ�Ԫ��
 public T getMax(){
     assert( count > 0 );
     return data[1];
 }


 // ������������Ϊi��j������Ԫ��
 private void swap(int i, int j){
     T t = data[i];
     data[i] = data[j];
     data[j] = t;
 }

 //********************
 //* ���Ѻ��ĸ�������
 //********************
 private void shiftUp(int k){
     T e = data[k];
     while( k > 1 && data[k/2].compareTo(e) < 0 ){
         //swap(k, k/2);
         data[k] = data[k/2];
         k /= 2;
     }
     data[k] = e;
 }

 private void shiftDown(int k){

     T e = data[k];
     while( 2*k <= count ){
         int j = 2*k; // �ڴ���ѭ����,data[k]��data[j]����λ��
         if( j+1 <= count && data[j+1].compareTo(data[j]) > 0 )
             j ++;
         // data[j] �� data[2*k]��data[2*k+1]�е����ֵ

         if( e.compareTo(data[j]) >= 0 ) break;
         //swap(k, j);
         data[k] = data[j];
         k = j;
     }
     data[k] = e;
 }

 // ���� MaxHeapO
 public static void main(String[] args) {

     MaxHeapO<Integer> maxHeap = new MaxHeapO<Integer>(100);
     int N = 100; // ����Ԫ�ظ���
     int M = 100; // ����Ԫ��ȡֵ��Χ[0, M)
     for( int i = 0 ; i < N ; i ++ )
         maxHeap.insert( new Integer((int)(Math.random() * M)) );

     Integer[] arr = new Integer[N];
     // ��maxheap�е�������ʹ��extractMaxȡ����
     // ȡ������˳��Ӧ���ǰ��մӴ�С��˳��ȡ������
     for( int i = 0 ; i < N ; i ++ ){
         arr[i] = maxHeap.extractMax();
         System.out.print(arr[i] + " ");
     }
     System.out.println();

     // ȷ��arr�����ǴӴ�С���е�
     for( int i = 1 ; i < N ; i ++ )
         assert arr[i-1] >= arr[i];
 }
}
