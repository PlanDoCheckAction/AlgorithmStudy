package Heap.MinHeap;

public class MinHeapSort {

    // ���ǵ��㷨�಻��������κ�ʵ��
    private MinHeapSort(){}

    // �����е�Ԫ��������ӵ���С����, ���ڽ�����Ԫ�شӶ�������ȡ����, �������
    // ʹ��������һ����С������, ���������ǵ���С�ѵ���ȷ��
    // ˼����ʹ����С�ѿɲ����Ա�д���6С�������ܵ��Ż��Ŀ��������㷨��
    public static void sort(Comparable[] arr){

        int n = arr.length;
        MinHeap<Comparable> minHeap = new MinHeap<Comparable>(n);
        for( int i = 0 ; i < n ; i ++ )
            minHeap.insert(arr[i]);

        for( int i = 0 ; i < n ; i ++ )
            arr[i] = minHeap.extractMin();
    }

    // ���� MinHeapSort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("Heap.MinHeap.MinHeapSort", arr);

        return;
    }
}