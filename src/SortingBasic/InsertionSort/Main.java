package SortingBasic.InsertionSort;

import java.util.Arrays;

public class Main {

	// �Ƚ�SelectionSort��InsertionSort���������㷨������Ч��
    // ��ʱ�����������ѡ�����������Ե�
	public static void main(String[] args) {

		int N = 20000;
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);//����arr1����Ԫ��
		
		SortTestHelper.testSort("SortingBasic.InsertionSort.SelectionSort", arr1);
		SortTestHelper.testSort("SortingBasic.InsertionSort.InsertionSort", arr2);
		
		return;
	}

}
