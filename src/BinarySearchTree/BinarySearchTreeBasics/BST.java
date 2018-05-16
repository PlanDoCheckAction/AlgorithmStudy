package BinarySearchTree.BinarySearchTreeBasics;

//����������
//����Key��Ҫ�ܹ����бȽϣ�������Ҫextends Comparable<Key>
public class BST<Key extends Comparable<Key>, Value> {

	// ���еĽڵ�Ϊ˽�е���, ��粻��Ҫ�˽�����������ڵ�ľ���ʵ��
	private class Node {
		private Key key;
		private Value value;
		private Node left, right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			left = right = null;
		}
	}

	private Node root; // ���ڵ�
	private int count; // ���ֵĽڵ����

	// ���캯��, Ĭ�Ϲ���һ�ÿն���������
	public BST() {
		root = null;
		count = 0;
	}

	// ���ض����������Ľڵ����
	public int size() {
		return count;
	}

	// ���ض����������Ƿ�Ϊ��
	public boolean isEmpty() {
		return count == 0;
	}

	public static void main(String[] args) {
	}
}
