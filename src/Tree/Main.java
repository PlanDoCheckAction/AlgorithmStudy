package Tree;

public class Main {

	//二分查找法，在有序数组arr中，查找target
	//如果找到target,返回相应的索引index
	//如果没有找到target,返回-1
	public static int binarySearchTree(int arr[], int n, int target) {
		
		int l = 0, r = n-1;
		while(l <= r) {
			int mid = l + (r-l)/2;
			if(arr[mid] == target) {
				return mid;
			}
			
			if (arr[mid] < target) {
				r = mid-1;
			}
			
			if (arr[mid] > target) {
				l = mid+1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int index = binarySearchTree(arr, 10, 5);
		System.out.println(arr[index] + "的索引值为：" + index);
	}

}
