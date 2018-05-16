package MinimumSpanTrees.WeightedGraph;

public class Main {

    // ����ͨ���ļ���ȡͼ����Ϣ
    public static void main(String[] args) {

        // ʹ������ͼ�Ĵ洢��ʽ��ȡtestG1.txt�ļ�
        String filename = "src/MinimumSpanTrees/WeightedGraph/testG1.txt";
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename);
        System.out.println("test G1 in Sparse Weighted Graph:");
        g1.show();

        System.out.println();

        DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2 , filename );
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();
    }
}