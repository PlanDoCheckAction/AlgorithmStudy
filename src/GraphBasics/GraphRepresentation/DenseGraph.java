package GraphBasics.GraphRepresentation;

//����ͼ - �ڽӾ���
public class DenseGraph {

 private int n;  // �ڵ���
 private int m;  // ����
 private boolean directed;   // �Ƿ�Ϊ����ͼ
 private boolean[][] g;      // ͼ�ľ�������

 // ���캯��
 public DenseGraph( int n , boolean directed ){
     assert n >= 0;
     this.n = n;
     this.m = 0;    // ��ʼ��û���κα�
     this.directed = directed;
     // g��ʼ��Ϊn*n�Ĳ�������, ÿһ��g[i][j]��Ϊfalse, ��ʾû���κͱ�
     // falseΪboolean�ͱ�����Ĭ��ֵ
     g = new boolean[n][n];
 }

 public int V(){ return n;} // ���ؽڵ����
 public int E(){ return m;} // ���رߵĸ���

 // ��ͼ�����һ����
 public void addEdge( int v , int w ){

     assert v >= 0 && v < n ;
     assert w >= 0 && w < n ;

     if( hasEdge( v , w ) )
         return;

     g[v][w] = true;
     if( !directed )
         g[w][v] = true;

     m ++;
 }

 // ��֤ͼ���Ƿ��д�v��w�ı�
 boolean hasEdge( int v , int w ){
     assert v >= 0 && v < n ;
     assert w >= 0 && w < n ;
     return g[v][w];
 }
}
