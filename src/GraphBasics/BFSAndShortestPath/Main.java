package GraphBasics.BFSAndShortestPath;

public class Main {

    // ������Ȩͼ���·���㷨
    public static void main(String[] args) {

        String filename = "src/GraphBasics/BFSAndShortestPath/testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        // �Ƚ�ʹ��������ȱ����͹�����ȱ������·���Ĳ�ͬ
        // ������ȱ�����õ�����Ȩͼ�����·��
        Path dfs = new Path(g,0);
        System.out.print("DFS : ");
        dfs.showPath(6);

        ShortestPath bfs = new ShortestPath(g,0);
        System.out.print("BFS : ");
        bfs.showPath(6);
    }
}
