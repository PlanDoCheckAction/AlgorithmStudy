package Heap.MaxHeapClassBasic;

public class MaxHeap<T> {
	private T[] data;
	private int count;
	
	// ���캯��,����һ���ն�,������capacity��Ԫ��
	public MaxHeap(int capacity) {
		data = (T[])new Object[capacity+1];
		count = 0;
	}
	
	// ���ض��е�Ԫ�ظ���
	public int size() {
		return count;
	}
	
	// ����һ������ֵ,��ʾ�����Ƿ�Ϊ��
	public boolean isEmpty() {
		return count == 0;
	}
	
	// ����MaxHeap
	public static void main(String[] args) {
		
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
		System.out.println(maxHeap.size());
	}
}
