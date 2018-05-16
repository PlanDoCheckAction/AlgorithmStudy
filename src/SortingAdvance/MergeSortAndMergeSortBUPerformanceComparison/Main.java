package SortingAdvance.MergeSortAndMergeSortBUPerformanceComparison;

import java.util.Arrays;

public class Main {

	// �Ƚ� Merge Sort �� Merge Sort BU ������Ч��
    // ʹ�ø���ѧ�ıȽϷ�ʽ, ÿ�αȽ϶����ж�β�������, ȡƽ��ֵ
    // ͬʱ�Ƚ����Ż��Ͳ��Ż��������
    // ������˵, Merge Sort BU �� Merge Sort ��һЩ�����Ż���, ���ߵ����ܲ�಻����
	public static void main(String[] args) {

		// ����T����������, ÿ�����������������СΪn
		int T = 100;
		int N = 1000000;
		
		// �Ƚ� Merge Sort �� Merge Sort BU �����㷨�ڲ��Ż�������µ�����Ч��
        long time1 = 0, time2 = 0;
        for( int i = 0 ; i < T ; i ++ ) {
            Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
            Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

            time1 += SortTestHelper.testSort2("SortingAdvance.MergeSortAndMergeSortBUPerformanceComparison.MergeSort", arr1);
            time2 += SortTestHelper.testSort2("SortingAdvance.MergeSortAndMergeSortBUPerformanceComparison.MergeSortBU", arr2);
        }
        System.out.println("Without Any Optimization:");
        System.out.println("Merge Sort    Average Run Time: " + time1/T + " ms");
        System.out.println("Merge Sort BU Average Run Time: " + time2/T + " ms");
        System.out.println();


        // �Ƚ� Merge Sort �� Merge Sort BU �����㷨�ں��Ż�������µ�����Ч��
        time1 = 0; time2 = 0;
        for( int i = 0 ; i < T ; i ++ ) {
            Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
            Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

            time1 += SortTestHelper.testSort2("SortingAdvance.MergeSortAndMergeSortBUPerformanceComparison.MergeSort3", arr1);
            time2 += SortTestHelper.testSort2("SortingAdvance.MergeSortAndMergeSortBUPerformanceComparison.MergeSortBU2", arr2);
        }
        System.out.println("With Optimization:");
        System.out.println("Merge Sort    Average Run Time: " + time1/T + " ms");
        System.out.println("Merge Sort BU Average Run Time: " + time2/T + " ms");
        
        return;
	}

}
