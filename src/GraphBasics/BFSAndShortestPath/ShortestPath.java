package GraphBasics.BFSAndShortestPath;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {

    private Graph G;   // ͼ������
    private int s;     // ��ʼ��
    private boolean[] visited;  // ��¼dfs�Ĺ����нڵ��Ƿ񱻷���
    private int[] from;         // ��¼·��, from[i]��ʾ���ҵ�·����i����һ���ڵ�
    private int[] ord;          // ��¼·���нڵ�Ĵ���ord[i]��ʾi�ڵ���·���еĴ���


    // ���캯��, Ѱ·�㷨, Ѱ��ͼgraph��s�㵽�������·��
    public ShortestPath(Graph graph, int s){

        // �㷨��ʼ��
        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for( int i = 0 ; i < G.V() ; i ++ ){
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;

        // ����ͼ���·���㷨, ��s��ʼ������ȱ�������ͼ
        LinkedList<Integer> q = new LinkedList<Integer>();

        q.push( s );
        visited[s] = true;
        ord[s] = 0;
        while( !q.isEmpty() ){
            int v = q.pop();
            for( int i : G.adj(v) )
                if( !visited[i] ){
                    q.push(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
        }
    }

    // ��ѯ��s�㵽w���Ƿ���·��
    public boolean hasPath(int w){
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // ��ѯ��s�㵽w���·��, �����vec��
    public Vector<Integer> path(int w){

        assert hasPath(w) ;

        Stack<Integer> s = new Stack<Integer>();
        // ͨ��from����������ҵ���s��w��·��, ��ŵ�ջ��
        int p = w;
        while( p != -1 ){
            s.push(p);
            p = from[p];
        }

        // ��ջ������ȡ��Ԫ��, ���˳��Ĵ�s��w��·��
        Vector<Integer> res = new Vector<Integer>();
        while( !s.empty() )
            res.add( s.pop() );

        return res;
    }

    // ��ӡ����s�㵽w���·��
    public void showPath(int w){

        assert hasPath(w) ;

        Vector<Integer> vec = path(w);
        for( int i = 0 ; i < vec.size() ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }

    // �鿴��s�㵽w������·������
    // ����s��w���ɴ����-1
    public int length(int w){
        assert w >= 0 && w < G.V();
        return ord[w];
    }
}