package BinarySearchTree.MoreAboutBinarySearch;

public class BinarySearch {

    private BinarySearch(){}

    // ���ֲ��ҷ�, ��һ����������arr��, Ѱ�Ҵ��ڵ���target��Ԫ�صĵ�һ������
    // �������, �򷵻���Ӧ������index
    // ����, ����arr��Ԫ�ظ��� n
    // �൱�� lower_bound
    public static int firstGreaterOrEqual(Comparable[] arr, Comparable target){

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

    // ���ֲ��ҷ�, ��һ����������arr��, Ѱ�Ҵ���target��Ԫ�صĵ�һ������
    // �������, �򷵻���Ӧ������index
    // ����, ����arr��Ԫ�ظ��� n
    // �൱�� upper_bound
    public static int firstGreaterThan(Comparable[] arr, Comparable target){

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

    // ���ֲ��ҷ�, ��һ����������arr��, Ѱ��С�ڵ���target��Ԫ�ص��������
    // �������, �򷵻���Ӧ������index
    // ����, ���� -1
    public static int lastLessOrEqual(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        int l = -1, r = arr.length - 1;
        while(l != r){
            int mid = l + (r - l + 1) / 2;
            if(arr[mid].compareTo(target) > 0)
                r = mid - 1;
            else    // nums[mid] <= target
                l = mid;
        }

        return l;
    }

    // ���ֲ��ҷ�, ��һ����������arr��, Ѱ��С��target��Ԫ�ص��������
    // �������, �򷵻���Ӧ������index
    // ����, ���� -1
    public static int lastLessThan(Comparable[] arr, Comparable target){

        if(arr == null)
            throw new IllegalArgumentException("arr can not be null.");

        int l = -1, r = arr.length - 1;
        while(l != r){
            int mid = l + (r - l + 1) / 2;
            if(arr[mid].compareTo(target) >= 0)
                r = mid - 1;
            else    // nums[mid] < target
                l = mid;
        }

        return l;
    }
}
