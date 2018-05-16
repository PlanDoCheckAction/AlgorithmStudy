package SortingBasic.InsertionSort;

public class SelectionSort {

	//�㷨�಻��������κ�ʵ��
	private SelectionSort() {}
	
	public static void sort(Comparable[] arr) {
		
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			//Ѱ��[i,n)���������Сֵ��������ֵ��minIndex
			int minIndex = i;
			for (int j = i+1; j < n; j++) {
				//ʹ��compareTo�����Ƚ�����Comparable����Ĵ�С
				if( arr[j].compareTo(arr[minIndex]) < 0)
					minIndex = j;
			}
			swap( arr, i, minIndex );//������������Ӧ��ֵ
		}
	}
	
	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main(String[] args) {
		
		// ���������㷨��������
		int N = 20000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("SortingBasic.InsertionSort.SelectionSort", arr);
        
		return;
	}

}
