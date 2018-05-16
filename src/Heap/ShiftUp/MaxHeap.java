package Heap.ShiftUp;

//�ڶѵ��йز����У���Ҫ�Ƚ϶���Ԫ�صĴ�С������T��Ҫextends Comparable
public class MaxHeap<T extends Comparable>{
	protected T[] data;
	protected int count;
	protected int capacity;
	
	// ���캯��,����һ���ն�,������capacity��Ԫ��
	public MaxHeap(int capacity) {
		data = (T[])new Comparable[capacity+1];
		count = 0;
		this.capacity = capacity;
	}
	
	// ���ض��е�Ԫ�ظ���
	public int size() {
		return count;
	}
	
	// ����һ������ֵ,��ʾ�����Ƿ�Ϊ��
	public boolean isEmpty() {
		return count == 0;
	}
	
	// �������в���һ���µ�Ԫ��  item
	public void insert(T item) {
		
		assert count + 1 <= capacity;
		data[count+1] = item;
		count++;
		shiftUp(count);
	}
	
	// ������������Ϊi��j������Ԫ��
    private void swap(int i, int j){
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
	
    //* ���Ѻ��ĸ�������
	private void shiftUp(int k) {
		
		while (k > 1 && data[k/2].compareTo(data[k]) < 0) {
			swap(k, k/2);
            k /= 2;
		}
	}

	// ����MaxHeap
	public static void main(String[] args) {
		
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
		int N = 50;// ����Ԫ�صĸ���
		int M = 100;// ����Ԫ��ȡֵ��Χ[0, M)
		for (int i = 0; i < N; i++) {
			maxHeap.insert( new Integer((int)(Math.random() * M)) );
		}
		System.out.println(maxHeap.size());
	}
}
