package BinarySearchTree.BinarySearchTreeSearch;

import java.util.Vector;

public class Main {

	// ���Զ�����������˳����ұ�֮������ܲ��
	// ����������������ԶԶ����˳����ұ�
	public static void main(String[] args) {

		// ʹ��ʥ����Ϊ���ǵĲ�������
		String filename = "src/BinarySearchTree/BinarySearchTreeSearch/bible.txt";
		Vector<String> words = new Vector<String>();
		if (FileOperations.readFile(filename, words)) {
			System.out.println("There are totally " + words.size() + " words in " + filename);
			System.out.println();

			// ���� BST
			long startTime = System.currentTimeMillis();

			// ͳ��ʥ�������дʵĴ�Ƶ
			// ע: �����Ƶͳ�Ʒ���Լ�ª, û�п��Ǻܶ��ı������е���������
			// ������ֻ�����ܲ�����
			BST<String, Integer> bst = new BST<String, Integer>();
			for (String word : words) {
				Integer res = bst.search(word);
				if (res == null)
					bst.insert(word, new Integer(1));
				else
					bst.insert(word, res + 1);
			}

			// ���ʥ����godһ�ʳ��ֵ�Ƶ��
			if (bst.contain("god"))
				System.out.println("'god' : " + bst.search("god"));
			else
				System.out.println("No word 'god' in " + filename);

			long endTime = System.currentTimeMillis();
			System.out.println("BST , time: " + (endTime - startTime) + "ms.");

			System.out.println();

			// ����˳����ұ� SST
			startTime = System.currentTimeMillis();

			// ͳ��ʥ�������дʵĴ�Ƶ
			// ע: �����Ƶͳ�Ʒ���Լ�ª, û�п��Ǻܶ��ı������е���������
			// ������ֻ�����ܲ�����
			SST<String, Integer> sst = new SST<String, Integer>();
			for (String word : words) {
				Integer res = sst.search(word);
				if (res == null)
					sst.insert(word, new Integer(1));
				else
					sst.insert(word, res + 1);
			}

			// ���ʥ����godһ�ʳ��ֵ�Ƶ��
			if (sst.contain("god"))
				System.out.println("'god' : " + sst.search("god"));
			else
				System.out.println("No word 'god' in " + filename);

			endTime = System.currentTimeMillis();
			System.out.println("SST , time: " + (endTime - startTime) + "ms.");

		}
	}
}
