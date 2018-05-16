package BinarySearchTree.LowerBoundAndUpperBoundInBinarySearch;

public class LinearSearch {

    private LinearSearch(){}

    // ���Բ��ҷ�, ʵ��lower_bound
    // ����һ����������arr��, Ѱ�Ҵ��ڵ���target��Ԫ�صĵ�һ������
    // �������, �򷵻���Ӧ������index
    // ����, ����arr��Ԫ�ظ��� n
    public static int lower_bound(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        for(int i = 0 ; i < arr.length ; i ++)
            if(arr[i].compareTo(target) >= 0)
                return i;

        return arr.length;
    }

    // ���Բ��ҷ�, ʵ��upper_bound
    // ����һ����������arr��, Ѱ�Ҵ���target��Ԫ�صĵ�һ������
    // �������, �򷵻���Ӧ������index
    // ����, ����arr��Ԫ�ظ��� n
    public static int upper_bound(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        for(int i = 0 ; i < arr.length ; i ++)
            if(arr[i].compareTo(target) > 0)
                return i;

        return arr.length;
    }
}

