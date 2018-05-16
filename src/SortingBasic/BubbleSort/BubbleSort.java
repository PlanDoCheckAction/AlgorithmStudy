package SortingBasic.BubbleSort;

public class BubbleSort {

	//�㷨�಻��������κ�ʵ��
	private BubbleSort() {}
	
	public static void sort(Comparable[] arr) {
		
		int n = arr.length;
		boolean swapped = false;
		
		do {
			swapped = false;
			for (int i = 1; i < n; i++) {
				if (arr[i-1].compareTo(arr[i]) > 0) {
					swap(arr, i-1, i);
					swapped = true;
				}
			}
			//�Ż���ÿһ��Bubble Sort��������Ԫ�ط���������λ��
			//������һ����������Ԫ�ؿ��Բ��ٿ���
			n--;
		} while (swapped);
		
	}
	
	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// ����InsertionSort
	public static void main(String[] args) {
		
		// ���������㷨��������
		int N = 20000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("SortingBasic.BubbleSort.BubbleSort", arr);
        
		return;
	}

}
