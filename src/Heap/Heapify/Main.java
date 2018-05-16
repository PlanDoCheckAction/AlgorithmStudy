package Heap.Heapify;

import java.util.Arrays;

public class Main {

	/// �Ƚ� Merge Sort, ���� Quick Sort �ͱ��ڽ��ܵ����� Heap Sort ������Ч��
    // ע��, �⼸�������㷨���� O(nlogn) ����������㷨
    public static void main(String[] args) {

        int N = 1000000;

        // ����1 һ���Բ���
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Heap.Heapify.MergeSort", arr1);
        SortTestHelper.testSort("Heap.Heapify.QuickSort", arr2);
        SortTestHelper.testSort("Heap.Heapify.QuickSort2Ways", arr3);
        SortTestHelper.testSort("Heap.Heapify.QuickSort3Ways", arr4);
        SortTestHelper.testSort("Heap.Heapify.HeapSort1", arr5);
        SortTestHelper.testSort("Heap.Heapify.HeapSort2", arr6);

        System.out.println();


        // ����2 ���Խ������������
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Heap.Heapify.MergeSort", arr1);
        SortTestHelper.testSort("Heap.Heapify.QuickSort", arr2);
        SortTestHelper.testSort("Heap.Heapify.QuickSort2Ways", arr3);
        SortTestHelper.testSort("Heap.Heapify.QuickSort3Ways", arr4);
        SortTestHelper.testSort("Heap.Heapify.HeapSort1", arr5);
        SortTestHelper.testSort("Heap.Heapify.HeapSort2", arr6);

        System.out.println();


        // ����3 ���Դ��ڰ���������ͬԪ�ص�����
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Heap.Heapify.MergeSort", arr1);
        // ���������, ��ͨ��QuickSort�˻�ΪO(n^2)���㷨, ��������
        //SortTestHelper.testSort("Heap.Heapify.QuickSort", arr2);
        SortTestHelper.testSort("Heap.Heapify.QuickSort2Ways", arr3);
        SortTestHelper.testSort("Heap.Heapify.QuickSort3Ways", arr4);
        SortTestHelper.testSort("Heap.Heapify.HeapSort1", arr5);
        SortTestHelper.testSort("Heap.Heapify.HeapSort2", arr6);

        return;
    }
}