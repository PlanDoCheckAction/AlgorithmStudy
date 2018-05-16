package SortingAdvance.MergeSortBottomUp;

import java.util.Arrays;

public class Main {

	// 比较Merge Sort和Merge Sort Bottom Up两种排序算法的性能效率
    // 整体而言, 两种算法的效率是差不多的。但是如果进行仔细测试, 自底向上的归并排序会略胜一筹。
	public static void main(String[] args) {

		int N = 50000;
		
		// 测试1：一般测试
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSortBU", arr2);

		System.out.println();
		
		// 测试2：有序性更强的测试
		System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");
		
		arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSortBU", arr2);

		System.out.println();
		
		// 测试3：测试近乎有序的数组
		int swapTimes = 10;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSort", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSortBU", arr2);
		
		return;
	}

}
