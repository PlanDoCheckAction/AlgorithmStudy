package BinarySearchTree.BinarySearch;

//�ǵݹ�Ķ��ֲ����㷨
public class BinarySearch {

 // ���ǵ��㷨�಻��������κ�ʵ��
 private BinarySearch() {}

 // ���ֲ��ҷ�,����������arr��,����target
 // ����ҵ�target,������Ӧ������index
 // ���û���ҵ�target,����-1
 public static int find(Comparable[] arr, Comparable target) {

     // ��arr[l...r]֮�в���target
     int l = 0, r = arr.length-1;
     while( l <= r ){

         //int mid = (l + r)/2;
         // ��ֹ��������µ����������ʹ��������߼����mid
         int mid = l + (r-l)/2;

         if( arr[mid].compareTo(target) == 0 )
             return mid;

         if( arr[mid].compareTo(target) > 0 )
             r = mid - 1;
         else
             l = mid + 1;
     }

     return -1;
 }

 // ���Էǵݹ�Ķ��ֲ����㷨
 public static void main(String[] args) {

     int N = 1000000;
     Integer[] arr = new Integer[N];
     for(int i = 0 ; i < N ; i ++)
         arr[i] = new Integer(i);

     // �������ǵĴ���������[0...N)
     // ��[0...N)�������ֵʹ�ö��ֲ��ң����ս��Ӧ�þ������ֱ���
     // ��[N...2*N)�������ֵʹ�ö��ֲ��ң���Ϊ��Щ���ֲ���arr�У����Ϊ-1
     for(int i = 0 ; i < 2*N ; i ++) {
         int v = BinarySearch.find(arr, new Integer(i));
         if (i < N)
             assert v == i;
         else
             assert v == -1;
     }

     return;
 }
}
