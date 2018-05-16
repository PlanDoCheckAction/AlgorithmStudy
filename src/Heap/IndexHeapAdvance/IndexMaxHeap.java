package Heap.IndexHeapAdvance;

import java.util.Arrays;

//���������
public class IndexMaxHeap<Item extends Comparable> {

 protected Item[] data;      // ����������е�����
 protected int[] indexes;    // ����������е�����, indexes[x] = i ��ʾ����i��x��λ��
 protected int[] reverse;    // ����������еķ�������, reverse[i] = x ��ʾ����i��x��λ��
 protected int count;
 protected int capacity;

 // ���캯��, ����һ���ն�, ������capacity��Ԫ��
 public IndexMaxHeap(int capacity){
     data = (Item[])new Comparable[capacity+1];
     indexes = new int[capacity+1];
     reverse = new int[capacity+1];
     for( int i = 0 ; i <= capacity ; i ++ )
         reverse[i] = 0;

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
 public void insert(int i, Item item){

     assert count + 1 <= capacity;
     assert i + 1 >= 1 && i + 1 <= capacity;

     // �ٲ���һ����Ԫ��ǰ,����Ҫ��֤����i���ڵ�λ����û��Ԫ�صġ�
     assert !contain(i);

     i += 1;
     data[i] = item;
     indexes[count+1] = i;
     reverse[i] = count + 1;
     count ++;

     shiftUp(count);
 }

 // �������������ȡ���Ѷ�Ԫ��, �������������洢���������
 public Item extractMax(){
     assert count > 0;

     Item ret = data[indexes[1]];
     swapIndexes( 1 , count );
     reverse[indexes[count]] = 0;
     count --;
     shiftDown(1);

     return ret;
 }

 // �������������ȡ���Ѷ�Ԫ�ص�����
 public int extractMaxIndex(){
     assert count > 0;

     int ret = indexes[1] - 1;
     swapIndexes( 1 , count );
     reverse[indexes[count]] = 0;
     count --;
     shiftDown(1);

     return ret;
 }

 // ��ȡ����������еĶѶ�Ԫ��
 public Item getMax(){
     assert count > 0;
     return data[indexes[1]];
 }

 // ��ȡ����������еĶѶ�Ԫ�ص�����
 public int getMaxIndex(){
     assert count > 0;
     return indexes[1]-1;
 }

 // ������i���ڵ�λ���Ƿ����Ԫ��
 boolean contain( int i ){
     assert  i + 1 >= 1 && i + 1 <= capacity;
     return reverse[i+1] != 0;
 }

 // ��ȡ���������������Ϊi��Ԫ��
 public Item getItem( int i ){
     assert contain(i);
     return data[i+1];
 }

 // �����������������Ϊi��Ԫ���޸�ΪnewItem
 public void change( int i , Item newItem ){

     assert contain(i);

     i += 1;
     data[i] = newItem;

     // �ҵ�indexes[j] = i, j��ʾdata[i]�ڶ��е�λ��
     // ֮��shiftUp(j), ��shiftDown(j)
//     for( int j = 1 ; j <= count ; j ++ )
//         if( indexes[j] == i ){
//             shiftUp(j);
//             shiftDown(j);
//             return;
//         }

     // ���� reverse ֮��,
     // ���ǿ��Էǳ��򵥵�ͨ��reverseֱ�Ӷ�λ����i��indexes�е�λ��
     shiftUp( reverse[i] );
     shiftDown( reverse[i] );
 }

 // �����������е�����i��j
 // �������˷�������reverse���飬
 // indexes���鷢���ı��Ժ� ��Ӧ�ľ���Ҫά��reverse����
 private void swapIndexes(int i, int j){
     int t = indexes[i];
     indexes[i] = indexes[j];
     indexes[j] = t;

     reverse[indexes[i]] = i;
     reverse[indexes[j]] = j;
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

 // �����������е���������index�ͷ�������reverse
 // ע��:�������������в���Ԫ���Ժ�, ������extract������Ч
 public boolean testIndexes(){

     int[] copyIndexes = new int[count+1];
     int[] copyReverseIndexes = new int[count+1];

     for( int i = 0 ; i <= count ; i ++ ) {
         copyIndexes[i] = indexes[i];
         copyReverseIndexes[i] = reverse[i];
     }

     copyIndexes[0] = 0;
     copyReverseIndexes[0] = 0;
     Arrays.sort(copyIndexes);
     Arrays.sort(copyReverseIndexes);

     // �ڶ��������е������ͷ����������������,
     // �������鶼Ӧ��������1...count��count������
     boolean res = true;
     for( int i = 1 ; i <= count ; i ++ )
         if( copyIndexes[i-1] + 1 != copyIndexes[i] ||
                 copyReverseIndexes[i-1] + 1 != copyReverseIndexes[i] ){
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