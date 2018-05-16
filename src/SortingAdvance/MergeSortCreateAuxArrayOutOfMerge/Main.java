package SortingAdvance.MergeSortCreateAuxArrayOutOfMerge;

import java.util.Arrays;

public class Main {

	// �Ƚ�Merge Sort 2��Merge Sort 3������Ч��
    // Merge Sort 2 ֻ������һ�θ����ռ�, ֮����������ռ��Բ�����ʽ���ݸ���ɹ鲢����������Ӻ���
    // ���Կ��� Merge Sort 2���������� Merge Sort
	public static void main(String[] args) {

		int N = 1000000;
		
		// ����1��һ�����
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortCreateAuxArrayOutOfMerge.MergeSort2", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortCreateAuxArrayOutOfMerge.MergeSort3", arr2);

		System.out.println();
		
		// ����2�����Խ������������
		int swapTimes = 100;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortCreateAuxArrayOutOfMerge.MergeSort2", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortCreateAuxArrayOutOfMerge.MergeSort3", arr2);
		
		return;
	}

}
