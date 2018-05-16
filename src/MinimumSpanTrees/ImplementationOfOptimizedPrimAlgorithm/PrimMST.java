package MinimumSpanTrees.ImplementationOfOptimizedPrimAlgorithm;

import java.util.Vector;

//ʹ���Ż���Prim�㷨��ͼ����С������
public class PrimMST<Weight extends Number & Comparable> {

 private WeightedGraph G;              // ͼ������
 private IndexMinHeap<Weight> ipq;     // ��С������, �㷨�������ݽṹ
 private Edge<Weight>[] edgeTo;        // ���ʵĵ�����Ӧ�ı�, �㷨�������ݽṹ
 private boolean[] marked;             // �������, ���㷨���й����б�ǽڵ�i�Ƿ񱻷���
 private Vector<Edge<Weight>> mst;     // ��С�����������������б�
 private Number mstWeight;             // ��С��������Ȩֵ

 // ���캯��, ʹ��Prim�㷨��ͼ����С������
 public PrimMST(WeightedGraph graph){

     G = graph;
     assert( graph.E() >= 1 );
     ipq = new IndexMinHeap<Weight>(graph.V());

     // �㷨��ʼ��
     marked = new boolean[G.V()];
     edgeTo = new Edge[G.V()];
     for( int i = 0 ; i < G.V() ; i ++ ){
         marked[i] = false;
         edgeTo[i] = null;
     }
     mst = new Vector<Edge<Weight>>();

     // Prim
     visit(0);
     while( !ipq.isEmpty() ){
         // ʹ����С�������ҳ��Ѿ����ʵı���Ȩֵ��С�ı�
         // ��С�������д洢���ǵ������, ͨ����������ҵ����Ӧ�ı�
         int v = ipq.extractMinIndex();
         assert( edgeTo[v] != null );
         mst.add( edgeTo[v] );
         visit( v );
     }

     // ������С��������Ȩֵ
     mstWeight = mst.elementAt(0).wt();
     for( int i = 1 ; i < mst.size() ; i ++ )
         mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
 }

 // ���ʽڵ�v
 void visit(int v){

     assert !marked[v];
     marked[v] = true;

     // ���ͽڵ�v�����ӵ�δ���ʵ���һ�˵�, ����֮�����ӵı�, ������С����
     for( Object item : G.adj(v) ){
         Edge<Weight> e = (Edge<Weight>)item;
         int w = e.other(v);
         // ����ߵ���һ�˵�δ������
         if( !marked[w] ){
             // �����û�п��ǹ�����˵�, ֱ�ӽ�����˵����֮�����ӵı߼���������
             if( edgeTo[w] == null ){
                 edgeTo[w] = e;
                 ipq.insert(w, e.wt());
             }
             // ���������������˵�, �����ڵı߱�֮ǰ���ǵı߸���, ������滻
             else if( e.wt().compareTo(edgeTo[w].wt()) < 0 ){
                 edgeTo[w] = e;
                 ipq.change(w, e.wt());
             }
         }
     }

 }

 // ������С�����������б�
 Vector<Edge<Weight>> mstEdges(){
     return mst;
 }

 // ������С��������Ȩֵ
 Number result(){
     return mstWeight;
 }


 // ���� Prim
 public static void main(String[] args) {

     String filename = "testG1.txt";
     int V = 8;

     SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
     ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

     // Test Prim MST
     System.out.println("Test Prim MST:");
     PrimMST<Double> primMST = new PrimMST<Double>(g);
     Vector<Edge<Double>> mst = primMST.mstEdges();
     for( int i = 0 ; i < mst.size() ; i ++ )
         System.out.println(mst.elementAt(i));
     System.out.println("The MST weight is: " + primMST.result());

     System.out.println();
 }
}

