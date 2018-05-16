package SortingAdvance.MergeSortAdvance;

import java.util.Arrays;

public class Main {

	// �Ƚ�InsertionSort��MergeSort���������㷨������Ч��
    // �������,MergeSort����������,���ڽ��������������������,������3����ϸע��
	public static void main(String[] args) {

		int N = 50000;
		
		// ����1��һ�����
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);//����arr1����Ԫ��
		
		SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.InsertionSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.MergeSort", arr2);
		SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.MergeSort2", arr3);

		System.out.println();
		
		// ����2�������Ը�ǿ�Ĳ���
		System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");
		
		arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		arr3 = Arrays.copyOf(arr1, arr1.length);//����arr1����Ԫ��
		
		SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.InsertionSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.MergeSort", arr2);
		SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.MergeSort2", arr3);

		System.out.println();
		
		// ����3�����Խ������������
		int swapTimes = 10;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		arr3 = Arrays.copyOf(arr1, arr1.length);//����arr1����Ԫ��
		
		SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.InsertionSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.MergeSort", arr2);
		SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.MergeSort2", arr3);
		
		return;
	}

}
