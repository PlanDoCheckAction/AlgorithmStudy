package GraphBasics.ReadGraph;

//����ͨ���ļ���ȡͼ����Ϣ
public class Main {

 public static void main(String[] args) {

     // ʹ������ͼ�Ĵ洢��ʽ��ȡtestG1.txt�ļ�
     String filename = "src/GraphBasics/ReadGraph/testG1.txt";
     SparseGraph g1 = new SparseGraph(13, false);
     ReadGraph readGraph1 = new ReadGraph(g1, filename);
     System.out.println("test G1 in Sparse Graph:");
     g1.show();

     System.out.println();

     DenseGraph g2 = new DenseGraph(13, false);
     ReadGraph readGraph2 = new ReadGraph(g2 , filename );
     System.out.println("test G1 in Dense Graph:");
     g2.show();

     System.out.println();

     // ʹ������ͼ�Ĵ洢��ʽ��ȡtestG2.txt�ļ�
     filename = "src/GraphBasics/ReadGraph/testG2.txt";
     SparseGraph g3 = new SparseGraph(6, false);
     ReadGraph readGraph3 = new ReadGraph(g3, filename);
     System.out.println("test G2 in Sparse Graph:");
     g3.show();

     System.out.println();

     DenseGraph g4 = new DenseGraph(6, false);
     ReadGraph readGraph4 = new ReadGraph(g4, filename);
     System.out.println("test G2 in Dense Graph:");
     g4.show();
 }
}
