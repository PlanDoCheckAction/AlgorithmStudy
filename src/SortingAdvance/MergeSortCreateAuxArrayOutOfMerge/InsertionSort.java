package SortingAdvance.MergeSortCreateAuxArrayOutOfMerge;

public class InsertionSort {

	//算法类不允许产生任何实例
	private InsertionSort() {}
	
	public static void sort(Comparable[] arr) {
		
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			//寻找元素arr[i]合适的插入位置
			
			//写法1
			/*for (int j = i; j > 0; j--) {
				if (arr[j].compareTo(arr[j-1]) < 0) 
					swap(arr, j, j-1);
				else 
					break;
			}*/
			
			//写法2
			for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--) {
				swap(arr, j, j-1);
			}
		}
		
	}
	
	//对arr[l...r]的区间使用InsertionSort排序
	public static void sort(Comparable[] arr, int l, int r) {
		
		for (int i = l + 1; i <= r; i++) {
			Comparable e = arr[i];
			int j = i;
			for (; j > l && arr[j-1].compareTo(e) > 0 ; j--)
				arr[j] = arr[j-1];
			arr[j] = e;
		}
		
	}
	
	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// 测试InsertionSort
	public static void main(String[] args) {
		
		// 测试排序算法辅助函数
		int N = 20000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("SortingBasic.InsertionSort.InsertionSort", arr);
        
		return;
	}

}
