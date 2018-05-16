package GraphBasics.FindingAPath;

import java.util.Vector;

//ϡ��ͼ - �ڽӱ�
public class SparseGraph implements Graph {

 private int n;  // �ڵ���
 private int m;  // ����
 private boolean directed;   // �Ƿ�Ϊ����ͼ
 private Vector<Integer>[] g; // ͼ�ľ�������

 // ���캯��
 public SparseGraph( int n , boolean directed ){
     assert n >= 0;
     this.n = n;
     this.m = 0;    // ��ʼ��û���κα�
     this.directed = directed;
     // g��ʼ��Ϊn���յ�vector, ��ʾÿһ��g[i]��Ϊ��, ��û���κͱ�
     g = (Vector<Integer>[])new Vector[n];
     for(int i = 0 ; i < n ; i ++)
         g[i] = new Vector<Integer>();
 }

 public int V(){ return n;} // ���ؽڵ����
 public int E(){ return m;} // ���رߵĸ���

 // ��ͼ�����һ����
 public void addEdge( int v, int w ){

     assert v >= 0 && v < n ;
     assert w >= 0 && w < n ;

     g[v].add(w);
     if( v != w && !directed )
         g[w].add(v);

     m ++;
 }

 // ��֤ͼ���Ƿ��д�v��w�ı�
 public boolean hasEdge( int v , int w ){

     assert v >= 0 && v < n ;
     assert w >= 0 && w < n ;

     for( int i = 0 ; i < g[v].size() ; i ++ )
         if( g[v].elementAt(i) == w )
             return true;
     return false;
 }

 // ��ʾͼ����Ϣ
 public void show(){

     for( int i = 0 ; i < n ; i ++ ){
         System.out.print("vertex " + i + ":\t");
         for( int j = 0 ; j < g[i].size() ; j ++ )
             System.out.print(g[i].elementAt(j) + "\t");
         System.out.println();
     }
 }

 // ����ͼ��һ������������ڱ�
 // ����javaʹ�����û��ƣ�����һ��Vector����������⿪��,
 public Iterable<Integer> adj(int v) {
     assert v >= 0 && v < n;
     return g[v];
 }
}