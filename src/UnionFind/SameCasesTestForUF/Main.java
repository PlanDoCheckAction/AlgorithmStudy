package UnionFind.SameCasesTestForUF;

public class Main {

    // �Ա�UF1, UF2, UF3, UF4, UF5��UF6��ʱ������
    // ������, ���Ƕ��ڲ�ͬ��UnionFind��ʵ��, ʹ����ͬ�Ĳ�������, �ò��Խ������׼ȷ
    public static void main(String[] args) {

        // ʹ��5000000�����ݹ�ģ
        int n = 5000000;

        // ����unionElements�Ĳ�������
        Pair<Integer, Integer>[] unionTest = new Pair[n];
        for(int i = 0 ; i < n ; i ++){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            unionTest[i] = new Pair<Integer, Integer>(a, b);
        }

        // ����isConnected�Ĳ�������
        Pair<Integer, Integer>[] connectTest = new Pair[n];
        for(int i = 0 ; i < n ; i ++){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            connectTest[i] = new Pair<Integer, Integer>(a, b);
        }

        // �������ǵ�UF1 ~ UF6

        // 100�����ݶ���UF1��UF2��˵̫����, ���ٲ���
//        UnionFind1 uf1 = new UnionFind1(n);
//        UnionFindTestHelper.testUF("UF1", uf1, unionTest, connectTest);
//
//        UnionFind2 uf2 = new UnionFind2(n);
//        UnionFindTestHelper.testUF("UF2", uf2, unionTest, connectTest);

        UnionFind3 uf3 = new UnionFind3(n);
        UnionFindTestHelper.testUF("UF3", uf3, unionTest, connectTest);

        UnionFind4 uf4 = new UnionFind4(n);
        UnionFindTestHelper.testUF("UF4", uf4, unionTest, connectTest);

        UnionFind5 uf5 = new UnionFind5(n);
        UnionFindTestHelper.testUF("UF5", uf5, unionTest, connectTest);

        UnionFind6 uf6 = new UnionFind6(n);
        UnionFindTestHelper.testUF("UF6", uf6, unionTest, connectTest);
    }
}
