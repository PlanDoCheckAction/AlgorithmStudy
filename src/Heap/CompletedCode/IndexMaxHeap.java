package Heap.CompletedCode;

import java.util.Arrays;

//���������
public class IndexMaxHeap<T extends Comparable> {

 protected T[] data;      // ����������е�����
 protected int[] indexes;    // ����������е�����
 protected int count;
 protected int capacity;

 // ���캯��, ����һ���ն�, ������capacity��Ԫ��
 public IndexMaxHeap(int capacity){
     data = (T[])new Comparable[capacity+1];
     indexes = new int[capacity+1];
     count = 0;
     this.capacity = capacity;
 }

 // �����������е�Ԫ�ظ���
 public int size(){
     return count;
 }

 // ����һ������ֵ, ��ʾ���������Ƿ�Ϊ��
 public boolean isEmpty(){
     return count == 0;
 }

 // ������������в���һ���µ�Ԫ��, ��Ԫ�ص�����Ϊi, Ԫ��Ϊitem
 // �����i���û�����,�Ǵ�0������
 public void insert(int i, T item){

     assert count + 1 <= capacity;
     assert i + 1 >= 1 && i + 1 <= capacity;

     i += 1;
     data[i] = item;
     indexes[count+1] = i;
     count ++;

     shiftUp(count);
 }

 // �������������ȡ���Ѷ�Ԫ��, �������������洢���������
 public T extractMax(){
     assert count > 0;

     T ret = data[indexes[1]];
     swapIndexes( 1 , count );
     count --;
     shiftDown(1);

     return ret;
 }

 // �������������ȡ���Ѷ�Ԫ�ص�����
 public int extractMaxIndex(){
     assert count > 0;

     int ret = indexes[1] - 1;
     swapIndexes( 1 , count );
     count --;
     shiftDown(1);

     return ret;
 }

 // ��ȡ����������еĶѶ�Ԫ��
 public T getMax(){
     assert count > 0;
     return data[indexes[1]];
 }

 // ��ȡ����������еĶѶ�Ԫ�ص�����
 public int getMaxIndex(){
     assert count > 0;
     return indexes[1]-1;
 }

 // ��ȡ���������������Ϊi��Ԫ��
 public T getItem( int i ){
     assert i + 1 >= 1 && i + 1 <= capacity;
     return data[i+1];
 }

 // �����������������Ϊi��Ԫ���޸�ΪnewItem
 public void change( int i , T newItem ){

     i += 1;
     data[i] = newItem;

     // �ҵ�indexes[j] = i, j��ʾdata[i]�ڶ��е�λ��
     // ֮��shiftUp(j), ��shiftDown(j)
     for( int j = 1 ; j <= count ; j ++ )
         if( indexes[j] == i ){
             shiftUp(j);
             shiftDown(j);
             return;
         }
 }

 // �����������е�����i��j
 private void swapIndexes(int i, int j){
     int t = indexes[i];
     indexes[i] = indexes[j];
     indexes[j] = t;
 }

 //********************
 //* ��������Ѻ��ĸ�������
 //********************

 // ��������, ����֮��ıȽϸ���data�Ĵ�С���бȽ�, ��ʵ�ʲ�����������
 private void shiftUp(int k){

     while( k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) < 0 ){
         swapIndexes(k, k/2);
         k /= 2;
     }
 }

 // ��������, ����֮��ıȽϸ���data�Ĵ�С���бȽ�, ��ʵ�ʲ�����������
 private void shiftDown(int k){

     while( 2*k <= count ){
         int j = 2*k;
         if( j+1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]]) > 0 )
             j ++;

         if( data[indexes[k]].compareTo(data[indexes[j]]) >= 0 )
             break;

         swapIndexes(k, j);
         k = j;
     }
 }

 // �����������е���������index
 // ע��:�������������в���Ԫ���Ժ�, ������extract������Ч
 public boolean testIndexes(){

     int[] copyIndexes = new int[count+1];

     for( int i = 0 ; i <= count ; i ++ )
         copyIndexes[i] = indexes[i];

     copyIndexes[0] = 0;
     Arrays.sort(copyIndexes);

     // �ڶ��������е��������������, Ӧ��������1...count��count������
     boolean res = true;
     for( int i = 1 ; i <= count ; i ++ )
         if( copyIndexes[i-1] + 1 != copyIndexes[i] ){
             res = false;
             break;
         }

     if( !res ){
         System.out.println("Error!");
         return false;
     }

     return true;
 }

 // ���� IndexMaxHeap
 public static void main(String[] args) {

     int N = 1000000;
     IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
     for( int i = 0 ; i < N ; i ++ )
         indexMaxHeap.insert( i , (int)(Math.random()*N) );
     assert indexMaxHeap.testIndexes();
 }
}
