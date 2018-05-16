package BinarySearchTree.BinarySearchTreeRemoveMinAndMax;

public class Main {

	// ���Զ����������е�removeMin��removeMax
    public static void main(String[] args) {

        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        // ȡn��ȡֵ��Χ��[0...m)����������Ž�������������
        int N = 100;
        int M = 100;
        for(int i = 0 ; i < N ; i ++){
            Integer key = new Integer((int)(Math.random()*M));
            // Ϊ�˺������Է���,����valueֵȡ��keyֵһ��
            bst.insert(key, key);
        }
        // ע��, ����������ɵ��������ظ�, ����bst�е����������������С��n��

        // ���� removeMin
        // �����Ԫ��Ӧ���Ǵ�С�������е�
        System.out.println("Test removeMin: ");
        while( !bst.isEmpty() ){
            System.out.print("min: " + bst.minimum() + " , ");
            bst.removeMin();
            System.out.println("After removeMin, size = " + bst.size() );
        }
        System.out.println();


        for(int i = 0 ; i < N ; i ++){
            Integer key = new Integer((int)(Math.random()*M));
            // Ϊ�˺������Է���,����valueֵȡ��keyֵһ��
            bst.insert(key, key);
        }
        // ע��, ����������ɵ��������ظ�, ����bst�е����������������С��n��

        // ���� removeMax
        // �����Ԫ��Ӧ���ǴӴ�С���е�
        System.out.println("Test removeMax: ");
        while( !bst.isEmpty() ){
            System.out.print("max: " + bst.maximum() + " , ");
            bst.removeMax();
            System.out.println("After removeMax, size = " + bst.size() );
        }
    }
}