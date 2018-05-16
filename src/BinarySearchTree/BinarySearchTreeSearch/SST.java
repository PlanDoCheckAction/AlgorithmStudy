package BinarySearchTree.BinarySearchTreeSearch;

//˳����ұ�
public class SST<Key extends Comparable<Key>, Value> {

	// ˳����ұ��еĽڵ�Ϊ˽�е���, ��粻��Ҫ�˽�˳����ҷ��ڵ�ľ���ʵ��
	// ���ǵ�˳����ұ�, �ڲ�������һ������
	private class Node {
		private Key key;
		private Value value;
		private Node next;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}

	private Node head; // ��ͷ
	private int count; // ˳����ұ��еĽڵ����

	// ���캯��
	public SST() {
		head = null;
		count = 0;
	}

	// ����˳����ұ��еĽڵ����
	public int size() {
		return count;
	}

	// ����˳����ұ��Ƿ�Ϊ��
	public boolean isEmpty() {
		return count == 0;
	};

	// ��˳����ұ��в���һ���µ�(key, value)���ݶ�
	public void insert(Key key, Value value) {

		// ����һ������˳������Ƿ����ͬ����С��key
		Node node = head;
		while (node != null) {
			// ����˳������ҵ���ͬ����Сkey�Ľڵ�
			// ��ǰ�ڵ㲻��Ҫ���룬����key����Ӧ��ֵ����Ϊvalue�󷵻�
			if (key.compareTo(node.key) == 0) {
				node.value = value;
				return;
			}
			node = node.next;
		}

		// ��˳�����û��ͬ����С��key���򴴽��½ڵ㣬���½ڵ�ֱ�Ӳ��ڱ�ͷ
		Node newNode = new Node(key, value);
		newNode.next = head;
		head = newNode;
		count++;
	}

	// �鿴˳����ұ����Ƿ������ֵΪkey�Ľڵ�
	public boolean contain(Key key) {

		Node node = head;
		while (node != null) {
			if (key.compareTo(node.key) == 0)
				return true;
			node = node.next;
		}
		return false;
	}

	// ��˳����ұ��в���key����Ӧ��value, ��value������, �򷵻�NULL
	public Value search(Key key) {

		Node node = head;
		while (node != null) {
			if (key.compareTo(node.key) == 0)
				return node.value;
			node = node.next;
		}
		return null;
	}

	// ��˳����ұ���ɾ��(key,value)����Ӧ�Ľڵ�
	public void remove(Key key) {

		if (head == null)
			return;

		// �����ɾ���Ľڵ����ͷ���, ����Ҫ���⴦��
		// ˼��: ��������, ����ʹ��ʲô������ȥ���⴦��ͷ�����������?
		// �����������ص��㷨����, ��ӭ��ҿ��ҵġ����ת�㷨���ԡ��γ� :)
		if (key.compareTo(head.key) == 0) {
			Node delNode = head;
			head = head.next;
			delNode.next = null;
			count--;
			return;
		}

		Node node = head;
		while (node.next != null && node.next.key.compareTo(key) != 0)
			node = node.next;

		if (node.next != null) {
			Node delNode = node.next;
			node.next = delNode.next;
			delNode.next = null;
			count--;
			return;
		}
	}
}
