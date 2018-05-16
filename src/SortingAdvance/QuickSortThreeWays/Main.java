package SortingAdvance.QuickSortThreeWays;

import java.util.Arrays;

public class Main {

	// 比较Merge Sort和双路快速排序和三路快排三种排序算法的性能效率
    // 对于包含有大量重复数据的数组, 三路快排有巨大的优势
    // 对于一般性的随机数组和近乎有序的数组, 三路快排的效率虽然不是最优的, 但是是在非常可以接受的范围里
    // 因此, 在一些语言中, 三路快排是默认的语言库函数中使用的排序算法。比如Java:)
	public static void main(String[] args) {

		int N = 50000;
		
		// 测试1：一般测试
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.MergeSortBU", arr1);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort2Ways", arr2);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort3Ways", arr3);

		System.out.println();
		
		// 测试2：测试近乎有序的数组
		int swapTimes = 10;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		arr3 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.MergeSortBU", arr1);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort2Ways", arr2);
		SortTestHelper.testSort("SortingAdvance.QuickSortThreeWays.QuickSort3Ways", arr3);
		
		// 测试3 测试存在包含大量相同元素的数组
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
