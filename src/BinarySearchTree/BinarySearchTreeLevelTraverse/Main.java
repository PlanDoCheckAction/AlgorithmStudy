package BinarySearchTree.BinarySearchTreeLevelTraverse;

public class Main {

    // ���Զ�����������ǰ�к������
    public static void main(String[] args) {

        BST<Integer, Integer> bst = new BST<Integer, Integer>();

        // ȡn��ȡֵ��Χ��[0...m)����������Ž�������������
        int N = 10;
        int M = 100;
        for(int i = 0 ; i < N ; i ++){
            Integer key = new Integer((int)(Math.random()*M));
            // Ϊ�˺������Է���,����valueֵȡ��keyֵһ��
            bst.insert(key, key);
            System.out.print(key + " ");
        }
        System.out.println();

        // ���Զ�����������size()
        System.out.println("size: " + bst.size());
        System.out.println();

        // ���Զ�����������ǰ����� preOrder
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println();

        // ���Զ������������������ inOrder
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println();

        // ���Զ����������ĺ������ postOrder
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println();
        
        // ���Զ����������Ĳ������ levelOrder
        System.out.println("levelOrder: ");
        bst.levelOrder();
        System.out.println();
    }
}