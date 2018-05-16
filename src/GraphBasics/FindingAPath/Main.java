package GraphBasics.FindingAPath;

public class Main {

    // ≤‚ ‘—∞¬∑À„∑®
    public static void main(String[] args) {

        String filename = "src/GraphBasics/FindingAPath/testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}
