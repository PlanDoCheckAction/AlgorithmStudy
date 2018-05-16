package SortingAdvance.ShellSortMergeSortAndQuickSortComparison;

import java.util.Arrays;

public class Main {

	// �Ƚ� Shell Sort �� Merge Sort �� ���� Quick Sort ������Ч��
    // ʹ�ø���ѧ�ıȽϷ�ʽ, ÿ�αȽ϶����ж�β�������, ȡƽ��ֵ
    // ���Կ���, Shell Sort��Ȼ���ڸ߼�������ʽ, ����Ȼ�Ƿǳ��о�������һ�������㷨
    // �������ѵ�ʱ����ȫ�ڿ������̵ķ�Χ��, Զ����O(n^2)�������㷨, ���������ϴ��ʱ���޷�����
    // ͬʱ, Shell Sortʵ�ּ�, ֻʹ��ѭ���ķ�ʽ�����������, ����Ҫʵ�ֵݹ�, ��ռ��ϵͳռ�ռ�, Ҳ�����������
    // ����, ����㷨ʵ����ʹ�õĻ���������ʵ�ָ��ӵ������㷨, ��������Ŀ���̵Ĳ��Խ׶�, ��ȫ������ʱʹ��Shell Sort��������������:)
    public static void main(String[] args) {

        // ����T����������, ÿ�����������������СΪn
        int T = 100;
        int N = 1000000;

        // �Ƚ� Shell Sort �� Merge Sort �� ���� Quick Sort ������Ч��
        long time1 = 0, time2 = 0, time3 = 0, time4 = 0, time5 = 0;
        for( int i = 0 ; i < T ; i ++ ) {
            Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
            Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);

            time1 += SortTestHelper.testSort2("SortingAdvance.ShellSortMergeSortAndQuickSortComparison.ShellSort", arr1);
            time2 += SortTestHelper.testSort2("SortingAdvance.ShellSortMergeSortAndQuickSortComparison.MergeSort3", arr2);
            time3 += SortTestHelper.testSort2("SortingAdvance.ShellSortMergeSortAndQuickSortComparison.QuickSort", arr3);
            time4 += SortTestHelper.testSort2("SortingAdvance.ShellSortMergeSortAndQuickSortComparison.QuickSort2Ways", arr4);
            time5 += SortTestHelper.testSort2("SortingAdvance.ShellSortMergeSortAndQuickSortComparison.QuickSort3Ways", arr5);
        }
        System.out.println("Sorting " + N + " elements " + T + " times. Calculate the average run time.");
        System.out.println("Shell Sort        Average Run Time: " + time1/T + " ms");
        System.out.println("Merge Sort        Average Run Time: " + time2/T + " ms");
        System.out.println("Quick Sort        Average Run Time: " + time3/T + " ms");
        System.out.println("Quick Sort 2 Ways Average Run Time: " + time4/T + " ms");
        System.out.println("Quick Sort 3 Ways Average Run Time: " + time5/T + " ms");


        return;
    }

}
