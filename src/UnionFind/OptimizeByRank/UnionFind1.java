package UnionFind.OptimizeByRank;

//���ǵĵ�һ��Union-Find
public class UnionFind1 {

 private int[] id;    // ���ǵĵ�һ��Union-Find���ʾ���һ������
 private int count;   // ���ݸ���

 public UnionFind1(int n) {
     count = n;
     id = new int[n];
     // ��ʼ��, ÿһ��id[i]ָ���Լ�, û�кϲ���Ԫ��
     for (int i = 0; i < n; i++)
         id[i] = i;
 }

 // ���ҹ���, ����Ԫ��p����Ӧ�ļ��ϱ��
 // O(1)���Ӷ�
 private int find(int p) {
     assert p >= 0 && p < count;
     return id[p];
 }

 // �鿴Ԫ��p��Ԫ��q�Ƿ�����һ������
 // O(1)���Ӷ�
 public boolean isConnected(int p, int q) {
     return find(p) == find(q);
 }

 // �ϲ�Ԫ��p��Ԫ��q�����ļ���
 // O(n) ���Ӷ�
 public void unionElements(int p, int q) {

     int pID = find(p);
     int qID = find(q);

     if (pID == qID)
         return;

     // �ϲ�������Ҫ����һ������Ԫ��, ������Ԫ�ص��������ϱ�źϲ�
     for (int i = 0; i < count; i++)
         if (id[i] == pID)
             id[i] = qID;
 }
}
