package SortingAdvance.MergeSortBottomUp;

import java.util.Arrays;

public class Main {

	// �Ƚ�Merge Sort��Merge Sort Bottom Up���������㷨������Ч��
    // �������, �����㷨��Ч���ǲ��ġ��������������ϸ����, �Ե����ϵĹ鲢�������ʤһ�
	public static void main(String[] args) {

		int N = 50000;
		
		// ����1��һ�����
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSortBU", arr2);

		System.out.println();
		
		// ����2�������Ը�ǿ�Ĳ���
		System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");
		
		arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSortBU", arr2);

		System.out.println();
		
		// ����3�����Խ������������
		int swapTimes = 10;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSortBU", arr2);
		
		return;
	}

}
