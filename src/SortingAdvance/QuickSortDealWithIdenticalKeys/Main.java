package SortingAdvance.QuickSortDealWithIdenticalKeys;

import java.util.Arrays;

public class Main {

	// �Ƚ�Merge Sort��Quick Sort 2 Ways���������㷨������Ч��
	public static void main(String[] args) {

		int N = 50000;
		
		// ����1��һ�����
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.QuickSortDealWithIdenticalKeys.QuickSort2Ways", arr1);
		SortTestHelper.testSort("SortingAdvance.QuickSortDealWithIdenticalKeys.MergeSortBU", arr2);

		System.out.println();
		
		// ����2�����Խ������������
		// ˫·���������㷨Ҳ�������ɴ���������������
		int swapTimes = 10;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.QuickSortDealWithIdenticalKeys.QuickSort2Ways", arr1);
		SortTestHelper.testSort("SortingAdvance.QuickSortDealWithIdenticalKeys.MergeSortBU", arr2);
		
		// ����3 ���Դ��ڰ���������ͬԪ�ص�����
		// ʹ��˫���������, ���ǵĿ��������㷨�������ɵĴ����������Ԫ�ص�����
		System.out.println("Test for random array, size = " + N + " , random range [0,10]");
        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
		
        SortTestHelper.testSort("SortingAdvance.QuickSortDealWithIdenticalKeys.QuickSort2Ways", arr1);
        SortTestHelper.testSort("SortingAdvance.QuickSortDealWithIdenticalKeys.MergeSortBU", arr2);
		return;
	}

}
