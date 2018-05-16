package BinarySearchTree.PredecessorAndSuccessorInBST;

import java.util.LinkedList;

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

     public Node(Node node){
         this.key = node.key;
         this.value = node.value;
         this.left = node.left;
         this.right = node.right;
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
     Node node = search( root , key );
     return node == null ? null : node.value;
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

 // �����������Ĳ������
 public void levelOrder(){

     // ����ʹ��LinkedList����Ϊ���ǵĶ���
     LinkedList<Node> q = new LinkedList<Node>();
     q.add(root);
     while( !q.isEmpty() ){

         Node node = q.remove();

         System.out.println(node.key);

         if( node.left != null )
             q.add( node.left );
         if( node.right != null )
             q.add( node.right );
     }
 }

 // Ѱ�Ҷ�������������С�ļ�ֵ
 public Key minimum(){
     assert count != 0;
     Node minNode = minimum( root );
     return minNode.key;
 }

 // Ѱ�Ҷ��������������ļ�ֵ
 public Key maximum(){
     assert count != 0;
     Node maxNode = maximum(root);
     return maxNode.key;
 }

 // �Ӷ�����������ɾ����Сֵ���ڽڵ�
 public void removeMin(){
     if( root != null )
         root = removeMin( root );
 }

 // �Ӷ�����������ɾ�����ֵ���ڽڵ�
 public void removeMax(){
     if( root != null )
         root = removeMax( root );
 }

 // �Ӷ�����������ɾ����ֵΪkey�Ľڵ�
 public void remove(Key key){
     root = remove(root, key);
 }

 // Ѱ��key��floorֵ, �ݹ��㷨
 // ���������key��floorֵ(key��BST�е���Сֵ��С), ����NULL
 public Key floor(Key key){

     if( count == 0 || key.compareTo(minimum()) < 0 )
         return null;

     Node floorNode = floor(root, key);
     return floorNode.key;
 }

 // Ѱ��key��ceilֵ, �ݹ��㷨
 // ���������key��ceilֵ(key��BST�е����ֵ����), ����NULL
 public Key ceil(Key key){

     if( count == 0 || key.compareTo(maximum()) > 0 )
         return null;

     Node ceilNode = ceil(root, key);
     return ceilNode.key;
 }

 // ����key��ǰ��
 // ���������key��ǰ��(key������, ����key�����ö������е���Сֵ), �򷵻�NULL
 public Key predecessor(Key key){

     Node node = search(root, key);
     // ���key���ڵĽڵ㲻����, ��keyû��ǰ��, ����NULL
     if(node == null)
         return null;

     // ���key���ڵĽڵ���������Ϊ��,���������������ֵΪkey��ǰ��
     if(node.left != null)
         return maximum(node.left).key;

     // ����, key��ǰ���ڴӸ��ڵ㵽key��·����, �����·����Ѱ�ҵ���keyС�����ֵ, ��Ϊkey��ǰ��
     Node preNode = predecessorFromAncestor(root, key);
     return preNode == null ? null : preNode.key;
 }

 // ����key�ĺ��, �ݹ��㷨
 // ���������key�ĺ��(key������, ����key�����ö������е����ֵ), �򷵻�NULL
 public Key successor(Key key){

     Node node = search(root, key);
     // ���key���ڵĽڵ㲻����, ��keyû��ǰ��, ����NULL
     if(node == null)
         return null;

     // ���key���ڵĽڵ���������Ϊ��,��������������СֵΪkey�ĺ��
     if(node.right != null)
         return minimum(node.right).key;

     // ����, key�ĺ���ڴӸ��ڵ㵽key��·����, �����·����Ѱ�ҵ���key�����Сֵ, ��Ϊkey�ĺ��
     Node sucNode = successorFromAncestor(root, key);
     return sucNode == null ? null : sucNode.key;
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
 private Node search(Node node, Key key){

     if( node == null )
         return null;

     if( key.compareTo(node.key) == 0 )
         return node;
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

 // ������nodeΪ���Ķ�������������С��ֵ���ڵĽڵ�
 private Node minimum(Node node){
     if( node.left == null )
         return node;

     return minimum(node.left);
 }

 // ������nodeΪ���Ķ���������������ֵ���ڵĽڵ�
 private Node maximum(Node node){
     if( node.right == null )
         return node;

     return maximum(node.right);
 }

 // ɾ������nodeΪ���Ķ����������е���С�ڵ�
 // ����ɾ���ڵ���µĶ����������ĸ�
 private Node removeMin(Node node){

     if( node.left == null ){

         Node rightNode = node.right;
         node.right = null;
         count --;
         return rightNode;
     }

     node.left = removeMin(node.left);
     return node;
 }

 // ɾ������nodeΪ���Ķ����������е����ڵ�
 // ����ɾ���ڵ���µĶ����������ĸ�
 private Node removeMax(Node node){

     if( node.right == null ){

         Node leftNode = node.left;
         node.left = null;
         count --;
         return leftNode;
     }

     node.right = removeMax(node.right);
     return node;
 }

 // ɾ������nodeΪ���Ķ����������м�ֵΪkey�Ľڵ�, �ݹ��㷨
 // ����ɾ���ڵ���µĶ����������ĸ�
 private Node remove(Node node, Key key){

     if( node == null )
         return null;

     if( key.compareTo(node.key) < 0 ){
         node.left = remove( node.left , key );
         return node;
     }
     else if( key.compareTo(node.key) > 0 ){
         node.right = remove( node.right, key );
         return node;
     }
     else{   // key == node->key

         // ��ɾ���ڵ�������Ϊ�յ����
         if( node.left == null ){
             Node rightNode = node.right;
             node.right = null;
             count --;
             return rightNode;
         }

         // ��ɾ���ڵ�������Ϊ�յ����
         if( node.right == null ){
             Node leftNode = node.left;
             node.left = null;
             count--;
             return leftNode;
         }

         // ��ɾ���ڵ�������������Ϊ�յ����

         // �ҵ��ȴ�ɾ���ڵ�����С�ڵ�, ����ɾ���ڵ�����������С�ڵ�
         // ������ڵ㶥���ɾ���ڵ��λ��
         Node successor = new Node(minimum(node.right));
         count ++;

         successor.right = removeMin(node.right);
         successor.left = node.left;

         node.left = node.right = null;
         count --;

         return successor;
     }
 }

 // ����nodeΪ���Ķ�����������, Ѱ��key��floorֵ�����Ľڵ�, �ݹ��㷨
 private Node floor(Node node, Key key){

     if( node == null )
         return null;

     // ���node��keyֵ��ҪѰ�ҵ�keyֵ���
     // ��node�������key��floor�ڵ�
     if( node.key.compareTo(key) == 0 )
         return node;

     // ���node��keyֵ��ҪѰ�ҵ�keyֵ��
     // ��ҪѰ�ҵ�key��floor�ڵ�һ����node����������
     if( node.key.compareTo(key) > 0 )
         return floor( node.left , key );

     // ���node->key < key
     // ��node�п�����key��floor�ڵ�, Ҳ�п��ܲ���(���ڱ�node->key����С��key������ڵ�)
     // ��Ҫ������node��������Ѱ��һ��
     Node tempNode = floor( node.right , key );
     if( tempNode != null )
         return tempNode;

     return node;
 }

 // ����nodeΪ���Ķ�����������, Ѱ��key��ceilֵ�����Ľڵ�, �ݹ��㷨
 private Node ceil(Node node, Key key){

     if( node == null )
         return null;

     // ���node��keyֵ��ҪѰ�ҵ�keyֵ���
     // ��node�������key��ceil�ڵ�
     if( node.key.compareTo(key) == 0 )
         return node;

     // ���node��keyֵ��ҪѰ�ҵ�keyֵС
     // ��ҪѰ�ҵ�key��ceil�ڵ�һ����node����������
     if( node.key.compareTo(key) < 0 )
         return ceil( node.right , key );

     // ���node->key > key
     // ��node�п�����key��ceil�ڵ�, Ҳ�п��ܲ���(���ڱ�node->keyС���Ǵ���key������ڵ�)
     // ��Ҫ������node��������Ѱ��һ��
     Node tempNode = ceil( node.left , key );
     if( tempNode != null )
         return tempNode;

     return node;
 }

 // ����nodeΪ���Ķ�����������, Ѱ��key��������,��keyС�����ֵ���ڽڵ�, �ݹ��㷨
 // �㷨����ǰ�ѱ�֤key��������nodeΪ���Ķ�������
 Node predecessorFromAncestor(Node node, Key key){

     if(node.key.compareTo(key) == 0)
         return null;

     if(key.compareTo(node.key) < 0)
         // �����ǰ�ڵ����key, ��ǰ�ڵ㲻�����Ǳ�keyС�����ֵ
         // �����������Ľ��ֱ�ӷ���
         return predecessorFromAncestor(node.left, key);
     else{
         assert key.compareTo(node.key) > 0;
         // �����ǰ�ڵ�С��key, ��ǰ�ڵ��п����Ǳ�keyС�����ֵ
         // ���Ҽ�������, ������洢��tempNode��
         Node tempNode = predecessorFromAncestor(node.right, key);
         if(tempNode != null)
             return tempNode;
         else
             // ���tempNodeΪ��, ��ǰ�ڵ㼴Ϊ���
             return node;
     }
 }

 // ����nodeΪ���Ķ�����������, Ѱ��key��������,��key�����Сֵ���ڽڵ�, �ݹ��㷨
 // �㷨����ǰ�ѱ�֤key��������nodeΪ���Ķ�������
 Node successorFromAncestor(Node node, Key key){

     if(node.key.compareTo(key) == 0)
         return null;

     if(key.compareTo(node.key) > 0)
         // �����ǰ�ڵ�С��key, ��ǰ�ڵ㲻�����Ǳ�key�����Сֵ
         // �����������Ľ��ֱ�ӷ���
         return successorFromAncestor(node.right, key);
     else{
         assert(key.compareTo(node.key) < 0);
         // �����ǰ�ڵ����key, ��ǰ�ڵ��п����Ǳ�key�����Сֵ
         // �����������, ������洢��tempNode��
         Node tempNode = predecessorFromAncestor(node.left, key);
         if(tempNode != null)
             return tempNode;
         else
             // ���tempNodeΪ��, ��ǰ�ڵ㼴Ϊ���
             return node;
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