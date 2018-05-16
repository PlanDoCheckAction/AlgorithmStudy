package SortingBasic.SelectionSortUsingComparable;

public class SelectionSort {

	//�㷨�಻��������κ�ʵ��
	private SelectionSort() {}
	
	public static void sort(Comparable[] arr) {
		
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			//Ѱ��[i,n)���������Сֵ��������ֵ��minIndex
			int minIndex = i;
			for (int j = i+1; j < n; j++) {
				//ʹ��compareTo�����Ƚ�����Comparable����Ĵ�С
				if( arr[j].compareTo(arr[minIndex]) < 0)
					minIndex = j;
			}
			swap( arr, i, minIndex );//������������Ӧ��ֵ
		}
	}
	
	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main(String[] args) {
		//����Integer
		Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
		SelectionSort.sort(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//����Double
		Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSort.sort(b);
        for (double i : b) {
			System.out.print(i+" ");
		}
        System.out.println();
        
        //����String
        String[] c = {"D", "C", "B", "A"};
        SelectionSort.sort(c);
        for (String i : c) {
			System.out.print(i+" ");
		}
        System.out.println();

        // �����Զ������ Student
        Student[] d = new Student[4];
        d[0] = new Student("D",90);
        d[1] = new Student("C",100);
        d[2] = new Student("B",95);
        d[3] = new Student("A",95);
        SelectionSort.sort(d);
        for (Student i : d) {
			System.out.println(i);
		}
        
	}

}
