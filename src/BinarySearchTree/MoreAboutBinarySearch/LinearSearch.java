package BinarySearchTree.MoreAboutBinarySearch;

public class LinearSearch {

    private LinearSearch(){}

    // ���Բ��ҷ�, ��һ����������arr��, Ѱ�Ҵ��ڵ���target��Ԫ�صĵ�һ������
    // �������, �򷵻���Ӧ������index
    // ����, ����arr��Ԫ�ظ��� n
    // �൱�� lower_bound
    public static int firstGreaterOrEqual(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        for(int i = 0 ; i < arr.length ; i ++)
            if(arr[i].compareTo(target) >= 0)
                return i;

        return arr.length;
    }

    // ���Բ��ҷ�, ��һ����������arr��, Ѱ�Ҵ���target��Ԫ�صĵ�һ������
    // �������, �򷵻���Ӧ������index
    // ����, ����arr��Ԫ�ظ��� n
    // �൱�� upper_bound
    public static int firstGreaterThan(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        for(int i = 0 ; i < arr.length ; i ++)
            if(arr[i].compareTo(target) > 0)
                return i;

        return arr.length;
    }

    // ���Բ��ҷ�, ��һ����������arr��, Ѱ��С�ڵ���target��Ԫ�ص��������
    // �������, �򷵻���Ӧ������index
    // ����, ���� -1
    public static int lastLessOrEqual(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        for(int i = 0 ; i < arr.length ; i ++)
            if(arr[i].compareTo(target) > 0)
                return i - 1;

        return arr.length - 1;
    }

    // ���Բ��ҷ�, ��һ����������arr��, Ѱ��С��target��Ԫ�ص��������
    // �������, �򷵻���Ӧ������index
    // ����, ���� -1
    public static int lastLessThan(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        for(int i = 0 ; i < arr.length ; i ++)
            if(arr[i].compareTo(target) >= 0)
                return i - 1;

        return arr.length - 1;
    }
}
