package ShortestPath.ImplementationOfBellmanFord;

import java.util.Stack;
import java.util.Vector;

//ʹ��BellmanFord�㷨�����·��
public class BellmanFord<Weight extends Number & Comparable> {

 private WeightedGraph G;    // ͼ������
 private int s;              // ��ʼ��
 private Number[] distTo;    // distTo[i]�洢����ʼ��s��i�����·������
 Edge<Weight>[] from;        // from[i]��¼���·����, ����i��ı�����һ��
                             // ���������ָ��������·��
 boolean hasNegativeCycle;   // ���ͼ���Ƿ��и�Ȩ��

 // ���캯��, ʹ��BellmanFord�㷨�����·��
 public BellmanFord(WeightedGraph graph, int s){

     G = graph;
     this.s = s;
     distTo = new Number[G.V()];
     from = new Edge[G.V()];
     // ��ʼ�����еĽڵ�s�����ɴ�, ��from��������ʾ
     for( int i = 0 ; i < G.V() ; i ++ )
         from[i] = null;

     // ����distTo[s] = 0, ������from[s]��ΪNULL, ��ʾ��ʼs�ڵ�ɴ��Ҿ���Ϊ0
     distTo[s] = 0.0;
     from[s] = new Edge<Weight>(s, s, (Weight)(Number)(0.0)); // ��������from[s]��������new������, ע��Ҫ������������delete��

     // Bellman-Ford�Ĺ���
     // ����V-1��ѭ��, ÿһ��ѭ���������㵽�������е�, ���ʹ��pass���ɵ������̾���
     for( int pass = 1 ; pass < G.V() ; pass ++ ){

         // ÿ��ѭ���ж����еı߽���һ���ɳڲ���
         // �������бߵķ�ʽ���ȱ������еĶ���, Ȼ����������ж������ڵ����б�
         for( int i = 0 ; i < G.V() ; i ++ ){
             // ʹ������ʵ�ֵ��ڱߵ��������������ж������ڵ����б�
             for( Object item : G.adj(i) ){
                 Edge<Weight> e = (Edge<Weight>)item;
                 // ����ÿһ���������ж�e->v()�ɴ�
                 // ֮�����e->w()��ǰû�е������ ��Ȼ���ǿ��Ը���distTo[e->w()]
                 // ����e->w()��ǰ��Ȼ�����, ����ͨ�����e���ǿ��Ի��һ�����̵ľ���, �����Խ���һ���ɳڲ���, ����Ҳ���Ը���distTo[e->w()]
                 if( from[e.v()] != null && (from[e.w()] == null || distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue()) ){
                     distTo[e.w()] = distTo[e.v()].doubleValue() + e.wt().doubleValue();
                     from[e.w()] = e;
                 }
             }
         }
     }

     hasNegativeCycle = detectNegativeCycle();
 }

 // �ж�ͼ���Ƿ��и�Ȩ��
 boolean detectNegativeCycle(){

     for( int i = 0 ; i < G.V() ; i ++ ){
         for( Object item : G.adj(i) ){
             Edge<Weight> e = (Edge<Weight>)item;
             if( from[e.v()] != null && distTo[e.v()].doubleValue() + e.wt().doubleValue() < distTo[e.w()].doubleValue() )
                 return true;
         }
     }

     return false;
 }

 // ����ͼ���Ƿ��и�Ȩ��
 boolean negativeCycle(){
     return hasNegativeCycle;
 }

 // ���ش�s�㵽w������·������
 Number shortestPathTo( int w ){
     assert w >= 0 && w < G.V();
     assert !hasNegativeCycle;
     assert hasPathTo(w);
     return distTo[w];
 }

 // �жϴ�s�㵽w���Ƿ���ͨ
 boolean hasPathTo( int w ){
     assert( w >= 0 && w < G.V() );
     return from[w] != null;
 }

 // Ѱ�Ҵ�s��w�����·��, ������·�������ıߴ����vec��
 Vector<Edge<Weight>> shortestPath(int w){

     assert w >= 0 && w < G.V() ;
     assert !hasNegativeCycle ;
     assert hasPathTo(w) ;

     // ͨ��from����������ҵ���s��w��·��, ��ŵ�ջ��
     Stack<Edge<Weight>> s = new Stack<Edge<Weight>>();
     Edge<Weight> e = from[w];
     while( e.v() != this.s ){
         s.push(e);
         e = from[e.v()];
     }
     s.push(e);

     // ��ջ������ȡ��Ԫ��, ���˳��Ĵ�s��w��·��
     Vector<Edge<Weight>> res = new Vector<Edge<Weight>>();
     while( !s.empty() ){
         e = s.pop();
         res.add(e);
     }

     return res;
 }

 // ��ӡ����s�㵽w���·��
 void showPath(int w){

     assert( w >= 0 && w < G.V() );
     assert( !hasNegativeCycle );
     assert( hasPathTo(w) );

     Vector<Edge<Weight>> res = shortestPath(w);
     for( int i = 0 ; i < res.size() ; i ++ ){
         System.out.print(res.elementAt(i).v() + " -> ");
         if( i == res.size()-1 )
             System.out.println(res.elementAt(i).w());
     }
 }
}
