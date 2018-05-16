package UnionFind.PathCompressionComparison;

//���ǵĵ����Union-Find, ·��ѹ��ʹ�õ���ʵ��
public class UnionFind5 implements UF {

 // rank[i]��ʾ��iΪ���ļ�������ʾ�����Ĳ���
 // �ں����Ĵ�����, ���ǲ�����ά��rank������, Ҳ����rank��ֵ��·��ѹ���Ĺ�����, �п��ܲ��������Ĳ���ֵ
 // ��Ҳ�����ǵ�rank����height����depth��ԭ��, ��ֻ����Ϊ�Ƚϵ�һ����׼
 private int[] rank;
 public int[] parent; // parent[i]��ʾ��i��Ԫ����ָ��ĸ��ڵ�
                      // ����, ����Ҫ���ⲿ�ٿز��鼯������, ������ʹ��public
 private int count;   // ���ݸ���

 // ���캯��
 public UnionFind5(int count){
     rank = new int[count];
     parent = new int[count];
     this.count = count;
     // ��ʼ��, ÿһ��parent[i]ָ���Լ�, ��ʾÿһ��Ԫ���Լ��Գ�һ������
     for( int i = 0 ; i < count ; i ++ ){
         parent[i] = i;
         rank[i] = 1;
     }
 }

 // ���ҹ���, ����Ԫ��p����Ӧ�ļ��ϱ��
 // O(h)���Ӷ�, hΪ���ĸ߶�
 public int find(int p){
     assert( p >= 0 && p < count );

     // path compression 1
     while( p != parent[p] ){
         parent[p] = parent[parent[p]];
         p = parent[p];
     }
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

     // ��������Ԫ����������Ԫ�ظ�����ͬ�жϺϲ�����
     // ��Ԫ�ظ����ٵļ��Ϻϲ���Ԫ�ظ�����ļ�����
     if( rank[pRoot] < rank[qRoot] ){
         parent[pRoot] = qRoot;
     }
     else if( rank[qRoot] < rank[pRoot]){
         parent[qRoot] = pRoot;
     }
     else{ // rank[pRoot] == rank[qRoot]
         parent[pRoot] = qRoot;
         rank[qRoot] += 1;   // ��ʱ, ��ά��rank��ֵ
     }
 }

 // ��ӡ������鼯�е�parent����
 public void show(){
     for( int i = 0 ; i < count ; i ++ )
         System.out.print( parent[i] + " ");
     System.out.println();
 }
}