package Sort;

//排序算法
public class Main {

	public static void swap(int[] arr, int x, int y) {
		int t = arr[x];
		arr[x] = arr[y];
		arr[y] = t;
	}

	// 插入排序算法(优化后的插入排序算法)//时间复杂度为O(n²)
	public static void insertionSort(int arr[], int n) {

		for (int i = 1; i < n; i++) {

			int e = arr[i];
			int j;
			// 寻找元素arr[i]合适的插入位置
			for (j = i; j > 0 && arr[j - 1] > e; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = e;

		}

	}

	// 插入排序算法//时间复杂度为O(n²)
	public static void insertionSort2(int arr[], int n) {

		for (int i = 1; i < n; i++) {

			// 寻找元素arr[i]合适的插入位置
			for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
				swap(arr, j, j - 1);
			}

		}

	}

	// 选择排序算法//时间复杂度为O(n²)
	public static void selectionSort(int arr[], int n) {

		for (int i = 0; i < n; i++) {
			int minIndex = i;
			// 依次找出最小的数的索引值
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			swap(arr, i, minIndex);
		}
	}

	// 冒泡排序算法//时间复杂度为O(n²)
	public static void bubbleSort(int arr[], int n) {

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	private static void __merge(int arr[], int l, int mid, int r) {
		int[] aux = new int[r - l + 1];
		for (int i = l; i <= r; i++)
			aux[i - l] = arr[i];

		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				arr[k] = aux[j - l];
				j++;
			} else if (j > r) {
				arr[k] = aux[i - l];
				i++;
			} else if (aux[i - l] < aux[j - l]) {
				arr[k] = aux[i - l];
				i++;
			} else {
				arr[k] = aux[j - l];
				j++;
			}
		}
	}

	private static void __mergeSort(int arr[], int l, int r) {

		if (l >= r)
			return;
		
		int mid = (l + r) / 2;
		__mergeSort(arr, l, mid);
		__mergeSort(arr, mid + 1, r);
		if(arr[mid] > arr[mid+1])//优化，当数组本身已经是有序的时候，不进行排序
			__merge(arr, l, mid, r);
	}

	//自顶向下归并排序
	public static void mergeSort(int arr[], int n) {
		__mergeSort(arr, 0, n - 1);
	}
	
	//自底向上归并排序
	public static void mergeSortBU(int arr[], int n) {
		
		for (int size = 1; size <= n; size += size) {
			for (int i = 0; i + size < n; i += size + size) {
				//对 arr[i...i+size-1] 和 arr[i+size...i+2*size-1] 进行归并
				if(arr[i + size - 1] > arr[i + size])
					__merge(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1));
			}
		}
	}
	
	private static int __partition(int arr[], int l, int r) {
		
		swap(arr, l, (int)(Math.random()*(r-l+1))+l);
		
		int v = arr[l];
		
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if(arr[i] < v) {
				swap(arr, j+1, i);
				j++;
				//上面两条语句可合并为swap(arr, ++j, i);
			}
		}
		
		swap(arr, l, j);
		
		return j;
	}
	
	private static void __quickSort(int arr[], int l, int r) {
		if( l >= r)
			return;
		
		int p = __partition(arr, l, r);
		__quickSort(arr, l, p-1);
		__quickSort(arr, p+1, r);
	}
	
	//快速排序
	public static void quickSort(int arr[], int n) {
		__quickSort(arr,0,n-1);
	}
	
	private static int __partition2(int arr[], int l, int r) {
		
		swap(arr, l, (int)(Math.random()*(r-l+1))+l);
		int v = arr[l];
		
		int i = l+1, j = r;
		while(true) {
			while (i <= r && arr[i] < v) i++;
			while (j >= l+1 && arr[j] > v) j--;
			if(i > j) break;
			swap(arr, i, j);
			i++;
			j--;
		}
		swap(arr, l, j);
		
		
		return j;
	}
	
	private static void __quickSort2(int arr[], int l, int r) {
		if( l >= r)
			return;
		
		int p = __partition2(arr, l, r);
		__quickSort2(arr, l, p-1);
		__quickSort2(arr, p+1, r);
	}
	
	//双路快速排序法
	public static void quickSort2(int arr[], int n) {
		__quickSort2(arr,0,n-1);
	}
	
	
	private static void __quickSort3Ways(int arr[], int l, int r) {
		if( l >= r)
			return;
		
		//partition
		swap(arr, l, (int)(Math.random()*(r-l+1))+l);
		int v = arr[l];
		
		int lt = l, gt = r + 1, i = l + 1;
		while(i < gt) {
			if( arr[i] < v) {
				swap(arr, i, lt+1);
				lt++;
				i++;
			} else if ( arr[i] > v) {
				swap(arr, i, gt-1);
				gt--;
			} else {
				i++;
			}
		}
		swap(arr, l, lt);
		
		//int p = __partition2(arr, l, r);
		__quickSort3Ways(arr, l, lt-1);
		__quickSort3Ways(arr, gt, r);
	}
	
	//三路快速排序
	public static void quickSort3Ways(int arr[], int n) {
		__quickSort3Ways(arr,0,n-1);
	}
	
	public static void main(String[] args) {
		int[] arr = { 4, 5, 9, 4, 3, 2, 1, 8 };
		// insertionSort(arr, arr.length);//插入排序
		// selectionSort(arr, arr.length);//选择排序
		// bubbleSort(arr, arr.length);//冒泡排序
		//mergeSort(arr, arr.length);//自顶向下归并排序
		//mergeSortBU(arr, arr.length);//自底向上归并排序
		//quickSort(arr, arr.length);//快速排序
		//quickSort2(arr, arr.length);//双路快速排序法
		quickSort3Ways(arr, arr.length);//三路快速排序
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
