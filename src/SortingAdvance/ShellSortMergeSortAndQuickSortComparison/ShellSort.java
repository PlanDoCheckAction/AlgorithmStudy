package SortingAdvance.ShellSortMergeSortAndQuickSortComparison;

public class ShellSort {

	//�㷨�಻��������κ�ʵ��
	private ShellSort() {}
	
	public static void sort(Comparable[] arr) {
		
		int n = arr.length;

        // ���� increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {

            // h-sort the array
            for (int i = h; i < n; i++) {

                // �� arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... ʹ�ò�������
                Comparable e = arr[i];
                int j = i;
                for ( ; j >= h && e.compareTo(arr[j-h]) < 0 ; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            h /= 3;
        }
		
	}

}
