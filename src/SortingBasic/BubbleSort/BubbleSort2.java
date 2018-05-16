package SortingBasic.BubbleSort;

public class BubbleSort2 {

	//�㷨�಻��������κ�ʵ��
	private BubbleSort2() {}
	
	public static void sort(Comparable[] arr) {
		
		int n = arr.length;
		int newn;//ʹ��newn�����Ż�
		
		do {
			newn = 0;
			for (int i = 1; i < n; i++) {
				if (arr[i-1].compareTo(arr[i]) > 0) {
					swap(arr, i-1, i);
					
					// ��¼���һ�εĽ���λ�ã��ڴ�֮���Ԫ������һ��ɨ���о�������
					newn = i;
				}
			}
			//�Ż���ÿһ��Bubble Sort��������Ԫ�ط���������λ��
			//������һ����������Ԫ�ؿ��Բ��ٿ���
			n = newn;
		} while (newn > 0);
		
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
		SortTestHelper.testSort("SortingBasic.BubbleSort.BubbleSort2", arr);
        
		return;
	}

}
