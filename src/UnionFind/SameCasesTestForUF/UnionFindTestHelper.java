package UnionFind.SameCasesTestForUF;

//���Բ��鼯
public class UnionFindTestHelper {

 // ���ǵĲ����಻������ʵ��
 private UnionFindTestHelper(){}

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

 // ���Ե����汾�Ĳ��鼯, ����Ԫ�ظ���Ϊn, �����߼���֮ǰ����ȫһ����
 public static void testUF3( int n ){

     UnionFind3 uf = new UnionFind3(n);

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
     System.out.println("UF3, " + 2*n + " ops, " + (endTime-startTime) + "ms");
 }

 // ���Ե��İ汾�Ĳ��鼯, ����Ԫ�ظ���Ϊn, �����߼���֮ǰ����ȫһ����
 public static void testUF4( int n ){

     UnionFind4 uf = new UnionFind4(n);

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
     System.out.println("UF4, " + 2*n + " ops, " + (endTime-startTime) + "ms");
 }

 // ���Ե���汾�Ĳ��鼯, ����Ԫ�ظ���Ϊn, �����߼���֮ǰ����ȫһ����
 public static void testUF5( int n ){

     UnionFind5 uf = new UnionFind5(n);

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
     System.out.println("UF5, " + 2*n + " ops, " + (endTime-startTime) + "ms");
 }

 // ���Ե����汾�Ĳ��鼯, ����Ԫ�ظ���Ϊn, �����߼���֮ǰ����ȫһ����
 public static void testUF6( int n ){

     UnionFind6 uf = new UnionFind6(n);

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
     System.out.println("UF6, " + 2*n + " ops, " + (endTime-startTime) + "ms");
 }

 // ʹ����ͬ�Ĳ������ݲ���UF��ִ��Ч��
 public static void testUF(String ufName, UF uf, Pair<Integer,Integer>[] unionTest, Pair<Integer,Integer>[] connectTest){

     long startTime = System.currentTimeMillis();
     for( int i = 0 ; i < unionTest.length ; i ++ ){
         int a = unionTest[i].a();
         int b = unionTest[i].b();
         uf.unionElements(a,b);
     }
     for(int i = 0 ; i < connectTest.length ; i ++ ){
         int a = connectTest[i].a();
         int b = connectTest[i].b();
         uf.isConnected(a,b);
     }
     long endTime = System.currentTimeMillis();

     System.out.print( ufName + " with " + unionTest.length + " unionElements ops, ");
     System.out.print( connectTest.length + " isConnected ops, ");
     System.out.println( (endTime-startTime) + "ms");
 }
}