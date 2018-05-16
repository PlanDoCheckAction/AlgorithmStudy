package SortingBasic.SelectionSortGenerateTestCases;

public class SortTestHelper {

	// SortTestHelper����������κ�ʵ��
	private SortTestHelper() {}
	
	// ������n��Ԫ�ص��������,ÿ��Ԫ�ص������ΧΪ[rangeL, rangeR]
	public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
		
		//assert��ʾ���ԣ����rangeL<=rangeR�����������������У���������׳��쳣
		assert rangeL <= rangeR;
	
		Integer[] arr = new Integer[n];
		//Math.random() * (rangeR - rangeL + 1)��ʾƫ����
		for (int i = 0; i < n; i++) 
			arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
		return arr;
	}
	
	//��ӡarr�������������
	public static void printArray(Object arr[]) {
		for (Object o : arr) {
			System.out.print(o + " ");
		}
		System.out.println();
		
		return;
	}
}
