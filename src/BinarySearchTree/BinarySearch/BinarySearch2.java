package BinarySearchTree.BinarySearch;

//�ݹ�Ķ��ֲ����㷨
public class BinarySearch2 {

 // ���ǵ��㷨�಻��������κ�ʵ��
 private BinarySearch2() {}

 private static int find(Comparable[] arr, int l, int r, Comparable target){

     if( l > r )
         return -1;

     //int mid = (l+r)/2;
     // ��ֹ��������µ����������ʹ��������߼����mid
     int mid = l + (r-l)/2;

     if( arr[mid].compareTo(target) == 0 )
         return mid;
     else if( arr[mid].compareTo(target) > 0 )
         return find(arr, l, mid-1, target);
     else
         return find(arr, mid+1, r, target);
 }

 // ���ֲ��ҷ�,����������arr��,����target
 // ����ҵ�target,������Ӧ������index
 // ���û���ҵ�target,����-1
 public static int find(Comparable[] arr, Comparable target) {

     return find(arr, 0, arr.length-1, target);
 }

 // ���Եݹ�Ķ��ֲ����㷨
 public static void main(String[] args) {

     int N = 1000000;
     Integer[] arr = new Integer[N];
     for(int i = 0 ; i < N ; i ++)
         arr[i] = new Integer(i);

     // �������ǵĴ���������[0...N)
     // ��[0...N)�������ֵʹ�ö��ֲ��ң����ս��Ӧ�þ������ֱ���
     // ��[N...2*N)�������ֵʹ�ö��ֲ��ң���Ϊ��Щ���ֲ���arr�У����Ϊ-1
     for(int i = 0 ; i < 2*N ; i ++) {
         int v = BinarySearch2.find(arr, new Integer(i));
         if (i < N)
             assert v == i;
         else
             assert v == -1;
     }

     return;
 }
}
