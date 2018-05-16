package SortingBasic.SelectionSort;

public class SelectionSort {

	//算法类不允许产生任何实例
	private SelectionSort() {}
	
	public static void sort(int[] arr) {
		
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			//寻找[i,n)区间里的最小值的索引赋值给minIndex
			int minIndex = i;
			for (int j = i+1; j < n; j++) {
				if( arr[j] < arr[minIndex])
					minIndex = j;
			}
			swap( arr, i, minIndex );//交换两索引对应的值
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main(String[] args) {
		int[] arr = {10,9,8,7,6,5,4,3,2,1};
		SelectionSort.sort(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}

}
