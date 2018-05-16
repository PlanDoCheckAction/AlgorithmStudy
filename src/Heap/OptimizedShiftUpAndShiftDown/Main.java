package Heap.OptimizedShiftUpAndShiftDown;

import java.util.Arrays;

public class Main {

	// �Ƚ� MaxHeapSort �� MaxHeapOSort �����ܵĲ�ͬ
    // �Դ������� MaxHeap ����ShiftUp��ShiftDown�Ż�ǰ��Ч�ʵĲ�ͬ
    public static void main(String[] args) {

        int N = 1000000;

        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Heap.OptimizedShiftUpAndShiftDown.MaxHeapSort", arr1);
        SortTestHelper.testSort("Heap.OptimizedShiftUpAndShiftDown.MaxHeapOSort", arr2);

        return;
    }
}