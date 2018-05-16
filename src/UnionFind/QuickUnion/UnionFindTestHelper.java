package UnionFind.QuickUnion;

//���Բ��鼯
public class UnionFindTestHelper {

 // ���Ե�һ�汾�Ĳ��鼯, ����Ԫ�ظ���Ϊn
 public static void testUF1( int n ){

     UnionFind1 uf = new UnionFind1(n);

     long startTime = System.currentTimeMillis();

     // ����n�β���, ÿ�����ѡ������Ԫ�ؽ��кϲ�����
     for( int i = 0 ; i < n ; i ++ ){
         int a = (int)(Math.random()*n);
         int b = (int)(Math.random()*n);
         uf.unionElements(a,b);
     }
     // �ٽ���n�β���, ÿ�����ѡ������Ԫ��, ��ѯ�����Ƿ�ͬ��һ������
     for(int i = 0 ; i < n ; i ++ ){
         int a = (int)(Math.random()*n);
         int b = (int)(Math.random()*n);
         uf.isConnected(a,b);
     }
     long endTime = System.currentTimeMillis();

     // ��ӡ�������2n�������ĺ�ʱ
     System.out.println("UF1, " + 2*n + " ops, " + (endTime-startTime) + "ms");
 }

 // ���Եڶ��汾�Ĳ��鼯, ����Ԫ�ظ���Ϊn, �����߼���֮ǰ����ȫһ����
 // ˼��һ��: ��������������������?
 // ��������γ̲������ģʽ�γ�, ������Ͳ�����������ص����⽲���ˡ���������ҵ�˼����:)
 public static void testUF2( int n ){

     UnionFind2 uf = new UnionFind2(n);

     long startTime = System.currentTimeMillis();

     // ����n�β���, ÿ�����ѡ������Ԫ�ؽ��кϲ�����
     for( int i = 0 ; i < n ; i ++ ){
         int a = (int)(Math.random()*n);
         int b = (int)(Math.random()*n);
         uf.unionElements(a,b);
     }
     // �ٽ���n�β���, ÿ�����ѡ������Ԫ��, ��ѯ�����Ƿ�ͬ��һ������
     for(int i = 0 ; i < n ; i ++ ){
         int a = (int)(Math.random()*n);
         int b = (int)(Math.random()*n);
         uf.isConnected(a,b);
     }
     long endTime = System.currentTimeMillis();

     // ��ӡ�������2n�������ĺ�ʱ
     System.out.println("UF2, " + 2*n + " ops, " + (endTime-startTime) + "ms");
 }
}