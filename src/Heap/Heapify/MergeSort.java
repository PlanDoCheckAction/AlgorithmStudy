package Heap.Heapify;

//�Զ����µĹ鲢����, ���Ż�
public class MergeSort{

// ���ǵ��㷨�಻��������κ�ʵ��
private MergeSort(){}

// ��arr[l...mid]��arr[mid+1...r]�����ֽ��й鲢
// ����auxΪ���merge��������Ҫ�ĸ����ռ�
private static void merge(Comparable[] arr, Comparable[] aux, int l, int mid, int r) {

   System.arraycopy(arr, l, aux, l, r-l+1);

   // ��ʼ����iָ����벿�ֵ���ʼ����λ��l��jָ���Ұ벿����ʼ����λ��mid+1
   int i = l, j = mid+1;
   for( int k = l ; k <= r; k ++ ){

       if( i > mid ){  // �����벿��Ԫ���Ѿ�ȫ���������
           arr[k] = aux[j]; j ++;
       }
       else if( j > r ){   // ����Ұ벿��Ԫ���Ѿ�ȫ���������
           arr[k] = aux[i]; i ++;
       }
       else if( aux[i].compareTo(aux[j]) < 0 ){  // ��벿����ָԪ�� < �Ұ벿����ָԪ��
           arr[k] = aux[i]; i ++;
       }
       else{  // ��벿����ָԪ�� >= �Ұ벿����ָԪ��
           arr[k] = aux[j]; j ++;
       }
   }
}

// �ݹ�ʹ�ù鲢����,��arr[l...r]�ķ�Χ��������
// ����auxΪ���merge��������Ҫ�ĸ����ռ�
private static void sort(Comparable[] arr, Comparable[] aux, int l, int r) {

   // ����С��ģ����, ʹ�ò�������
   if( r - l <= 15 ){
       InsertionSort.sort(arr, l, r);
       return;
   }

   int mid = (l+r)/2;
   sort(arr, aux, l, mid);
   sort(arr, aux, mid + 1, r);
   // ����arr[mid] <= arr[mid+1]�����,������merge
   // ���ڽ������������ǳ���Ч,���Ƕ���һ�����,��һ����������ʧ
   if( arr[mid].compareTo(arr[mid+1]) > 0 )
       merge(arr, aux, l, mid, r);
}

public static void sort(Comparable[] arr){

   int n = arr.length;
   Comparable[] aux = new Comparable[n];
   sort(arr, aux, 0, n-1);
}

// ���� MergeSort
public static void main(String[] args) {

   int N = 1000000;
   Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
   SortTestHelper.testSort("Heap.Heapify.MergeSort", arr);

   return;
}
}