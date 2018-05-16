package SortingAdvance.QuickSortThreeWays;

import java.util.Arrays;

public class MergeSortBU {

	//�㷨�಻��������κ�ʵ��
	private MergeSortBU() {}
	
	//��arr[l...mid]��arr[mid+1...r]�����ֽ��й鲢
	public static void merge(Comparable[] arr, int l, int mid, int r) {
		
		Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
		
		// ��ʼ����iָ����벿�ֵ���ʼ����λ��l��jָ���Ұ벿����ʼ����λ��mid+1
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {
			
			if (i > mid) {//�����벿��Ԫ���Ѿ�ȫ���������
				arr[k] = aux[j-l];
				j++;
			} else if (j > r) {//����Ұ벿��Ԫ���Ѿ�ȫ���������
				arr[k] = aux[i-l];
				i++;
			} else if (aux[i-l].compareTo(aux[j-l]) < 0) {//��벿����ָԪ��  < �Ұ벿����ָԪ��
				arr[k] = aux[i-l];
				i++;
			} else {//��벿����ָԪ�� >= �Ұ벿����ָԪ��
				arr[k] = aux[j-l];
				j++;
			}
		}
		
	}
	
	public static void sort(Comparable[] arr) {

		int n = arr.length;
		// Merge Sort Bottom Up ���Ż��汾
		/*for (int sz = 1; sz < n; sz *= 2) {
			for (int i = 0; i < n - sz; i += sz+sz) {
				//��arr[i...i+sz-1]��arr[i+sz...i+2*sz-1]���й鲢
				merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, n-1));
			}
		}*/
		
		// Merge Sort Bottom Up �Ż�
		// ����С����,ʹ�ò��������Ż�
		for (int i = 0; i < n; i += 16) 
			InsertionSort.sort(arr, i, Math.min(i+15, n-1));
		
		for (int sz = 16; sz < n; sz += sz) {
			for (int i = 0; i < n - sz; i += sz+sz) {
				//����arr[mid] <= arr[mid+1]�����,������merge
				if(arr[i+sz-1].compareTo(arr[i+sz]) > 0)
					merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, n-1));
			}
		}
	}

	// ����MergeSort2
	public static void main(String[] args) {
		
		// Merge Sort������ѧϰ�ĵ�һ��O(nlogn)���Ӷȵ��㷨
		// ������1��֮�����ɴ���100��������������
		// ע��:��Ҫ���׳���ʹ��SelectionSort, InsertionSort����BubbleSort����100�򼶵�����
		// ����,��ͼ�ʶ��O(n^2)���㷨�ı��ʲ���
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("SortingAdvance.MergeSortBottomUp.MergeSortBU", arr);
		SortTestHelper.printArray(arr);
        
		return;
	}

}
