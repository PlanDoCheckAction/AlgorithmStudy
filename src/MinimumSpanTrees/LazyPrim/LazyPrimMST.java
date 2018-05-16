package MinimumSpanTrees.LazyPrim;

import java.util.Vector;

//ʹ��Prim�㷨��ͼ����С������
public class LazyPrimMST<Weight extends Number & Comparable> {

 private WeightedGraph<Weight> G;    // ͼ������
 private MinHeap<Edge<Weight>> pq;   // ��С��, �㷨�������ݽṹ
 private boolean[] marked;           // �������, ���㷨���й����б�ǽڵ�i�Ƿ񱻷���
 private Vector<Edge<Weight>> mst;   // ��С�����������������б�
 private Number mstWeight;           // ��С��������Ȩֵ

 // ���캯��, ʹ��Prim�㷨��ͼ����С������
 public LazyPrimMST(WeightedGraph<Weight> graph){

     // �㷨��ʼ��
     G = graph;
     pq = new MinHeap<Edge<Weight>>(G.E());
     marked = new boolean[G.V()];
     mst = new Vector<Edge<Weight>>();

     // Lazy Prim
     visit(0);
     while( !pq.isEmpty() ){
         // ʹ����С���ҳ��Ѿ����ʵı���Ȩֵ��С�ı�
         Edge<Weight> e = pq.extractMin();
         // ��������ߵ����˶��Ѿ����ʹ���, ���ӵ�������
         if( marked[e.v()] == marked[e.w()] )
             continue;
         // ����, ��������Ӧ�ô�������С��������
         mst.add( e );

         // ���ʺ����������ӵĻ�û�б����ʹ��Ľڵ�
         if( !marked[e.v()] )
             visit( e.v() );
         else
             visit( e.w() );
     }

     // ������С��������Ȩֵ

     mstWeight = mst.elementAt(0).wt();
     for( int i = 1 ; i < mst.size() ; i ++ )
         mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
 }

 // ���ʽڵ�v
 private void visit(int v){

     assert !marked[v];
     marked[v] = true;

     // ���ͽڵ�v�����ӵ�����δ���ʵı߷�����С����
     for( Edge<Weight> e : G.adj(v) )
         if( !marked[e.other(v)] )
             pq.insert(e);
 }

 // ������С�����������б�
 Vector<Edge<Weight>> mstEdges(){
     return mst;
 };

 // ������С��������Ȩֵ
 Number result(){
     return mstWeight;
 };
}
