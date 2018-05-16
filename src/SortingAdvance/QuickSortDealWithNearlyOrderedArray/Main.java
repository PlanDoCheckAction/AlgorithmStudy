package SortingAdvance.QuickSortDealWithNearlyOrderedArray;

import java.util.Arrays;

public class Main {

	// �Ƚ�Merge Sort��Quick Sort���������㷨������Ч��
    // ���������㷨��Ȼ����O(nlogn)�����, ����Quick Sort�㷨�г�����������
    // Quick SortҪ��Merge Sort��, ��ʹ���Ƕ�Merge Sort�������Ż�
	public static void main(String[] args) {

		int N = 50000;
		
		// ����1��һ�����
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.QuickSortDealWithNearlyOrderedArray.QuickSort", arr1);
		SortTestHelper.testSort("SortingAdvance.QuickSortDealWithNearlyOrderedArray.MergeSortBU", arr2);

		System.out.println();
		
		// ����2�����Խ������������
		// ���������ѡ��궨��Ĳ����, ���ǵĿ�������������ɴ���������������
        // ���Ƕ��ڽ������������, ��Ч�ʱ��Ż���Ĺ鲢����Ҫ��, ����ȫ�����̷�Χ��
		int swapTimes = 10;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.QuickSortDealWithNearlyOrderedArray.QuickSort", arr1);
		SortTestHelper.testSort("SortingAdvance.QuickSortDealWithNearlyOrderedArray.MergeSortBU", arr2);
		
		// ����3 ���Դ��ڰ���������ͬԪ�ص�����
        // ����ʱ, ���ں��д�����ͬԪ�ص�����, ���ǵĿ��������㷨�ٴ��˻�����O(n^2)������㷨
		System.out.println("Test for random array, size = " + N + " , random range [0,10]");
        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
		
        SortTestHelper.testSort("SortingAdvance.QuickSortDealWithNearlyOrderedArray.QuickSort", arr1);
        SortTestHelper.testSort("SortingAdvance.QuickSortDealWithNearlyOrderedArray.MergeSortBU", arr2);
		return;
	}

}
