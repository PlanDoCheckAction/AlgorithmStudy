package BinarySearchTree.BinarySearchTreeInsert;

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

	// ������������в���һ���µ�(key, value)���ݶ�
    public void insert(Key key, Value value){
        root = insert(root, key, value);
    }


    //********************
    //* �����������ĸ�������
    //********************

    // ����nodeΪ���Ķ�����������, ����ڵ�(key, value), ʹ�õݹ��㷨
    // ���ز����½ڵ��Ķ����������ĸ�
    private Node insert(Node node, Key key, Value value){

        if( node == null ){
            count ++;
            return new Node(key, value);
        }

        if( key.compareTo(node.key) == 0 )
            node.value = value;
        else if( key.compareTo(node.key) < 0 )
            node.left = insert( node.left , key, value);
        else    // key > node->key
            node.right = insert( node.right, key, value);

        return node;
    }
	
	public static void main(String[] args) {
	}
}
