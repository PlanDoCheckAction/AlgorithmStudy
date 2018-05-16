package GraphBasics.DFSAndComponents;

//����Ȩͼ����ͨ����
//һ����������ͨͼ����һ����ͨ����
public class Components {

 Graph G;                    // ͼ������
 private boolean[] visited;  // ��¼dfs�Ĺ����нڵ��Ƿ񱻷���
 private int ccount;         // ��¼��ͨ��������
 private int[] id;           // ÿ���ڵ�����Ӧ����ͨ�������

 // ͼ��������ȱ���
 void dfs( int v ){

     visited[v] = true;
     id[v] = ccount;

     for( int i: G.adj(v) ){
         if( !visited[i] )
             dfs(i);
     }
 }

 // ���캯��, �����Ȩͼ����ͨ����
 public Components(Graph graph){

     // �㷨��ʼ��
     G = graph;
     visited = new boolean[G.V()];
     id = new int[G.V()];
     ccount = 0;
     for( int i = 0 ; i < G.V() ; i ++ ){
         visited[i] = false;
         id[i] = -1;
     }

     // ��ͼ����ͨ����
     for( int i = 0 ; i < G.V() ; i ++ )
         if( !visited[i] ){
             dfs(i);
             ccount ++;
         }
 }

 // ����ͼ����ͨ��������
 int count(){
     return ccount;
 }

 // ��ѯ��v�͵�w�Ƿ���ͨ
 boolean isConnected( int v , int w ){
     assert v >= 0 && v < G.V();
     assert w >= 0 && w < G.V();
     return id[v] == id[w];
 }
}

