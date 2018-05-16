package BinarySearchTree.FloorAndCeilInBinarySearch;

//�ǵݹ�Ķ��ֲ����㷨
public class BinarySearch {

	// ���ǵ��㷨�಻��������κ�ʵ��
	private BinarySearch() {
	}

	// ���ֲ��ҷ�,����������arr��,����target
	// ����ҵ�target,������Ӧ������index
	// ���û���ҵ�target,����-1
	public static int find(Comparable[] arr, Comparable target) {

		// ��arr[l...r]֮�в���target
		int l = 0, r = arr.length - 1;
		while (l <= r) {

			// int mid = (l + r)/2;
			// ��ֹ��������µ����������ʹ��������߼����mid
			int mid = l + (r - l) / 2;

			if (arr[mid].compareTo(target) == 0)
				return mid;

			if (arr[mid].compareTo(target) > 0)
				r = mid - 1;
			else
				l = mid + 1;
		}

		return -1;
	}

	// ���ֲ��ҷ�, ����������arr��, ����target
	// ����ҵ�target, ���ص�һ��target��Ӧ������index
	// ���û���ҵ�target, ���ر�targetС�����ֵ��Ӧ������, ���������ֵ�ж��, �����������
	// ������target�������������СԪ��ֵ��ҪС, �򲻴������target��floorֵ, ����-1
	static int floor(Comparable[] arr, Comparable target) {

		// Ѱ�ұ�targetС���������
		int l = -1, r = arr.length - 1;
		while (l < r) {
			// ʹ������ȡ��������ѭ��
			int mid = l + (r - l + 1) / 2;
			if (arr[mid].compareTo(target) >= 0)
				r = mid - 1;
			else
				l = mid;
		}

		assert l == r;

		// ���������+1����target����, ������+1��Ϊ����ֵ
		if (l + 1 < arr.length && arr[l + 1] == target)
			return l + 1;

		// ����, ��������Ϊ����ֵ
		return l;
	}

	// ���ֲ��ҷ�, ����������arr��, ����target
	// ����ҵ�target, �������һ��target��Ӧ������index
	// ���û���ҵ�target, ���ر�target�����Сֵ��Ӧ������, ��������Сֵ�ж��, ������С������
	// ������target��������������Ԫ��ֵ��Ҫ��, �򲻴������target��ceilֵ, ������������Ԫ�ظ���n
	static int ceil(Comparable[] arr, Comparable target) {

		// Ѱ�ұ�target�����С����ֵ
		int l = 0, r = arr.length;
		while (l < r) {
			// ʹ����ͨ������ȡ�����ɱ�����ѭ��
			int mid = l + (r - l) / 2;
			if (arr[mid].compareTo(target) <= 0)
				l = mid + 1;
			else // arr[mid] > target
				r = mid;
		}

		assert l == r;

		// ���������-1����target����, ������+1��Ϊ����ֵ
		if (r - 1 >= 0 && arr[r - 1] == target)
			return r - 1;

		// ����, ��������Ϊ����ֵ
		return r;
	}

	// ���������ö��ֲ��ҷ�ʵ�ֵ�floor��ceil��������
	// ����ϸ�۲������ǵĲ��������У������ɵ��ظ�Ԫ�أ�������Щ�ظ�Ԫ�أ�floor��ceil�����������𣺣�
	public static void main(String[] args) {

		Integer arr[] = new Integer[] { 1, 1, 1, 2, 2, 2, 2, 2, 4, 4, 5, 5, 5, 6, 6, 6 };
		for (int i = 0; i <= 8; i++) {

			int floorIndex = floor(arr, i);
			System.out.println("the floor index of " + i + " is " + floorIndex + ".");
			if (floorIndex >= 0 && floorIndex < arr.length)
				System.out.println("The value is " + arr[floorIndex] + ".");
			System.out.println();

			int ceilIndex = ceil(arr, i);
			System.out.println("the ceil index of " + i + " is " + ceilIndex + ".");
			if (ceilIndex >= 0 && ceilIndex < arr.length)
				System.out.println("The value is " + arr[ceilIndex] + ".");
			System.out.println();

			System.out.println();
		}

	}
}
