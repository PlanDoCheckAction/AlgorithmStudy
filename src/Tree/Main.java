package Tree;

public class Main {

	//���ֲ��ҷ�������������arr�У�����target
	//����ҵ�target,������Ӧ������index
	//���û���ҵ�target,����-1
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
		System.out.println(arr[index] + "������ֵΪ��" + index);
	}

}
