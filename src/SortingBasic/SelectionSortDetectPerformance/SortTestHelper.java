package SortingBasic.SelectionSortDetectPerformance;

import java.lang.reflect.Method;

public class SortTestHelper {

	//SortTestHelper����������κ�ʵ��
	private SortTestHelper() {};
	
	//������n��Ԫ�ص�������飬ÿ��Ԫ�ص������ΧΪ[rangeL, rangeR]
	public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
		
		//assert [boolean���ʽ] //����
		//���[boolean���ʽ]Ϊtrue����������ִ�С����Ϊfalse��������׳�AssertionError������ִֹ�С�
		assert rangeL <= rangeR;
		
		Integer[] arr = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));//�������[rangeL, rangeR]�ڵ�Ԫ��
		}
		
		return arr;
	}
	
	//��ӡarr�������������
	public static void printArray(Object arr[]) {
		
		for (Object obj : arr) {
			System.out.print(obj+" ");
		}
		System.out.println();
		
		return;
	}
	
	//�ж�arr�����Ƿ�����
	public static boolean isSorted( Comparable[] arr) {
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i+1]) > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	//����sortClassName����Ӧ�������㷨����arr�������õ��Ľ������ȷ�Ժ��㷨����ʱ��
	public static void testSort(String sortClassName, Comparable[] arr) {
		
		//ͨ��Java�ķ�����ƣ�ͨ�����������������������
		try {
			// ͨ��sortClassName�����������Class����
			Class sortClass = Class.forName(sortClassName);
			// ͨ����������Class��������Ϊ sort �����򷽷�
			Method sortMethod = sortClass.getMethod("sort", new Class[] {Comparable[].class});
			// �������ֻ��һ�����ǿɱȽ�����arr
			Object[] params = new Object[] {arr};
			
			long startTime = System.currentTimeMillis();
			//����������
			sortMethod.invoke(null, params);
			long endTime = System.currentTimeMillis();
			
			assert isSorted( arr );
			
			System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
