package BinarySearchTree.TheDisadvantagesOfBinarySearchTreeAndMoreTrees;

import java.util.Collections;
import java.util.Vector;

public class Main {

	// ʵ������������ľ�����
    public static void main(String[] args) {

        // ����ʹ���ı�����С�Ĺ����������Խ�������:)
        String filename = "src/BinarySearchTree/TheDisadvantagesOfBinarySearchTreeAndMoreTrees/communist.txt";
        Vector<String> words = new Vector<String>();

        if(FileOperations.readFile(filename, words)){

            System.out.println( "There are totally " + words.size() + " words in " + filename );
            System.out.println();


            // ����1: ���ǰ����ı�ԭ��˳����������������
            long startTime = System.currentTimeMillis();
            BST<String, Integer> bst = new BST<String, Integer>();
            for (String word: words) {
                Integer res = bst.search(word);
                if (res == null)
                    bst.insert(word, new Integer(1));
                else
                    bst.insert(word, res + 1);
            }

            // ���ǲ鿴uniteһ�ʵĴ�Ƶ
            if( bst.contain("unite") )
                System.out.println("'unite' : " + bst.search("unite") );
            else
                System.out.println("No word 'unite' in " + filename);

            long endTime = System.currentTimeMillis();

            System.out.println("BST , time: " + (endTime - startTime) + "ms.");
            System.out.println();


            // ����2: ���ǰ����ı�ԭ��˳�����˳����ұ�
            startTime = System.currentTimeMillis();
            SST<String, Integer> sst = new SST<String, Integer>();
            for (String word: words) {
                Integer res = sst.search(word);
                if (res == null)
                    sst.insert(word, new Integer(1));
                else
                    sst.insert(word, res + 1);
            }

            // ���ǲ鿴uniteһ�ʵĴ�Ƶ
            if( sst.contain("unite") )
                System.out.println("'unite' : " + sst.search("unite") );
            else
                System.out.println("No word 'unite' in " + filename);

            endTime = System.currentTimeMillis();
            System.out.println("SST , time: " + (endTime - startTime) + "ms.");
            System.out.println();


            // ����3: ���ǽ�ԭ�ı������������������, �鿴��Ч��
            startTime = System.currentTimeMillis();
            BST<String, Integer> bst2 = new BST<String, Integer>();
            Collections.sort(words);
            for (String word: words) {
                Integer res = bst2.search(word);
                if (res == null)
                    bst2.insert(word, new Integer(1));
                else
                    bst2.insert(word, res + 1);
            }

            // ���ǲ鿴uniteһ�ʵĴ�Ƶ
            if( bst.contain("unite") )
                System.out.println("'unite' : " + bst2.search("unite") );
            else
                System.out.println("No word 'unite' in " + filename);

            endTime = System.currentTimeMillis();
            System.out.println("BST2 , time: " + (endTime - startTime) + "ms.");
        }
    }
}
