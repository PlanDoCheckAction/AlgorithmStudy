package MinimumSpanTrees.KruskalAlgorithm;

import java.util.Vector;

//Kruskal�㷨����С������
public class KruskalMST<Weight extends Number & Comparable> {

 private Vector<Edge<Weight>> mst;   // ��С�����������������б�
 private Number mstWeight;           // ��С��������Ȩֵ

 // ���캯��, ʹ��Kruskal�㷨����graph����С������
 public KruskalMST(WeightedGraph graph){

     mst = new Vector<Edge<Weight>>();

     // ��ͼ�е����бߴ�ŵ�һ����С����
     MinHeap<Edge<Weight>> pq = new MinHeap<Edge<Weight>>( graph.E() );
     for( int i = 0 ; i < graph.V() ; i ++ )
         for( Object item : graph.adj(i) ){
             Edge<Weight> e = (Edge<Weight>)item;
             if( e.v() <= e.w() )
                 pq.insert(e);
         }

     // ����һ�����鼯, ���鿴�Ѿ����ʵĽڵ����ͨ���
     UnionFind uf = new UnionFind(graph.V());
     while( !pq.isEmpty() && mst.size() < graph.V() - 1 ){

         // ����С�������δ�С����ȡ�����еı�
         Edge<Weight> e = pq.extractMin();
         // ����ñߵ������˵�����ͨ��, ˵�����������߽�������, �ӵ�������
         if( uf.isConnected( e.v() , e.w() ) )
             continue;

         // ����, ����������ӽ���С������, ͬʱ��Ǳߵ������˵���ͨ
         mst.add( e );
         uf.unionElements( e.v() , e.w() );
     }

     // ������С��������Ȩֵ
     mstWeight = mst.elementAt(0).wt();
     for( int i = 1 ; i < mst.size() ; i ++ )
         mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
 }

 // ������С�����������б�
 Vector<Edge<Weight>> mstEdges(){
     return mst;
 }

 // ������С��������Ȩֵ
 Number result(){
     return mstWeight;
 }


 // ���� Kruskal
 public static void main(String[] args) {

     String filename = "testG1.txt";
     int V = 8;

     SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
     ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

     // Test Kruskal
     System.out.println("Test Kruskal:");
     KruskalMST<Double> kruskalMST = new KruskalMST<Double>(g);
     Vector<Edge<Double>> mst = kruskalMST.mstEdges();
     for( int i = 0 ; i < mst.size() ; i ++ )
         System.out.println(mst.elementAt(i));
     System.out.println("The MST weight is: " + kruskalMST.result());

     System.out.println();
 }
}
