package UnionFind.QuickFind;

public class Main {

    // ����UF1
    public static void main(String[] args) {

        // ʹ��10000�����ݹ�ģ
        int n = 10000;

        // ��ȻisConnectedֻ��ҪO(1)��ʱ��, ������union������ҪO(n)��ʱ��
        // ������Թ��̵��㷨���Ӷ���O(n^2)��
        UnionFindTestHelper.testUF1(n);
    }
}
