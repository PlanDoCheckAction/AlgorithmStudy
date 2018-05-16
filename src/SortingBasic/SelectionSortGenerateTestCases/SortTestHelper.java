package SortingBasic.SelectionSortGenerateTestCases;

public class SortTestHelper {

	// SortTestHelper不允许产生任何实例
	private SortTestHelper() {}
	
	// 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
	public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
		
		//assert表示断言，如果rangeL<=rangeR成立，则程序继续运行，否则程序抛出异常
		assert rangeL <= rangeR;
	
		Integer[] arr = new Integer[n];
		//Math.random() * (rangeR - rangeL + 1)表示偏移量
		for (int i = 0; i < n; i++) 
			arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
		return arr;
	}
	
	//打印arr数组的所有内容
	public static void printArray(Object arr[]) {
		for (Object o : arr) {
			System.out.print(o + " ");
		}
		System.out.println();
		
		return;
	}
}
