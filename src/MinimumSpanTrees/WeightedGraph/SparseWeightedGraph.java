package MinimumSpanTrees.WeightedGraph;

import java.util.Vector;

//ϡ��ͼ - �ڽӱ�
public class SparseWeightedGraph<Weight extends Number & Comparable>
     implements WeightedGraph {

 private int n;  // �ڵ���
 private int m;  // ����
 private boolean directed;   // �Ƿ�Ϊ����ͼ
 private Vector<Edge<Weight>>[] g;   // ͼ�ľ�������

 // ���캯��
 public SparseWeightedGraph( int n , boolean directed ){
     assert n >= 0;
     this.n = n;
     this.m = 0;    // ��ʼ��û���κα�
     this.directed = directed;
     // g��ʼ��Ϊn���յ�vector, ��ʾÿһ��g[i]��Ϊ��, ��û���κͱ�
     g = (Vector<Edge<Weight>>[])new Vector[n];
     for(int i = 0 ; i < n ; i ++)
         g[i] = new Vector<Edge<Weight>>();
 }

 public int V(){ return n;} // ���ؽڵ����
 public int E(){ return m;} // ���رߵĸ���

 // ��ͼ�����һ����, ȨֵΪweight
 public void addEdge(Edge e){

     assert e.v() >= 0 && e.v() < n ;
     assert e.w() >= 0 && e.w() < n ;

     // ע��, �������ڽӱ�����, �����Ƿ����ر���Ҫ������������
     // ���ǵĳ��������رߵĳ���

     g[e.v()].add(new Edge(e));
     if( e.v() != e.w() && !directed )
         g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));

     m ++;
 }

 // ��֤ͼ���Ƿ��д�v��w�ı�
 public boolean hasEdge( int v , int w ){

     assert v >= 0 && v < n ;
     assert w >= 0 && w < n ;

     for( int i = 0 ; i < g[v].size() ; i ++ )
         if( g[v].elementAt(i).other(v) == w )
             return true;
     return false;
 }

 // ��ʾͼ����Ϣ
 public void show(){

     for( int i = 0 ; i < n ; i ++ ){
         System.out.print("vertex " + i + ":\t");
         for( int j = 0 ; j < g[i].size() ; j ++ ){
             Edge e = g[i].elementAt(j);
             System.out.print( "( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
         }
         System.out.println();
     }
 }

 // ����ͼ��һ������������ڱ�
 // ����javaʹ�����û��ƣ�����һ��Vector����������⿪��,
 public Iterable<Edge<Weight>> adj(int v) {
     assert v >= 0 && v < n;
     return g[v];
 }
}