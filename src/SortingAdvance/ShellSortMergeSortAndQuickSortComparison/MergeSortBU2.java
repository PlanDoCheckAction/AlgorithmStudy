package SortingAdvance.ShellSortMergeSortAndQuickSortComparison;

import java.util.Arrays;

public class MergeSortBU2 {

	//算法类不允许产生任何实例
	private MergeSortBU2() {}
	
	//将arr[l...mid]和arr[mid+1...r]两部分进行归并
	public static void merge(Comparable[] arr, int l, int mid, int r) {
		
		Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
		
		// 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {
			
			if (i > mid) {//如果左半部分元素已经全部处理完毕
				arr[k] = aux[j-l];
				j++;
			} else if (j > r) {//如果右半部分元素已经全部处理完毕
				arr[k] = aux[i-l];
				i++;
			} else if (aux[i-l].compareTo(aux[j-l]) < 0) {//左半部分所指元素  < 右半部分所指元素
				arr[k] = aux[i-l];
				i++;
			} else {//左半部分所指元素 >= 右半部分所指元素
				arr[k] = aux[j-l];
				j++;
			}
		}
		
	}
	
	public static void sort(Comparable[] arr) {

		int n = arr.length;
		
		// Merge Sort Bottom Up 优化
		// 对于小数组,使用插入排序优化
		for (int i = 0; i < n; i += 16) 
			InsertionSort.sort(arr, i, Math.min(i+15, n-1));
		
		for (int sz = 16; sz < n; sz += sz) {
			for (int i = 0; i < n - sz; i += sz+sz) {
				//对于arr[mid] <= arr[mid+1]的情况,不进行merge
				if(arr[i+sz-1].compareTo(arr[i+sz]) > 0)
					merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, n-1));
			}
		}
	}

	// 测试MergeSort2
	public static void main(String[] args) {
		
		// Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		// 注意:不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
		// 否则,你就见识了O(n^2)的算法的本质差异
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSortBU", arr);
		SortTestHelper.printArray(arr);
        
		return;
	}

}
