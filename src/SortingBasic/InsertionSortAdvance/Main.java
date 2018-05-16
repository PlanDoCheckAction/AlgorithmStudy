package SortingBasic.InsertionSortAdvance;

import java.util.Arrays;

public class Main {

	// �Ƚ�SelectionSort��InsertionSort���������㷨������Ч��
    // �Ż��󣬲��������ѡ�����������Ժ�
	// ����������ǿ�����飬��������ԶԶ����ѡ������
	public static void main(String[] args) {

		int N = 20000;
		
		// ����1��һ�����
		System.out.println("Test for random array, size = " + N + " , random range [0," + N + "]");
		
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);//����arr1����Ԫ��
		
		SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.SelectionSort", arr1);
		SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.InsertionSort", arr2);

		System.out.println();
		
		// ����2�������Ը�ǿ�Ĳ���
		System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");
		
		arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
		arr2 = Arrays.copyOf(arr1, arr1.length);//����arr1����Ԫ��
		
		SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.SelectionSort", arr1);
		SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.InsertionSort", arr2);

		System.out.println();
		
		// ����3�����Խ������������
		int swapTimes = 500;
		System.out.println("Test for nearly ordered random array, size = " + N + " , swap time = " + swapTimes);
		
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, arr1.length);//����arr1����Ԫ��
		
		SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.SelectionSort", arr1);
		SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.InsertionSort", arr2);
		
		return;
	}

}
