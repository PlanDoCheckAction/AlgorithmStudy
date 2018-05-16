package BinarySearchTree.BinarySearchTreeTraverse;

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

 private Node root;  // ���ڵ�
 private int count;  // ���ֵĽڵ����

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

 // �鿴�������������Ƿ���ڼ�key
 public boolean contain(Key key){
     return contain(root, key);
 }

 // �ڶ�����������������key����Ӧ��ֵ��������ֵ������, �򷵻�null
 public Value search(Key key){
     return search( root , key );
 }

 // ������������ǰ�����
 public void preOrder(){
     preOrder(root);
 }

 // �������������������
 public void inOrder(){
     inOrder(root);
 }

 // �����������ĺ������
 public void postOrder(){
     postOrder(root);
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

 // �鿴��nodeΪ���Ķ������������Ƿ������ֵΪkey�Ľڵ�, ʹ�õݹ��㷨
 private boolean contain(Node node, Key key){

     if( node == null )
         return false;

     if( key.compareTo(node.key) == 0 )
         return true;
     else if( key.compareTo(node.key) < 0 )
         return contain( node.left , key );
     else // key > node->key
         return contain( node.right , key );
 }

 // ����nodeΪ���Ķ����������в���key����Ӧ��value, �ݹ��㷨
 // ��value������, �򷵻�NULL
 private Value search(Node node, Key key){

     if( node == null )
         return null;

     if( key.compareTo(node.key) == 0 )
         return node.value;
     else if( key.compareTo(node.key) < 0 )
         return search( node.left , key );
     else // key > node->key
         return search( node.right, key );
 }

 // ����nodeΪ���Ķ�������������ǰ�����, �ݹ��㷨
 private void preOrder(Node node){

     if( node != null ){
         System.out.println(node.key);
         preOrder(node.left);
         preOrder(node.right);
     }
 }

 // ����nodeΪ���Ķ��������������������, �ݹ��㷨
 private void inOrder(Node node){

     if( node != null ){
         inOrder(node.left);
         System.out.println(node.key);
         inOrder(node.right);
     }
 }

 // ����nodeΪ���Ķ������������к������, �ݹ��㷨
 private void postOrder(Node node){

     if( node != null ){
         postOrder(node.left);
         postOrder(node.right);
         System.out.println(node.key);
     }
 }

 // ���Զ���������
 public static void main(String[] args) {

     int N = 1000000;

     // ����һ�����飬����[0...N)������Ԫ��
     Integer[] arr = new Integer[N];
     for(int i = 0 ; i < N ; i ++)
         arr[i] = new Integer(i);

     // ��������˳��
     for(int i = 0 ; i < N ; i ++){
         int pos = (int) (Math.random() * (i+1));
         Integer t = arr[pos];
         arr[pos] = arr[i];
         arr[i] = arr[pos];
     }
     // ��������ʵ�ֵĶ�������������ƽ���������
     // �����������˳�����һ�����ݣ����ǵĶ������������˻���Ϊһ������

     // ���ǲ����õĵĶ����������ļ�����ΪInteger��ֵ����ΪString
     // ��ֵ�Ķ�Ӧ��ϵΪÿ�����Ͷ�Ӧ����������͵��ַ���
     BST<Integer,String> bst = new BST<Integer,String>();
     for(int i = 0 ; i < N ; i ++)
         bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

     // ��[0...2*N)���������Ͳ����ڶ����������в���
     // ��i��[0...N)֮�䣬���ܲ��ҵ���������Ӧ���ַ���
     // ��i��[N...2*N)֮�䣬����Ϊnull
     for(int i = 0 ; i < 2*N ; i ++){
         String res = bst.search(new Integer(i));
         if( i < N )
             assert res.equals(Integer.toString(i));
         else
             assert res == null;
     }
 }
}