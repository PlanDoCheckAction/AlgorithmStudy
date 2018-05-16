package BinarySearchTree.LowerBoundAndUpperBoundInBinarySearch;

public class BinarySearch {

    private BinarySearch(){}

    // ���ֲ��ҷ�, ʵ��lower_bound
    // ����һ����������arr��, Ѱ�Ҵ��ڵ���target��Ԫ�صĵ�һ������
    // �������, �򷵻���Ӧ������index
    // ����, ����arr��Ԫ�ظ��� n
    public static int lower_bound(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        int l = 0, r = arr.length;
        while(l != r){
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(target) < 0)
                l = mid + 1;
            else    // nums[mid] >= target
                r = mid;
        }
        return l;
    }

    // ���ֲ��ҷ�, ʵ��upper_bound
    // ����һ����������arr��, Ѱ�Ҵ���target��Ԫ�صĵ�һ������
    // �������, �򷵻���Ӧ������index
    // ����, ����arr��Ԫ�ظ��� n
    public static int upper_bound(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        int l = 0, r = arr.length;
        while(l != r){
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(target) <= 0)
                l = mid + 1;
            else    // nums[mid] > target
                r = mid;
        }
        return l;
    }
}