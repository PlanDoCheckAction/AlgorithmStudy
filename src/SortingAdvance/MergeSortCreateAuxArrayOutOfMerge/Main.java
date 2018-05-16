package SortingAdvance.MergeSortCreateAuxArrayOutOfMerge;

import java.util.Arrays;

public class Main {

	// 比较Merge Sort 2和Merge Sort 3的性能效率
    // Merge Sort 2 只开辟了一次辅助空间, 之后将这个辅助空间以参数形式传递给完成归并排序的其他子函数
    // 可以看出 Merge Sort 2的性能优于 Merge Sort
	public static void main(String[] args) {

		int N = 1000000;
		
		// 测试1：一般测试
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortCreateAuxArrayOutOfMerge.MergeSort2", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortCreateAuxArrayOutOfMerge.MergeSort3", arr2);

		System.out.println();
		
		// 测试2：测试近乎有序的数组
		int swapTimes = 100;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);
		
		SortTestHelper.testSort("SortingAdvance.MergeSortCreateAuxArrayOutOfMerge.MergeSort2", arr1);
		SortTestHelper.testSort("SortingAdvance.MergeSortCreateAuxArrayOutOfMerge.MergeSort3", arr2);
		
		return;
	}

}
