package BinarySearchTree.BinarySearch;

//�ȽϷǵݹ�͵ݹ�д���Ķ��ֲ��ҵ�Ч��
//�ǵݹ��㷨����������΢������
public class Main {

 private Main(){}

 public static void main(String[] args) {

     int N = 1000000;
     Integer[] arr = new Integer[N];
     for(int i = 0 ; i < N ; i ++)
         arr[i] = new Integer(i);


     // ���Էǵݹ���ֲ��ҷ�
     long startTime = System.currentTimeMillis();

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
     long endTime = System.currentTimeMillis();

     System.out.println("Binary Search (Without Recursion): " + (endTime - startTime) + "ms");


     // ���Եݹ�Ķ��ֲ��ҷ�
     startTime = System.currentTimeMillis();

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
     endTime = System.currentTimeMillis();
     System.out.println("Binary Search (With Recursion): " + (endTime - startTime) + "ms");

 }
}
