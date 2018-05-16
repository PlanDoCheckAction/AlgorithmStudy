package UnionFind.PathCompression;

//���ǵĵڶ���Union-Find
public class UnionFind2 {

 // ���ǵĵڶ���Union-Find, ʹ��һ�����鹹��һ��ָ�򸸽ڵ����
 // parent[i]��ʾ��һ��Ԫ����ָ��ĸ��ڵ�
 private int[] parent;
 private int count;  // ���ݸ���

 // ���캯��
 public UnionFind2(int count){
     parent = new int[count];
     this.count = count;
     // ��ʼ��, ÿһ��parent[i]ָ���Լ�, ��ʾÿһ��Ԫ���Լ��Գ�һ������
     for( int i = 0 ; i < count ; i ++ )
         parent[i] = i;
 }

 // ���ҹ���, ����Ԫ��p����Ӧ�ļ��ϱ��
 // O(h)���Ӷ�, hΪ���ĸ߶�
 private int find(int p){
     assert( p >= 0 && p < count );
     // ����ȥ��ѯ�Լ��ĸ��׽ڵ�, ֱ��������ڵ�
     // ���ڵ���ص�: parent[p] == p
     while( p != parent[p] )
         p = parent[p];
     return p;
 }

 // �鿴Ԫ��p��Ԫ��q�Ƿ�����һ������
 // O(h)���Ӷ�, hΪ���ĸ߶�
 public boolean isConnected( int p , int q ){
     return find(p) == find(q);
 }

 // �ϲ�Ԫ��p��Ԫ��q�����ļ���
 // O(h)���Ӷ�, hΪ���ĸ߶�
 public void unionElements(int p, int q){

     int pRoot = find(p);
     int qRoot = find(q);

     if( pRoot == qRoot )
         return;

     parent[pRoot] = qRoot;
 }
}
