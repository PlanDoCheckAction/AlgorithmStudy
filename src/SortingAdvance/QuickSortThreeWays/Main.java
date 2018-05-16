package SortingAdvance.QuickSortThreeWays;

import java.util.Arrays;

public class Main {

	// �Ƚ�Merge Sort��˫·�����������·�������������㷨������Ч��
    // ���ڰ����д����ظ����ݵ�����, ��·�����о޴������
    // ����һ���Ե��������ͽ������������, ��·���ŵ�Ч����Ȼ�������ŵ�, �������ڷǳ����Խ��ܵķ�Χ��
    // ���, ��һЩ������, ��·������Ĭ�ϵ����Կ⺯����ʹ�õ������㷨������Java:)
	public static void main(String[] args) {

		int N = 50000;
		
		// ����1��һ�����
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.MergeSortBU", arr1);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort2Ways", arr2);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort3Ways", arr3);

		System.out.println();
		
		// ����2�����Խ������������
		int swapTimes = 10;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		arr3 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.MergeSortBU", arr1);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort2Ways", arr2);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort3Ways", arr3);
		
		// ����3 ���Դ��ڰ���������ͬԪ�ص�����
		System.out.println("Test for random array, size = " + N + " , random range [0,10]");
        arr1 = SortTestHelper.generateRandomArray(N, 0, 5);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
		
        SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.MergeSortBU", arr1);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort2Ways", arr2);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort3Ways", arr3);
		return;
	}

}
