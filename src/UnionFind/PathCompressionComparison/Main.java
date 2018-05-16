package UnionFind.PathCompressionComparison;

public class Main {

    public static void main(String[] args) {

        // Ϊ���ܹ�����ؿ�������·��ѹ���㷨�Ĳ�ͬ,����ֻʹ����5��Ԫ�صĲ��鼯��������
        int n = 5;

        UnionFind5 uf5 = new UnionFind5(n);
        UnionFind6 uf6 = new UnionFind6(n);

        // ���ǽ����ǵĲ��鼯��ʼ���ó����µ�����
        //            0
        //           /
        //          1
        //         /
        //        2
        //       /
        //      3
        //     /
        //    4
        for(int i = 1 ; i < n ; i ++){
            uf5.parent[i] = i-1;
            uf6.parent[i] = i-1;
        }

        // ����, ���Ƕ��������鼯����find(4)����
        uf5.find(n-1);
        uf6.find(n-1);

        // ͨ��show, ���ǿ��Կ���, ʹ�õ�����·��ѹ��, ���ǵĲ��鼯����������:
        //     0
        //    / \
        //   1   2
        //      / \
        //     3   4
        System.out.println("UF implements Path Compression by recursion:");
        uf5.show();

        System.out.println();

        // ʹ�õݹ��·��ѹ��, ���ǵĲ��鼯����������:
        //     0
        //  / / \ \
        // 1 2   3 4
        System.out.println("UF implements Path Compression without recursion:");
        uf6.show();

        // ���Ҳ���Ե���n��ֵ, ��������Ĳ�ͬ:)
    }
}
